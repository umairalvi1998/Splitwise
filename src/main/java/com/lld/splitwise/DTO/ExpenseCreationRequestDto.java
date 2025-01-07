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
    Long groupId;
    private List<PayoutDTO> payoutDTOS; // describes which user owes what.

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<PayoutDTO> getPayoutDTOS() {
        return payoutDTOS;
    }

    public void setPayoutDTOS(List<PayoutDTO> payoutDTOS) {
        this.payoutDTOS = payoutDTOS;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
