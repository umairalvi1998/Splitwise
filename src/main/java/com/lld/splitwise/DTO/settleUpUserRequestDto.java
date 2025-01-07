package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class settleUpUserRequestDto {

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
