package com.example.model;

import java.util.Objects;

/**
 * @author Nikita Nesterov
 */
public class Product {
    int id;
    String productName;
    int productQuantity;
    String productSupplier;

    public Product(int id) {
        this.id = id;
    }

    public Product(String productName, int productQuantity, String productSupplier) {
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

    @Override
    public String toString() {
        final StringBuffer product = new StringBuffer("Product{");
        product.append("name='").append(productName).append('\'');
        product.append(", product quantity='").append(productQuantity).append('\'');
        product.append(", product supplier title='").append(productSupplier).append('\'');
        product.append('}');
        return product.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id
                && productQuantity == product.productQuantity
                && productName.equals(product.productName)
                && productSupplier.equals(product.productSupplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productQuantity, productSupplier);
    }
}
