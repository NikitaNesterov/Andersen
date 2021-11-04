package com.example.model;

/**
 * @author Nikita Nesterov
 */
public class Product {
    int id = 0;
    String productName;
    int productQuantity;
    String productSupplier;

    public Product(int id) {
        this.id = id;
    }

    public Product(String productName, int productQuantity, String productSupplier) {
        this.id++;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productSupplier = productSupplier;
    }

     public Product(int id, String productName, int productQuantity, String productSupplier) {
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productSupplier = productSupplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductSupplier() {
        return productSupplier;
    }

    public void setProductSupplier(String productSupplier) {
        this.productSupplier = productSupplier;
    }
}
