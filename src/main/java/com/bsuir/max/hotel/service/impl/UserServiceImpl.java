package com.bsuir.max.hotel.service.impl;

import com.bsuir.max.hotel.entity.User;
import com.bsuir.max.hotel.repository.RepositoryException;
import com.bsuir.max.hotel.repository.creator.RepositoryCreator;
import com.bsuir.max.hotel.repository.impl.UserRepository;
import com.bsuir.max.hotel.service.ServiceException;
import com.bsuir.max.hotel.service.UserService;
import com.bsuir.max.hotel.specification.impl.common.FindById;
import com.bsuir.max.hotel.specification.impl.user.FindByUsername;
import com.bsuir.max.hotel.specification.impl.user.FindByUsernameAndPassword;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameAndPassword(username, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Optional<User> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public Optional<User> findByUsername(String username) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsername(username));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void signUpUser(Integer id, String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, username, password);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

}
