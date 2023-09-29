package edu.uptc.logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private String number;
    private LocalDate dateBill;

    public Bill(String number, LocalDate dateBill) {
        this.number = number;
        this.dateBill = dateBill;
    }

    public double calcTotal(){

        return 0;
    }

    public boolean addDetail(Product cant){

        return false;
    }

    public ArrayList<Product> getDetails(){

        return null;
    }
}
