package com.bsuir.max.hotel.controller.command.admin_command;

import com.bsuir.max.hotel.controller.command.Command;
import com.bsuir.max.hotel.controller.command.CommandResult;
import com.bsuir.max.hotel.entity.Room;
import com.bsuir.max.hotel.service.impl.RoomServiceImpl;
import com.bsuir.max.hotel.service.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DeoccupyRoomCommand implements Command {
    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ROOM_LIST = "roomList";
    private static final String ROOM_ID = "roomId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomId = request.getParameter(ROOM_ID);

        RoomServiceImpl roomService = new RoomServiceImpl();
        roomService.changeStatus(Integer.valueOf(roomId), false);

        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
