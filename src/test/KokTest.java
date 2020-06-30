package test;

import model.Balie;
import model.Kok;
import org.junit.Before;



public class KokTest {

    Kok k1;
    Kok k2;

    Balie balie;


    @Before
    public void setUp() {

        balie = new Balie();

        k1 = new Kok ("1",balie);
        k2 = new Kok ("2",balie);

    }

}
