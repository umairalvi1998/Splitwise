package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequestDto {

    Long adminId;
    Long groupId;
    Long userId;
}
