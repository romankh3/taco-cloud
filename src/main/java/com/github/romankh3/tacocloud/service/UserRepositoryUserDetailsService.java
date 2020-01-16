package com.github.romankh3.tacocloud.service;

import static java.util.Optional.ofNullable;

import com.github.romankh3.tacocloud.repository.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    private UserRepositoryJpa userRepository;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepositoryJpa userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' not found"));
    }
}
