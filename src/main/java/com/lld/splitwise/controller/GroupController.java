package com.lld.splitwise.controller;

import com.lld.splitwise.DTO.AddMemberRequestDto;
import com.lld.splitwise.DTO.GroupCreationRequestDto;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.UnauthorizedAccessException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.Group;
import com.lld.splitwise.services.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/group")
    public ResponseEntity createGroup(@RequestBody GroupCreationRequestDto requestDto) throws userNotFoundException {
        Group savedGroup = groupService.createGroup(requestDto);
        return ResponseEntity.ok(savedGroup);
    }

    @PostMapping("/groups/addMember")
    public ResponseEntity<Group> addMember(@RequestBody  AddMemberRequestDto requestDto) throws userNotFoundException, GroupNotFoundException, UnauthorizedAccessException {
        Long adminId = requestDto.getAdminId();
        Long groupId = requestDto.getGroupId();
        Long userId = requestDto.getUserId();

        return ResponseEntity.ok(groupService.addMember(adminId, groupId, userId));

    }
}
