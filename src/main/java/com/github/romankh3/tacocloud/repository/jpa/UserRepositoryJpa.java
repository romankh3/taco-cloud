package com.github.romankh3.tacocloud.repository.jpa;

import com.github.romankh3.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJpa extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
