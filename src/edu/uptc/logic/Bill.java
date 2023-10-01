package edu.uptc.logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {

    private String number;
    private LocalDate dateBill;
    private Detail details;
    private ArrayList<Product> listDetails = new ArrayList<Product>();
    private ArrayList<Detail> listDetails2 = new ArrayList<Detail>();

    public Bill(String number, LocalDate dateBill) {
        this.number = number;
        this.dateBill = dateBill; 
    }

    public double calcTotal(){

        Double sum = 0.0;
        for (int i = 0; i < listDetails.size(); i++) {
            sum+=listDetails2.get(i).calcSubTotal();
        }
        return sum;
    }

    public boolean addDetail(Product product, short cant){

        try {
            
            details= new Detail(product, cant);
            listDetails.add(details.getProduct());
            listDetails2.add(details);
            
            return true;

        } catch (Exception e) {
            
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Product> getDetails(){

        return listDetails;
    }

    public ArrayList<Detail> getDetailsTwo(){

        return listDetails2;
    }

    public String getNumber() {
        return number;
    }

    public LocalDate getDateBill() {

        return dateBill;
    }        
}