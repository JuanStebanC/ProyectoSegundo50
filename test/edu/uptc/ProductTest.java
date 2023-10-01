package test.edu.uptc;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import edu.uptc.logic.ETypeProduct;
import edu.uptc.logic.Product;

public class ProductTest {

    Product[] product = new Product[4];

    void setUpViveres(){

        product[0] = new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES);
    }

    void setUpLicores(){
        product[1] = new Product("456", "Cerveza", 2500, 20, LocalDate.of(2023, 10 , 22), ETypeProduct.LICORES);
    }

    void setUpMedicinas(){
        product[2] = new Product("789", "Dolex", 5000, 30, LocalDate.of(2024, 12, 12), ETypeProduct.MEDICINAS);
    }

    void setUpASeo(){
        product[3] = new Product("789", "Crema dental", 2000, 30, LocalDate.of(2024, 12, 12), ETypeProduct.ASEO);
    }

    @Test
    void testCalcIva() {

        setUpViveres();
        assertEquals(6480, product[0].calcIva(), 0.1);
        setUpLicores();
        assertEquals(2975, product[1].calcIva(), 0.1);
        setUpMedicinas();
        assertEquals(5000, product[2].calcIva(), 0.1);
        setUpASeo();
        assertEquals(2280, product[3].calcIva(), 0.1);

    }

    @Test
    void testIsExpired() {

        setUpViveres();
        assertEquals(true, product[0].isExpired());
        setUpLicores();
        assertEquals(false, product[1].isExpired());

    }
}
