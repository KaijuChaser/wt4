package com.bsuir.max.hotel.repository.builder;

import com.bsuir.max.hotel.repository.RepositoryException;

import java.sql.ResultSet;

public interface Builder<T> {
    T build(ResultSet resultSet) throws RepositoryException;
}
