package com.lld.splitwise.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name = "users")
public class User extends  BaseModel {
    String name;
    String email;
    String password;
}
