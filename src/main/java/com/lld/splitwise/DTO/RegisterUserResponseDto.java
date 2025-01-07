package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;
import com.lld.splitwise.models.User;

@Getter
@Setter
public class RegisterUserResponseDto {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
