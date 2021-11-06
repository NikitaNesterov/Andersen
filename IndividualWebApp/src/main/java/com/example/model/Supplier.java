package com.example.model;

import java.util.Objects;

/**
 * @author Nikita Nesterov
 */
public class Supplier {
    int id;
    String supplierTitle;
    int supplierEmployeeQuantity;

    public Supplier(String supplierTitle, int supplierEmployeeQuantity) {
        this.supplierTitle = supplierTitle;
        this.supplierEmployeeQuantity = supplierEmployeeQuantity;
    }

     public Supplier(String supplierTitle) {
        this.supplierTitle = supplierTitle;
    }

    public Supplier(int supplierId, String supplierTitle, int supplierEmployeeQuantity) {
    }

    public int getId() {
        return id;
    }

    public String getSupplierTitle() {
        return supplierTitle;
    }

    public void setSupplierTitle(String supplierTitle) {
        this.supplierTitle = supplierTitle;
    }

    public int getSupplierEmployeeQuantity() {
        return supplierEmployeeQuantity;
    }

    public void setSupplierEmployeeQuantity(int supplierEmployeeQuantity) {
        this.supplierEmployeeQuantity = supplierEmployeeQuantity;
    }

    @Override
    public String toString() {

        final StringBuffer supplier = new StringBuffer("Supplier{");
        supplier.append("title='").append(supplierTitle).append('\'');
        supplier.append(", employee quantity='").append(supplierEmployeeQuantity).append('\'');
        supplier.append('}');
        return supplier.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id && supplierEmployeeQuantity == supplier.supplierEmployeeQuantity && supplierTitle.equals(supplier.supplierTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplierTitle, supplierEmployeeQuantity);
    }
}
