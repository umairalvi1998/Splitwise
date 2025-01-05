package com.lld.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private List<Expense> expenses;

    @ManyToOne
    private User createdBy;
}
