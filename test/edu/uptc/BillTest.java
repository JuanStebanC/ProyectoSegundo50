package test.edu.uptc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import edu.uptc.logic.Bill;
import edu.uptc.logic.Product;
import edu.uptc.logic.ETypeProduct;


public class BillTest {

    Product product;
    Bill bill = new Bill(null, null);


    @Test
    void testAddDetail() {

        
        assertEquals(true, bill.addDetail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5));
        System.out.println(bill.getNumber());

    }

    @Test
    void testCalcTotal() {

        bill.addDetail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)1);
        bill.addDetail(new Product("124", "Arvaje", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)2);
        bill.addDetail(new Product("125", "pasta", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.LICORES), (short)10);

        assertEquals(90840.0, bill.calcTotal(),0.1);

    }

    @Test
    void testGetDetails() {

        ArrayList<Product> listProduc = new ArrayList<>();

        bill.addDetail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5);
        bill.addDetail(new Product("124", "Arvaje", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5);
        bill.addDetail(new Product("125", "pasta", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5);


        listProduc.add(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES));
        listProduc.add(new Product("124", "Arvaje", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES));
        listProduc.add(new Product("125", "pasta", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES));   
        //assertArrayEquals(product, bill.getDetails().get(0));
        
        assertEquals(listProduc.get(2).getIdProduct(), bill.getDetails().get(2).getIdProduct());

    }
}
