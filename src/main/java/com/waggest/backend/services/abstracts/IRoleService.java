package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.Role;
import org.springframework.data.domain.Page;

public interface IRoleService {

    Page<Role> findAll(int page);

    Role findById(Long id);

    Role create(Role role);

    Role update(Role role, Role updatedRole);

    void delete(Role role);
}
