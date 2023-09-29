package test.edu.uptc;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import edu.uptc.logic.HandlingSale;
import edu.uptc.logic.Product;
import edu.uptc.logic.ETypeProduct;

public class HandlingSaleTest {

    HandlingSale handlingSale = new HandlingSale();

    @Test
    void testAddDetail() {

    }

    @Test
    void testAddProduct() {

        assertEquals(true, handlingSale.addProduct(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));
        assertEquals(false, handlingSale.addProduct(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));
        assertEquals(true, handlingSale.addProduct(new Product("3523", "Cerveza", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.LICORES)));
        assertEquals(false, handlingSale.addProduct(new Product("3523", "Cerveza", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.LICORES)));

    }

    @Test
    void testDeleteProduct() {

        testAddProduct();
        assertEquals(new ArrayList<>(List.of("Id: 3523", "Description: Cerveza", "Type: LICORES")), handlingSale.deleteProduct("3523"));
        assertEquals(new ArrayList<>(List.of("Id: 123", "Description: Arroz", "Type: VIVERES")), handlingSale.deleteProduct("123"));

    }


    @Test
    void testGetDetails() {

    }

    @Test
    void testUpdateProduct() {

        testAddProduct();
        assertEquals(true, handlingSale.updateProduct(new Product("123", "Arroz", 5500, 8, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));
        assertEquals(false, handlingSale.updateProduct(new Product("3423412", "Arroz", 5500, 8, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));

    }



    @Test
    void testUpdateStock() {

    }
}
