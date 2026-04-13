package com.david.authapi.service;
import com.david.authapi.model.User;
import com.david.authapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
//Parte de lógica(segurança, validação, regras de negócio e etc)
@Service
public class UserService {
    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;
    public UserService(UserRepository repo, BCryptPasswordEncoder encoder, JwtService jwtService) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public User createUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<User> getUsers() {
        return repo.findAll();
    }

    public User getByIdService(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public User update(long id, User updateUser) {
        User user = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(updateUser.getUsername());
        user.setPassword(encoder.encode(updateUser.getPassword()));

        return repo.save(user);
    }

    public String login(String username, String password) {
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if(!encoder.matches(password, user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }
        return jwtService.generateToken(user.getUsername());
    }
}
