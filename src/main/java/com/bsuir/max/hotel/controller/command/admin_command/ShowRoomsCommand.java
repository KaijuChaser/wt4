package com.bsuir.max.hotel.controller.command.admin_command;

import com.bsuir.max.hotel.controller.command.Command;
import com.bsuir.max.hotel.controller.command.CommandResult;
import com.bsuir.max.hotel.entity.Room;
import com.bsuir.max.hotel.service.impl.RoomServiceImpl;
import com.bsuir.max.hotel.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowRoomsCommand implements Command {
    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomServiceImpl roomService = new RoomServiceImpl();
        List<Room> fullRoomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, fullRoomList);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }

        return CommandResult.forward(ROOMS_PAGE);
    }
}
