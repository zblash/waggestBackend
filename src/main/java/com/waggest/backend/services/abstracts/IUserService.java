package com.waggest.backend.services.abstracts;

import com.waggest.backend.models.User;
import org.springframework.data.domain.Page;

public interface IUserService {

    Page<User> findAll(int page);

    User findById(Long id);

    User create(User user);

    User update(User user, User updatedUser);

    void delete(User user);

    User findByUserName(String userName);
}
