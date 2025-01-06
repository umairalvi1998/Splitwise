package com.lld.splitwise.services;

import com.lld.splitwise.DTO.GroupCreationRequestDto;
import com.lld.splitwise.Exceptions.userNotFoundException;
import com.lld.splitwise.models.Group;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.groupRepository;
import com.lld.splitwise.repositories.userRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private groupRepository groupRepo;
    private userRepository  userRepo;

    public  GroupService(groupRepository groupRepo, userRepository userRepo) {
        this.groupRepo = groupRepo;
        this.userRepo = userRepo;
    }

    public Group createGroup(GroupCreationRequestDto requestDto) throws userNotFoundException {
         String groupName = requestDto.getName();
         List<Long> memberIds = requestDto.getMemberIds();
        Long userId = requestDto.getUserId();


// Check if userId exists in the database
       User user = userRepo.findById(userId).orElseThrow(() -> new userNotFoundException("User with ID " + userId + " does not exist"));

// Check if all memberIds exist in the database
        List<User> members = new ArrayList<>();
        for (Long memberId : memberIds) {
            User user1 = userRepo.findById(memberId).orElseThrow(() -> new userNotFoundException("User with ID " + memberId + " does not exist"));
            members.add(user1);
        }

        Group group = new Group();
        group.setDescription(groupName);
        group.setMembers(members);
        group.setCreatedBy(user);


        return groupRepo.save(group);
    }
}
