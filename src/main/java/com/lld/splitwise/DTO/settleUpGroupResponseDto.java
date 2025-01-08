package com.lld.splitwise.DTO;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class settleUpGroupResponseDto {
    private String transactionDetails;

    public String getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(String transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
