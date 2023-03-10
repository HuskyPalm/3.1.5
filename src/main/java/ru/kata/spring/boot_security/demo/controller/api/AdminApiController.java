package ru.kata.spring.boot_security.demo.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Person;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminApiController {
    private final UserService userService;
    private final RoleService roleService;

    public AdminApiController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Person>> allUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        userService.delete(id);
        return ResponseEntity.ok("delete successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") long id, Person person) {
        userService.update(id, person);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Person> create(Person person) {
        userService.add(person);
        return ResponseEntity.ok(person);
    }
}
