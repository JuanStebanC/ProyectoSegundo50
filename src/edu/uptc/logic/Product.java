package edu.uptc.logic;

import java.time.LocalDate;

public class Product {
    public ETypeProduct eTypeProduct;
    private String idProduct, description;
    private double value;
    private int stock;
    public byte STOCK_MIN = 5;
    LocalDate dateExpired;

    public Product(String idProduct, String description, double value, int stock, LocalDate dateExpired) {
        this.idProduct = idProduct;
        this.description = description;
        this.value = value;
        this.stock = stock;
        this.dateExpired = dateExpired;
    }

    public boolean isExpired(){

        return false;
    }

    public double calcIva(){

        return 0;
    }
}
