package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.settleUpGroupRequestDto;
import com.lld.splitwise.DTO.settleUpGroupResponseDto;
import com.lld.splitwise.DTO.settleUpUserRequestDto;
import com.lld.splitwise.DTO.settleUpUserResponseDto;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Transaction;
import com.lld.splitwise.services.settleUpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/settleUp")
public class settleUpController {

    settleUpService settleUpService;

    public settleUpController(settleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    @GetMapping("/group")
    public ResponseEntity<settleUpGroupResponseDto> settleUpGroup(@RequestBody  settleUpGroupRequestDto requestDto) throws GroupNotFoundException {
        settleUpGroupResponseDto responseDto = new settleUpGroupResponseDto();
        String transactionDetails = settleUpService.settleUpGroup(requestDto.getGroupId());
        responseDto.setTransactionDetails(transactionDetails);
       return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/user")
    public settleUpUserResponseDto settleUpUser(settleUpUserRequestDto requestDto) throws userNotFoundException {

        settleUpUserResponseDto responseDto = new settleUpUserResponseDto();
        List<Transaction> expenses = settleUpService.settleUpUser(requestDto.getUserId());
        responseDto.setExpenses(expenses);

        return responseDto;
    }
}
