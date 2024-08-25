package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> findAll();

    User getByID(Long id);

    void save(User user);

     void delete(User user);

    void update(User user);
}
