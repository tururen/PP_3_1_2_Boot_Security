package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> getAll();

    void save(User user);

    void remove(Long id);

    User getById(Long id);

    User findByUserName(String username);

    List<Role> listRoles();

}
