package dao;

import model.Supplier;

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
    public Optional<Supplier> findId(int id) throws SQLException {

        String sql = "SELECT idSupplier, supplierTitle, supplierLocation from Supplier WHERE idSupplier = ?";
        int supplierId = 0;
        String supplierTitle = "", supplierLocation = "";


        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            supplierId = resultSet.getInt("idSupplier");
            supplierTitle = resultSet.getString("supplierTitle");
            supplierLocation = resultSet.getString("supplierLocation");
        }

        resultSet.close();
        preparedStatement.close();
        conn.close();

        return Optional.of(new Supplier(supplierId, supplierTitle, supplierLocation));
    }

    /**
     * @return
     * @throws SQLException
     */

    @Override
    public List<Supplier> findAll() throws SQLException {
        List<Supplier> listSupplier = new ArrayList<>();
        String sql = "SELECT idSupplier, supplierTitle, supplierLocation from Supplier";

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int supplierId = resultSet.getInt("idSupplier");
            String supplierTitle = resultSet.getString("supplierTitle");
            String supplierLocation = resultSet.getString("supplierLocation");


            Supplier supplier = new Supplier(supplierId, supplierTitle, supplierLocation);
            listSupplier.add(supplier);
        }
        resultSet.close();
        preparedStatement.close();
        conn.close();

        return listSupplier;
    }

    /**
     * @param supplier
     * @return
     * @throws SQLException
     */

    @Override
    public boolean save(Supplier supplier) throws SQLException {
        String sql = "INSERT into Supplier (supplierTitle, supplierLocation) VALUES (?, ?)";
        boolean rowInserted = false;

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, supplier.getSupplierTitle());
        preparedStatement.setString(2, supplier.getSupplierLocation());
        rowInserted = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

        return rowInserted;
    }

    /**
     * @param supplier
     * @return
     * @throws SQLException
     */

    @Override
    public boolean update(Supplier supplier) throws SQLException {
        String sql = "UPDATE Supplier SET supplierTitle = ?, supplierLocation = ?";
        sql += "WHERE idSupplier = ?";
        boolean rowUpdated = false;

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, supplier.getSupplierTitle());
        preparedStatement.setString(2, supplier.getSupplierLocation());
        preparedStatement.setInt(3, supplier.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

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

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, supplier.getId());
        rowDeleted = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

        return rowDeleted;
    }
}
