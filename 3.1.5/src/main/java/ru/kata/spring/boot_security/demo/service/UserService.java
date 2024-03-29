package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

@Component
public interface UserService extends UserDetailsService {
    void saveUser(User user);
    void deleteUser(Long id);
    void editUser(long id, User user);
    User getById(Long id);
    List<User> getListUsers();
    User findByEmail(String username);
}