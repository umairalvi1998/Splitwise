package com.lld.splitwise.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupCreationRequestDto {
    private String name;
    private List<Long> memberIds;
    private Long userId;

}
