package com.lld.splitwise.services;

import com.lld.splitwise.DTO.RegisterUserRequestDto;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.userRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    userRepository userRepo;

    UserService(userRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User RegisterUser(RegisterUserRequestDto requestDto) {

        String name = requestDto.getUserName();
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        User user = userRepo.findByEmail(email);
        if (user != null) {
            throw new RuntimeException("User Already Exists");
        }
        else {
            user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
           return  userRepo.save(user);
        }
    }
}
