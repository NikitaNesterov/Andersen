package com.example.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikita Nesterov
 */
public interface Dao<T> {

    T findId(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void save(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;
}
