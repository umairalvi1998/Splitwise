package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ExpenseCreationRequestDto {

    int amount;
    String description;
    Long userId;
    private List<PayoutDTO> payoutDTOS; // describes which user owes what.

}
