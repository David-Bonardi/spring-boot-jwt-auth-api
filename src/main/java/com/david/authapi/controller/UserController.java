package com.david.authapi.controller;

import com.david.authapi.model.User;
import com.david.authapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//Recebe requisições HTTP, extrai dados(@RequestBody), chama o Services e retorna uma reposta
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.createUser( user);
    }

    @GetMapping
    public List<User> GetAll() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User GetById(@PathVariable Long id) {
        return service.getByIdService(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User updateUser) {
        return service.update(id, updateUser);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        String token = service.login(user.getUsername(), user.getPassword());

        return Map.of("token", token);
    }
}
