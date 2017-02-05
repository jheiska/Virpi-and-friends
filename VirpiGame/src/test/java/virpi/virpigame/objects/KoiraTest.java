package virpi.virpigame.objects;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KoiraTest {

    Koira koira;

    public KoiraTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        koira = new Koira(-200, 1, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void liikkuuYlosEikaMeneNegatiiviseksi() {
        koira.liikuYlos();
        assertEquals(1, koira.getY());
        koira.liikuYlos();
        assertEquals(0, koira.getY());
        koira.liikuYlos();
        assertEquals(0, koira.getY());
    }

    @Test
    public void liikkuuAlas() {
        koira.liikuAlas();
        assertEquals(3, koira.getY());
    }

    @Test
    public void liikkuuOikealle() {
        koira.liikuOikealle();
        assertEquals(2, koira.getX());
    }

    @Test
    public void liikkuuVasemmalleEikaMeneNegatiiviseksi() {
        koira.liikuVasemmalle();
        assertEquals(0, koira.getX());
        koira.liikuVasemmalle();
        assertEquals(0, koira.getX());
    }

    @Test
    public void palauttaaOikeatPisteet() {
        assertEquals(-200, koira.getPisteet());
    }

    @Test
    public void pisteetMuuttuvatOikein() {
        koira.muutaPisteita(300);
        assertEquals(100, koira.getPisteet());
        koira.muutaPisteita(-200);
        assertEquals(-100, koira.getPisteet());
    }

    @Test
    public void palauttaaOikeanXKoordinaatin() {
        assertEquals(1, koira.getX());
    }

    @Test
    public void palauttaaOikeanYKoordinaatin() {
        assertEquals(2, koira.getY());
    }

    @Test
    public void toStringPalauttaaOikeanNimen() {
        assertEquals("K", koira.toString());
    }

}
