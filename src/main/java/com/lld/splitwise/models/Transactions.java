package com.lld.splitwise.models;


import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class Transactions extends BaseModel {


    private Integer amount;
    private List<User> parties; // [0-borrowe] [1-Lender]
    private Group group;

    public Transactions() {
    }

    public Transactions(Integer amount, List<User> parties, Group group) {
        this.amount = amount;
        this.parties = parties;
        this.group = group;
    }

}
