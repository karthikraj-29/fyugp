package com.tst.fyugp.service.auth;

import com.tst.fyugp.model.User;
import com.tst.fyugp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private  final UserRepo repo;
    public UserService(UserRepo repo) {
        this.repo = repo;
    }
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}