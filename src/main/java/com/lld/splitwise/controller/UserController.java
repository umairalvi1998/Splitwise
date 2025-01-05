package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.AddMemberRequestDto;
import com.lld.splitwise.DTO.RegisterUserRequestDto;
import com.lld.splitwise.DTO.RegisterUserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    public RegisterUserResponseDto  registerUser(RegisterUserRequestDto requestDto) {
        return null;
    }

    public ResponseEntity<Void> addMember(AddMemberRequestDto requestDto) {
        return null;
    }
}
