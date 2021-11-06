package com.example.service;

import com.example.dao.DaoSupplier;
import com.example.model.Supplier;

import java.sql.SQLException;
import java.util.List;

public class SupplierService implements ServiceImpl<Supplier>{

    private DaoSupplier daoSupplier = new DaoSupplier();

    @Override
    public Supplier findById(int id) throws SQLException {
        return daoSupplier.findId(id);
    }

    @Override
    public List<Supplier> findAllInDatabase() throws SQLException {
        return daoSupplier.findAll();
    }

    @Override
    public void saveInDataBase(Supplier supplier) throws SQLException {
        daoSupplier.save(supplier);
    }

    @Override
    public boolean updateInDatabase(Supplier supplier) throws SQLException {
        return daoSupplier.update(supplier);
    }

    @Override
    public boolean deleteInDataBase(Supplier supplier) throws SQLException {
        return daoSupplier.delete(supplier);
    }
}
