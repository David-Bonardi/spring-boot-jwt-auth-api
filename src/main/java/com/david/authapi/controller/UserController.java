package com.david.authapi.controller;

import com.david.authapi.model.User;
import com.david.authapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<User> getAll() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
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
}
