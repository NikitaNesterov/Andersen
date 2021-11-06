package com.example.service;


import com.example.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ProductServiceTest {

    private ProductService productService;
    List<Product> productList = new ArrayList<Product>();

    @BeforeEach
    void setUp() {
        productService = Mockito.mock(ProductService.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById_should_return_existing_Product() {
        //given
        Product product = new Product(1, "Молоко", 25, "Молокозавод");
        productList.add(product);

        //when
        productList.add(product);

        //then
        try {
            Mockito.when(productService.findById(product.getId())).thenReturn(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void findAllInDatabase_should_return_all_products() {
        //given
        Product product = new Product(1, "Молоко", 25, "Молокозавод");
        Product product1 = new Product(2, "Сыр", 40, "Молокозавод");

        //when
        productList.add(product);
        productList.add(product1);

        //then
        try {
            Mockito.when(productService.findAllInDatabase()).thenReturn(productList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void saveInDataBase_should_save_new_product_in_database() {
//        //given
//        Product product = new Product(1, "Молоко", 25, "Молокозавод");
//
//        //when
//        productList.add(product);
//
//        //then
//        try {
//            Mockito.when(productService.saveInDataBase(product)).thenReturn(true);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
}

    @Test
    void updateInDatabase_should_update_product_in_database() {
        //given
        Product product = new Product(1, "Молоко", 25, "Молокозавод");
        productList.add(product);

        //when
        product.setProductName("Молоко обезжиренное");

        //then

        try {
            Mockito.verify(productService.updateInDatabase(product));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            Mockito.when(productService.findById(product.getId()).getProductName()).thenReturn("Молоко обезжиренное");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    void deleteInDataBase() {
    }
}