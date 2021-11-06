package com.example.controller;

import com.example.model.Supplier;
import com.example.service.SupplierService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SupplierController extends HttpServlet {
 private static final long SERIALVERSIONUID = 1L;
    private SupplierService supplierService;
    private static final Logger LOGGER = Logger.getLogger(SupplierController.class.getName());

    public void init() {
        supplierService = new SupplierService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hi !");
        request.getRequestDispatcher("InsertProduct.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Supplier> allSuppliers = new ArrayList<>();
        try {
            allSuppliers = supplierService.findAllInDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allSuppliers");
        request.setAttribute("suppliers", allSuppliers);
        dispatcher.forward(request, response);
    }





}
