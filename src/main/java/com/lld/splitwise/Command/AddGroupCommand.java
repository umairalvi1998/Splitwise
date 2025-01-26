package com.lld.splitwise.Command;

import com.lld.splitwise.DTO.GroupCreationRequestDto;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.controller.GroupController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddGroupCommand implements Command {

    GroupController groupController;

    AddGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeywords.createGroupCommand);
    }

    @Override
    public void execute(String input) throws userNotFoundException {
        List<String> words = List.of(input.split(" "));

        String groupName = words.get(1);

        List<String> memberIDs = List.of(words.get(2).split(","));
        List<Long> memberIDsLong = new ArrayList<>();

        for(String memberID : memberIDs){
            memberIDsLong.add(Long.parseLong(memberID));
        }

        Long adminId = Long.parseLong(words.get(3));

        GroupCreationRequestDto requestDto = new GroupCreationRequestDto();
        requestDto.setName(groupName);
        requestDto.setMemberIds(memberIDsLong);
        requestDto.setUserId(adminId);

        groupController.createGroup(requestDto);


    }
}

