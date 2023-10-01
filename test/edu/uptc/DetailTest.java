package test.edu.uptc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import edu.uptc.logic.Detail;
import edu.uptc.logic.ETypeProduct;
import edu.uptc.logic.Product;

public class DetailTest {

    Detail detail;

    void setUpViveres(){

        detail = new Detail(new Product("123", "Arroz", 6000, 10, LocalDate.of(2020, 1, 24), ETypeProduct.VIVERES), (short)5);
    }

    void setUpLicores(){
        detail = new Detail(new Product("456", "Cerveza", 2500, 20, LocalDate.of(2023, 10 , 22), ETypeProduct.LICORES), (short)5);
    }

    void setUpMedicinas(){
        detail = new Detail(new Product("789", "Dolex", 5000, 30, LocalDate.of(2024, 12, 12), ETypeProduct.MEDICINAS), (short)5);
    }

    void setUpASeo(){
        detail = new Detail(new Product("789", "Crema dental", 2000, 30, LocalDate.of(2024, 12, 12), ETypeProduct.ASEO), (short)5);
    }

    @Test
    void testCalcSubTotal() {

        setUpViveres();
        assertEquals(32400, detail.calcSubTotal(), 0.1);
        setUpLicores();
        assertEquals(14875, detail.calcSubTotal(), 0.1);
        setUpMedicinas();
        assertEquals(25000, detail.calcSubTotal(), 0.1);
        setUpASeo();
        assertEquals(11400, detail.calcSubTotal(), 0.1);

    }
}
