package edu.uptc.logic;

import java.util.ArrayList;

public class HandlingSale {

    Product product;
    ArrayList<Product> products;
    Bill bill;
    

    public HandlingSale() {
        
        product = new Product(null, null, 0, 0, null, null);
        products = new ArrayList<>();
        products.add(0, product);
        bill = new Bill(null, null);
        
    
    }

    public boolean addProduct(Product newProduct){

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == newProduct.getIdProduct()) {
                return false;
            }            
        }

        if (products.get(0).getIdProduct() == null) {
            products.set(0, newProduct);
            return true;
        } else {

            products.add(newProduct);
            return true;
        }

    }

    public ArrayList<String> deleteProduct(String idProduct){

        ArrayList<String> deleted = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getIdProduct().equals(idProduct)) {
                                
                deleted.add("Id: " + products.get(i).getIdProduct());
                deleted.add("Description: " + products.get(i).getDescription());
                deleted.add("Type: " + products.get(i).geteTypeProduct().toString());

                products.remove(i);
                return deleted;             
            }            
        }
        return deleted;
    }

    public boolean updateProduct(Product product){

        for (int i = 0; i < products.size(); i++) {            
            if (products.get(i).getIdProduct().equals(product.getIdProduct())) {

                products.set(i, product);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getProducts(){

        ArrayList<String> allProductsStr = new ArrayList<>();
        String productStr = "";

        for (int i = 0; i < products.size(); i++) {

            productStr = "Id: " + products.get(i).getIdProduct() +
                " - Descripcion: " + products.get(i).getDescription() + 
                " - VAlor: " + products.get(i).getValue() + 
                " - Fecha de expiracion: " + products.get(i).getDateExpired() + 
                " - Tipo de producto: " + products.get(i).geteTypeProduct();

            allProductsStr.add(productStr);
        }

        return allProductsStr;
    }

    public boolean addBill(Bill newBill){

        try {
            bill = new Bill(newBill.getNumber(), bill.getDateBill());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addDetail(Product newProduct, short cant){

        try {

            bill.addDetail(newProduct, cant);
            return true;
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return false;

    }

    public int updateStock(String idProduct, int newStock){ 

        for (int i = 0; i < products.size(); i++) {
            
            if (products.get(i).getIdProduct().equals(idProduct)) {
        
                if (products.get(i).getStock() + newStock < products.get(i).STOCK_MIN) {
                    
                    return products.get(i).getStock();
                } else {
                    
                    int finalStock = products.get(i).getStock() + newStock;  
                    products.get(i).setStock(finalStock);

                    return finalStock;

                }
            }
        }

        return 0;
    }
    
    public ArrayList<String> getDetails(){

        ArrayList<String> aux = new ArrayList<>();
    
        for (int i = 0; i < products.size(); i++) {
            aux.add(i,String.valueOf(products.get(i).getIdProduct())+" "+String.valueOf(products.get(i).getDescription())
            +" "+String.valueOf(products.get(i).getValue())+" "+String.valueOf(products.get(i).getDateExpired())
            +" "+String.valueOf(products.get(i).geteTypeProduct()));
        }
        return aux;
    }
    
}
