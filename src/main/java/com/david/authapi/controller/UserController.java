package com.david.authapi.controller;

import com.david.authapi.dto.CreateUserRequest;
import com.david.authapi.dto.UpdateUserRequest;
import com.david.authapi.dto.UserResponse;
import com.david.authapi.model.User;
import com.david.authapi.service.UserService;
import jakarta.validation.Valid;
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
    public UserResponse create(@Valid @RequestBody CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User savedUser = service.createUser(user);
        return new UserResponse(savedUser.getId(), savedUser.getUsername()  );
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return service.getUsers().stream()
                .map(user -> new UserResponse(user.getId(), user.getUsername()))
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponse getById(@Valid @PathVariable Long id) {
        User user = service.getByIdService(id);
        return new UserResponse(user.getId(), user.getUsername());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User updated = service.update(id, user);
        return new UserResponse(updated.getId(), updated.getUsername());
    }
}
