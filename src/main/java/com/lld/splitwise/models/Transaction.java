package com.lld.splitwise.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class Transaction extends BaseModel {


    private Integer amount;
    private List<User> parties; // [0-borrowe] [1-Lender]
    private Group group;

    public Transaction() {
    }

    public Transaction(Integer amount, List<User> parties, Group group) {
        this.amount = amount;
        this.parties = parties;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Paid Amount : " + amount + " By : "
                + parties.get(0).getName() + " To : " + parties.get(1).getName();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<User> getParties() {
        return parties;
    }

    public void setParties(List<User> parties) {
        this.parties = parties;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
