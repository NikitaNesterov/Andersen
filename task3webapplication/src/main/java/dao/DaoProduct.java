package dao;

import model.Product;

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
    public Optional<Product> findId(int id) throws SQLException {

        String sql = "SELECT idProduct, productName, productQuantity, productSupplier from Product WHERE idProduct = ?";
        int productId = 0, productQuantity = 0;
        String productName = "", productSupplier = "";


        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(id));
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            productId = resultSet.getInt("idProduct");
            productName = resultSet.getString("productName");
            productQuantity = resultSet.getInt("productQuantity");
            productSupplier = resultSet.getString("productSupplier");
        }

        resultSet.close();
        preparedStatement.close();
        conn.close();

        return Optional.of(new Product(productId, productName, productQuantity, productSupplier));
    }

    /**
     * @return
     * @throws SQLException
     */

    @Override
    public List<Product> findAll() throws SQLException {
        List<Product> listProduct = new ArrayList<>();
        String sql = "SELECT idProduct, productName, productQuantity, productSupplier from Product";

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int productId = resultSet.getInt("idProduct");
            String productName = resultSet.getString("productName");
            int productQuantity = resultSet.getInt("productQuantity");
            String productSupplier = resultSet.getString("productSupplier");

            Product product = new Product(productId, productName, productQuantity, productSupplier);
            listProduct.add(product);
        }
        resultSet.close();
        preparedStatement.close();
        conn.close();

        return listProduct;
    }

    /**
     * @param product
     * @return
     * @throws SQLException
     */

    @Override
    public boolean save(Product product) throws SQLException {
        String sql = "INSERT into Product (productName, productQuantity, productSupplier) VALUES (?, ?, ?)";
        boolean rowInserted = false;

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setInt(2, product.getProductQuantity());
        preparedStatement.setString(3, product.getProductSupplier());
        rowInserted = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

        return rowInserted;
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

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setInt(2, product.getProductQuantity());
        preparedStatement.setString(3, product.getProductSupplier());
        preparedStatement.setInt(4, product.getId());
        rowUpdated = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

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

        Connection conn = MySQLDriverManager.createConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, product.getId());
        rowDeleted = preparedStatement.executeUpdate() > 0;

        preparedStatement.close();
        conn.close();

        return rowDeleted;
    }
}
