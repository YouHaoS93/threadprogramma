package test;

import model.Balie;
import model.Bestelling;
import model.Maaltijd;
import org.junit.Before;

import java.util.ArrayList;

public class BalieTest {

    Balie balie;
    ArrayList<Bestelling> bestellingen;
    ArrayList<Maaltijd> maaltijden;

    @Before
    public void setUp() {

        bestellingen = null;
        maaltijden = null;

        balie = new Balie();

        Bestelling b = new Bestelling(2, 1);
        bestellingen.add(b);

        Maaltijd m = new Maaltijd(1);
        maaltijden.add(m);



    }
}
