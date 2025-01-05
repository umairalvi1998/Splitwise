package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.settleUpGroupRequestDto;
import com.lld.splitwise.DTO.settleUpGroupResponseDto;
import com.lld.splitwise.DTO.settleUpUserRequestDto;
import com.lld.splitwise.DTO.settleUpUserResponseDto;
import com.lld.splitwise.services.settleUpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settleUp")
public class settleUpController {

    settleUpService settleUpService;

    public settleUpController(settleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public settleUpGroupResponseDto settleUpGroup(settleUpGroupRequestDto requestDto) {
        return null;
    }

    public settleUpUserResponseDto settleUpUser(settleUpUserRequestDto requestDto) {
        return null;
    }
}
