package com.example.model;

/**
 * @author Nikita Nesterov
 */
public class Supplier {
    int id;
    String supplierTitle;
    String supplierLocation;

    public Supplier(int id) {
        this.id = id;
    }

    public Supplier(int id, String supplierTitle, String supplierStatus) {
        this.id = id;
        this.supplierTitle = supplierTitle;
        this.supplierLocation = supplierStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierTitle() {
        return supplierTitle;
    }

    public void setSupplierTitle(String supplierTitle) {
        this.supplierTitle = supplierTitle;
    }

    public String getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(String supplierStatus) {
        this.supplierLocation = supplierStatus;
    }
}
