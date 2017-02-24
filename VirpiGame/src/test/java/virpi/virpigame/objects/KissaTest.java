package virpi.virpigame.objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KissaTest {

    Kissa kissa;

    public KissaTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kissa = new Kissa("Virpi", 1, 2);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void liikkuuYlosEikaMeneNegatiiviseksi() {
        kissa.liikuYlos();
        assertEquals(1, kissa.getY());
        kissa.liikuYlos();
        assertEquals(0, kissa.getY());
        kissa.liikuYlos();
        assertEquals(0, kissa.getY());
    }

    @Test
    public void liikkuuAlas() {
        kissa.liikuAlas();
        assertEquals(3, kissa.getY());
    }

    @Test
    public void liikkuuOikealle() {
        kissa.liikuOikealle();
        assertEquals(2, kissa.getX());
    }

    @Test
    public void liikkuuVasemmalleEikaMeneNegatiiviseksi() {
        kissa.liikuVasemmalle();
        assertEquals(0, kissa.getX());
        kissa.liikuVasemmalle();
        assertEquals(0, kissa.getX());
    }

    @Test
    public void palauttaaOikeatPisteet() {
        assertEquals(0, kissa.getPisteet());
    }

    @Test
    public void pisteetMuuttuvatOikein() {
        kissa.muutaPisteita(300);
        assertEquals(300, kissa.getPisteet());
        kissa.muutaPisteita(-100);
        assertEquals(200, kissa.getPisteet());
        kissa.muutaPisteita(-201);
        assertEquals(-1, kissa.getPisteet());
    }

    @Test
    public void palauttaaOikeanXKoordinaatin() {
        assertEquals(1, kissa.getX());
    }

    @Test
    public void palauttaaOikeanYKoordinaatin() {
        assertEquals(2, kissa.getY());
    }

    @Test
    public void toStringPalauttaaOikeanNimen() {
        assertEquals("X", kissa.toString());
    }
}
