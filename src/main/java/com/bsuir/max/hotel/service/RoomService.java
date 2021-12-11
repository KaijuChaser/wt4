package com.bsuir.max.hotel.service;

import com.bsuir.max.hotel.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll() throws ServiceException;

    List<Room> findFree() throws ServiceException;

    void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException;

    void changeStatus(Integer id, Boolean occupied) throws ServiceException;

}
