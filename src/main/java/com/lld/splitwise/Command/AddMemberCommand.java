package com.lld.splitwise.Command;

import com.lld.splitwise.DTO.AddMemberRequestDto;
import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.UnauthorizedAccessException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.controller.GroupController;
import com.lld.splitwise.controller.UserController;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddMemberCommand implements Command {

    private GroupController groupController;

    public AddMemberCommand(GroupController groupController) {
        this.groupController = groupController;
    }
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(""));

        return words.size() == 4 && words.get(1).equals(CommandKeywords.addMemberCommand);
    }

    @Override
    public void execute(String input) throws userNotFoundException, UnauthorizedAccessException, GroupNotFoundException {

        List<String> words = List.of(input.split(""));

        Long adminId  = Long.valueOf(words.get(0));
        Long groupId = Long.valueOf(words.get(2));
        Long userId = Long.valueOf(words.get(3));

        AddMemberRequestDto requestDto = new AddMemberRequestDto();
        requestDto.setAdminId(adminId);
        requestDto.setUserId(userId);
        requestDto.setGroupId(groupId);

        groupController.addMember(requestDto);


    }
}
