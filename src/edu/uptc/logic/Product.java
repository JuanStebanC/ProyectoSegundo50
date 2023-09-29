package edu.uptc.logic;

import java.time.LocalDate;

public class Product {
    
    private ETypeProduct eTypeProduct;
    private String idProduct, description;
    private double value;
    private int stock;
    public byte STOCK_MIN = 5;
    private LocalDate dateExpired;
    

    public Product(String idProduct, String description, double value, int stock, LocalDate dateExpired, ETypeProduct eTypeProduct) {
        this.idProduct = idProduct;
        this.description = description;
        this.value = value;
        this.stock = stock;
        this.dateExpired = dateExpired;
        this.eTypeProduct = eTypeProduct;
    }

    public boolean isExpired(){

        if (dateExpired.isBefore(LocalDate.now())){
            return true;
        }

        return false;
    }

    public double calcIva(){

        double valIva = 0;

        valIva = switch (eTypeProduct) {
            case VIVERES -> value + (value * 0.08);
            case LICORES -> value + (value * 0.19);
            case MEDICINAS -> value + (value * 0);
            case ASEO -> value + (value * 0.14);
        default -> 0.0;
        };

        return valIva;
    }

    public ETypeProduct geteTypeProduct() {
        return eTypeProduct;
    }

    public void seteTypeProduct(ETypeProduct eTypeProduct) {
        this.eTypeProduct = eTypeProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public byte getSTOCK_MIN() {
        return STOCK_MIN;
    }

    public void setSTOCK_MIN(byte sTOCK_MIN) {
        STOCK_MIN = sTOCK_MIN;
    }

    public LocalDate getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(LocalDate dateExpired) {
        this.dateExpired = dateExpired;
    }    
    
}
