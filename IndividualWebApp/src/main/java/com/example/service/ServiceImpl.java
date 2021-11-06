package com.example.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ServiceImpl<T> {

    T findById(int id) throws SQLException;

    List<T> findAllInDatabase() throws SQLException;

    void saveInDataBase(T t) throws SQLException;

    boolean updateInDatabase(T t) throws SQLException;

    boolean deleteInDataBase(T t) throws SQLException;

}
