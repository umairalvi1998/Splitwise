package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.AddMemberRequestDto;
import com.lld.splitwise.DTO.RegisterUserRequestDto;
import com.lld.splitwise.DTO.RegisterUserResponseDto;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.Group;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.userRepository;
import com.lld.splitwise.services.GroupService;
import com.lld.splitwise.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
     UserService userService;
     GroupService groupService;

     public UserController(UserService userService) {
         this.userService = userService;
     }

     @PostMapping("/register")
    public RegisterUserResponseDto  registerUser(@RequestBody  RegisterUserRequestDto requestDto) {

         RegisterUserResponseDto responseDto = new RegisterUserResponseDto();
       User user =  userService.RegisterUser(requestDto);
       responseDto.setUser(user);
       return responseDto;

    }


}
