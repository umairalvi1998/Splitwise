package com.lld.splitwise.Command;

import com.lld.splitwise.DTO.RegisterUserRequestDto;
import com.lld.splitwise.DTO.RegisterUserResponseDto;
import com.lld.splitwise.controller.UserController;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command {

    private UserController userController;

    public RegisterUserCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeywords.registerCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        RegisterUserRequestDto requestDto = new RegisterUserRequestDto();

        requestDto.setUserName(words.get(1));
        requestDto.setPhoneNumber(words.get(2));
        requestDto.setPassword(words.get(3));

        RegisterUserResponseDto response = userController.registerUser(requestDto);


    }
}
