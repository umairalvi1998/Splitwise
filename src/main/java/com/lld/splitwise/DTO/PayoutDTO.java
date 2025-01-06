package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayoutDTO {
    private Integer userId;
    private Integer paidAmount;
    private Integer owedAmount;
}
