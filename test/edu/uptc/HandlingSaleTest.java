package test.edu.uptc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import edu.uptc.logic.HandlingSale;
import edu.uptc.logic.Product;
import edu.uptc.logic.Bill;
import edu.uptc.logic.ETypeProduct;

public class HandlingSaleTest {

    HandlingSale handlingSale = new HandlingSale();

    @Test
    void testAddDetail() {

        assertEquals(true, handlingSale.addDetail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5));
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


        handlingSale.addBill(new Bill("999", LocalDate.of(2023, 9, 29)));

        handlingSale.addDetail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)2);
        handlingSale.addDetail(new Product("3523", "Cerveza", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.LICORES), (short)5);
        
        ArrayList<String> lista = new ArrayList<>();

        lista.add("               Tienda donde JuanDa\n"+"-------------------------------------------------------------\n"+"    # Bill:999                  Date:2023-09-29\n");
        lista.add("Id: 123 | Producto: Arroz | Valor: 6000.0 | Cantidad: 2");
        lista.add("Id: 3523 | Producto: Cerveza | Valor: 6000.0 | Cantidad: 5"); 
        lista.add("-------------------------------------------------------------\n");
        lista.add("Total:                                               48660.0");
        
        assertEquals(lista, handlingSale.getDetails());

    }

    @Test
    void testUpdateProduct() {

        testAddProduct();
        assertEquals(true, handlingSale.updateProduct(new Product("123", "Arroz", 5500, 8, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));
        assertEquals(false, handlingSale.updateProduct(new Product("3423412", "Arroz", 5500, 8, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES)));

    }



    @Test
    void testUpdateStock() {

        
        handlingSale.addProduct(new Product("3423412", "Arroz", 5500, 40, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES));
        assertEquals(50, handlingSale.updateStock("3423412", 10));
        assertEquals(45, handlingSale.updateStock("3423412", -5));
        assertEquals(0, handlingSale.updateStock("1asf", 10));
        assertEquals(45, handlingSale.updateStock("3423412", -43));

        handlingSale.addProduct(new Product("123", "Arroz", 5500, 90, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES));
        assertEquals(50, handlingSale.updateStock("3423412", 5));
        assertEquals(100, handlingSale.updateStock("123", 10));
    }

    @Test
    void testaddBill() {

        assertEquals(true, handlingSale.addBill(new Bill("1234qwer", LocalDate.now())));
    }

    @Test
    void testgetProducts() {

        testAddProduct();
        assertEquals("[Id: 123 - Descripcion: Arroz - VAlor: 6000.0 - Fecha de expiracion: 2020-01-24 - Tipo de producto: VIVERES, Id: 3523 - Descripcion: Cerveza - VAlor: 6000.0 - Fecha de expiracion: 2020-01-24 - Tipo de producto: LICORES]", handlingSale.getProducts().toString());


    }

}