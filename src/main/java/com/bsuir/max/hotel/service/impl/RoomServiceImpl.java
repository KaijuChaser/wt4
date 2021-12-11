package com.bsuir.max.hotel.service.impl;

import com.bsuir.max.hotel.entity.Room;
import com.bsuir.max.hotel.repository.RepositoryException;
import com.bsuir.max.hotel.repository.creator.RepositoryCreator;
import com.bsuir.max.hotel.repository.impl.RoomRepository;
import com.bsuir.max.hotel.service.RoomService;
import com.bsuir.max.hotel.service.ServiceException;
import com.bsuir.max.hotel.specification.impl.common.FindById;
import com.bsuir.max.hotel.specification.impl.room.FindAll;
import com.bsuir.max.hotel.specification.impl.room.FindFree;

import java.util.List;
import java.util.Optional;

public class RoomServiceImpl implements RoomService {

    @Override
    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public List<Room> findFree() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindFree());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, occupied);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void changeStatus(Integer id, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Optional<Room> room = roomRepository.query(new FindById(id));
            if (room.isPresent()) {
                room.get().setOccupied(occupied);
                roomRepository.save(room.get());
            } else {
                throw new ServiceException("No such room id");
            }
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
