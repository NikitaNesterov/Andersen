package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikita Nesterov
 */
public interface Dao<T> {

    Optional<T> findId(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean save(T t) throws SQLException;

    boolean update(T t) throws SQLException;

    boolean delete(T t) throws SQLException;
}
