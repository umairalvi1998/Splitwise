package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class settleUpGroupRequestDto {
    private Long groupId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
