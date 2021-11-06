package com.example.dao;

import com.example.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Nikita Nesterov
 */
public class DaoProduct implements Dao<Product> {


    public DaoProduct() {
    }


    /**
     *
     */

    private static class SingletonHelper {
        private static final DaoProduct INSTANCE = new DaoProduct();
    }

    /**
     * @return
     */

    public static DaoProduct getInstance() {
        return SingletonHelper.INSTANCE;
    }

    /**
     * @param id
     * @return
     * @throws SQLException
     */

    @Override
    public Product findId(int id) throws SQLException {

        String sql = "SELECT idProduct, productName, productQuantity, productSupplier from Product WHERE idProduct = ?";
        int productId = 0, productQuantity = 0;
        String productName = "", productSupplier = "";


        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            productId = resultSet.getInt("idProduct");
            productName = resultSet.getString("productName");
            productQuantity = resultSet.getInt("productQuantity");
            productSupplier = resultSet.getString("productSupplier");
        }
        return new Product(productId, productName, productQuantity, productSupplier);
    }

    /**
     * @return
     * @throws SQLException
     */

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> listProduct = new ArrayList<>();
        String sqlProduct = "SELECT * FROM Product";

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement productPreparedStatement = conn.prepareStatement(sqlProduct);

        ResultSet resultSet = productPreparedStatement.executeQuery();
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

        while (resultSet.next()) {
            int productId = resultSet.getInt("idProduct");
            String productName = resultSet.getString("productName");
            int productQuantity = resultSet.getInt("productQuantity");
            String productSupplier = resultSet.getString("productSupplier");

            Product product = new Product(productId, productName, productQuantity, productSupplier);
            listProduct.add(product);
        }
        conn.commit();
        return listProduct;
    }

    /**
     * @param product
     * @return
     * @throws SQLException
     */

    @Override
    public void save(Product product) throws SQLException {
        String sql = "INSERT into Product (productName, productQuantity, productSupplier) VALUES (?, ?, ?);";


        Connection conn = DataSourceFactory.getConnection();
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        Statement statement = conn.createStatement();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

          preparedStatement.setString(1, product.getProductName());
          preparedStatement.setInt(2, product.getProductQuantity());
          preparedStatement.setString(3, product.getProductSupplier());
          preparedStatement.executeUpdate();

      conn.commit();

    }

    /**
     * @param product
     * @return
     * @throws SQLException
     */

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = "UPDATE Product SET productName = ?, productQuantity = ?, productSupplier = ?";
        sql += "WHERE idProduct = ?";
        boolean rowUpdated = false;

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setInt(2, product.getProductQuantity());
        preparedStatement.setString(3, product.getProductSupplier());
        preparedStatement.setInt(4, product.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;

        return rowUpdated;
    }

    /**
     * @param product
     * @return
     * @throws SQLException
     */

    @Override
    public boolean delete(Product product) throws SQLException {
        String sql = "DELETE from Product WHERE idProdict = ?";
        boolean rowDeleted = false;

        Connection conn = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, product.getId());
        rowDeleted = preparedStatement.executeUpdate() > 0;

        return rowDeleted;
    }
}
