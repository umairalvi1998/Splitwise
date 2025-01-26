package com.lld.splitwise.Command;

import com.lld.splitwise.Exceptions.GroupNotFoundException;
import com.lld.splitwise.Exceptions.UnauthorizedAccessException;
import com.lld.splitwise.Exceptions.userNotFoundException;

public interface Command {
    boolean matches(String input);
    void execute(String input) throws userNotFoundException, UnauthorizedAccessException, GroupNotFoundException;
}