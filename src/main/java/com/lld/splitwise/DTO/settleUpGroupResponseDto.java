package com.lld.splitwise.DTO;

import com.lld.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class settleUpGroupResponseDto {
    List<Expense> expenses;
}
