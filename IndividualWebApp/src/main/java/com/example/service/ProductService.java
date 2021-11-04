package com.example.service;

import com.example.dao.DaoProduct;
import com.example.model.Product;

import java.sql.SQLException;
import java.util.List;


public class ProductService implements ServiceImpl<Product>{

    private DaoProduct daoProduct = new DaoProduct();

    @Override
    public Product findById(int id) throws SQLException {
        return daoProduct.findId(id);
    }

    @Override
    public List<Product> findAllInDatabase() throws SQLException {
        return daoProduct.findAll();
    }

    @Override
    public boolean saveInDataBase(Product product) throws SQLException {
        return daoProduct.save(product);
    }

    @Override
    public boolean updateInDatabase(Product product) throws SQLException {
        return daoProduct.update(product);
    }

    @Override
    public boolean deleteInDataBase(Product product) throws SQLException {
        return daoProduct.delete(product);
    }
}
