package edu.uptc.logic;

public class Detail {
    
    Product product;
    private short cant;

    public Detail(Product product, short cant) {
        this.product = product;
        this.cant = cant;
    }

    public  double calcSubTotal() {
        double subTotal = (product.calcIva() + product.getValue()) * this.cant;
        return 0;
    }

    public Product getProduct() {
        return product;
    }

    public short getCant() {
        return cant;
    }
}
