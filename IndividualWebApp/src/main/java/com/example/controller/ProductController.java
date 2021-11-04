package com.example.controller;

import com.example.dao.DaoProduct;
import com.example.model.Product;
import com.example.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Nikita Nesterov
 */
public class ProductController extends HttpServlet {

    private static final long SERIALVERSIONUID = 1L;
    private ProductService productService = new ProductService();
    private static final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Product> allProducts = new ArrayList<>();
        try {
            allProducts = productService.findAllInDatabase();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("products", allProducts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/allProducts");
        dispatcher.forward(request, response);
    }


}

//        String action = request.getServletPath();
//        try{
//            switch (action){
//                case "/new product":
//                    showNewRegistrationFrom(request, response);
//                    break;
//                case "/insertProduct":
//                    insertProduct(request, response);
//                    break;
//                case "/deleteProduct":
//                    deleteProduct(request, response);
//                    break;
//                case "/editProduct":
//                    showNewRegistrationFrom(request, response);
//                    break;
//                case "/updateProduct":
//                    updateProduct(request, response);
//                    break;
//                default:
//                    listProduct(request, response);
//                    break;
//            }
//        }
//    }
//
//    private void insertProduct(HttpServletRequest request, HttpServletResponse response) {
//    }
//
//    private void showNewRegistrationFrom(HttpServletRequest request, HttpServletResponse response) {
//    }
//}
