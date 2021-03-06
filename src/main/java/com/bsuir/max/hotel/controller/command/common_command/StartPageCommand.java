package com.bsuir.max.hotel.controller.command.common_command;

import com.bsuir.max.hotel.controller.command.Command;
import com.bsuir.max.hotel.controller.command.CommandResult;
import com.bsuir.max.hotel.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartPageCommand implements Command {

    private static final String LOGIN_PAGE = "/index.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(LOGIN_PAGE);
    }
}
