package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PayoutDTO {
    private Integer userId;
    private Integer paidAmount;
    private Integer owedAmount;

    public Integer getOwedAmount() {
        return owedAmount;
    }

    public void setOwedAmount(Integer owedAmount) {
        this.owedAmount = owedAmount;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
