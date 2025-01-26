package com.lld.splitwise.Command;

import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.UnauthorizedAccessException;
import com.lld.splitwise.Exceptions.userNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {

    private AddMemberCommand addMemberCommand;
    private AddGroupCommand addGroupCommand;
    private RegisterUserCommand registerUserCommand;
    private SettleUpUserCommand settleUpUserCommand;

    public CommandExecutor(AddMemberCommand addMemberCommand, AddGroupCommand addGroupCommand, RegisterUserCommand registerUserCommand, SettleUpUserCommand settleUpUserCommand) {
        this.addMemberCommand = addMemberCommand;
        this.addGroupCommand = addGroupCommand;
        this.registerUserCommand = registerUserCommand;
        this.settleUpUserCommand = settleUpUserCommand;

        commands.add(addMemberCommand);
        commands.add(addGroupCommand);
        commands.add(registerUserCommand);
        commands.add(settleUpUserCommand);
    }

    private static List<Command> commands = new ArrayList<>();

//    public void addCommand(Command command) {
//
//    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public static void execute(String command) throws userNotFoundException, UnauthorizedAccessException, GroupNotFoundException {
        for (Command c : commands) {
            if (c.matches(command)) {
                c.execute(command);
                break;
            }
        }
    }
}
