package edu.uptc.logic;

import java.util.ArrayList;

public class HandlingSale {

    Product product;
    ArrayList<Product> products;
    //Bill bill;

    public HandlingSale() {
        
        product = new Product(null, null, 0, 0, null, null);
        products = new ArrayList<>();
        products.add(0, product);
    
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

    public ArrayList<Product> getProducts(){

        
        return (ArrayList<Product>) products.clone();

    }
    /*public boolean addBill(Bill bill){
        return true;
    }*/

    public boolean addDetail(String[] detail){
        return true;
    }

    public int updateStock(String[] detail){ //Id & newStock
        return 0;
    }
    
    public String[] getDetails(){
        return null;
    }
}
