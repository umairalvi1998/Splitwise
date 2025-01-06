package com.lld.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "SplitWiseGroups")
public class Group  extends  BaseModel {

    private String description;
    @ManyToMany
    private List<User> members;

    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses;

    @ManyToOne
    private User createdBy;
}
