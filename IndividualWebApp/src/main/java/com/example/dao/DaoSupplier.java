package com.example.dao;

import com.example.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikita Nesterov
 */
public class DaoSupplier implements Dao<Supplier> {

    public DaoSupplier() {
    }


    /**
     *
     */

    private static class SingletonHelper {
        private static final DaoSupplier INSTANCE = new DaoSupplier();
    }

    /**
     * @return
     */

    public static DaoSupplier getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */

    @Override
    public Supplier findId(int id) throws SQLException {

        String sql = "SELECT idSupplier, supplierTitle, supplierEmplQuantity from Supplier WHERE idSupplier = ?";
        int supplierId = 0, supplierEmployeeQuantity = 0;
        String supplierTitle = "";


        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            supplierId = resultSet.getInt("idSupplier");
            supplierTitle = resultSet.getString("supplierTitle");
            supplierEmployeeQuantity = resultSet.getInt("supplierEmpQuantity");
        }
        return new Supplier(supplierId, supplierTitle, supplierEmployeeQuantity);
    }

    /**
     * @return
     * @throws SQLException
     */

    @Override
    public List<Supplier> findAll() throws SQLException {
        List<Supplier> listSupplier = new ArrayList<>();
        String sql = "SELECT * from Supplier";

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        while (resultSet.next()) {
            int supplierId = resultSet.getInt("idSupplier");
            String supplierTitle = resultSet.getString("supplierTitle");
            int supplierEmployeeQuantity = resultSet.getInt("supplierEmpQuantity");

            Supplier supplier = new Supplier(supplierId, supplierTitle, supplierEmployeeQuantity);
            listSupplier.add(supplier);
        }
        conn.commit();
        return listSupplier;
    }

    /**
     * @param supplier
     * @return
     * @throws SQLException
     */

    @Override
    public void save(Supplier supplier) throws SQLException {
        String sql = "INSERT into Supplier (supplierTitle, supplierEmpQuantity) VALUES (?, ?)";

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, supplier.getSupplierTitle());
        preparedStatement.setInt(2, supplier.getSupplierEmployeeQuantity());
        preparedStatement.execute();


    }

    /**
     * @param supplier
     * @return
     * @throws SQLException
     */

    @Override
    public boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE Supplier SET supplierTitle = ?, supplierEmpQuantiy = ?";
        sql += "WHERE idSupplier = ?";
        boolean rowUpdated = false;

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, supplier.getSupplierTitle());
        preparedStatement.setInt(2, supplier.getSupplierEmployeeQuantity());
        preparedStatement.setInt(3, supplier.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
    }

    /**
     * @param supplier
     * @return
     * @throws SQLException
     */

    @Override
    public boolean delete(Supplier supplier) throws SQLException {
        String sql = "DELETE from Supplier WHERE idSupplier = ?";
        boolean rowDeleted = false;

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, supplier.getId());
        rowDeleted = preparedStatement.executeUpdate() > 0;

        return rowDeleted;
    }
}
