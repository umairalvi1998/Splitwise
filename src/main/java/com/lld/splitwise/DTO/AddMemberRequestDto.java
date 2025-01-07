package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddMemberRequestDto {

    Long adminId;
    Long groupId;
    Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
}
