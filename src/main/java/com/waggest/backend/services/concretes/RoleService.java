package com.waggest.backend.services.concretes;

import com.waggest.backend.models.Role;
import com.waggest.backend.repositories.RoleRepository;
import com.waggest.backend.services.abstracts.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Page<Role> findAll(int page) {
        return roleRepository.findAll(PageRequest.of(page,10));
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role, Role updatedRole) {
        role.setName(updatedRole.getName());
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
}
