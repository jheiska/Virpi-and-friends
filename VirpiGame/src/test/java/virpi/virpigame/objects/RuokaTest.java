package virpi.virpigame.objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuokaTest {

    Ruoka ruoka;

    public RuokaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruoka = new Ruoka("Sapuska", 100, 2, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void liikkuuYlosEikaMeneNegatiiviseksi() {
        ruoka.liikuYlos();
        assertEquals(2, ruoka.getY());
        ruoka.liikuYlos();
        assertEquals(1, ruoka.getY());
        ruoka.liikuYlos();
        assertEquals(0, ruoka.getY());
        ruoka.liikuYlos();
        assertEquals(0, ruoka.getY());
    }

    @Test
    public void liikkuuAlas() {
        ruoka.liikuAlas();
        assertEquals(4, ruoka.getY());
    }

    @Test
    public void liikkuuOikealle() {
        ruoka.liikuOikealle();
        assertEquals(3, ruoka.getX());
    }

    @Test
    public void liikkuuVasemmalleEikaMeneNegatiiviseksi() {
        ruoka.liikuVasemmalle();
        assertEquals(1, ruoka.getX());
        ruoka.liikuVasemmalle();
        assertEquals(0, ruoka.getX());
        ruoka.liikuVasemmalle();
        assertEquals(0, ruoka.getX());
    }

    @Test
    public void palauttaaOikeatPisteet() {
        assertEquals(100, ruoka.getPisteet());
    }

    @Test
    public void pisteetMuuttuvatOikeinEikäMeneNegatiiviseksi() {
        ruoka.muutaPisteita(300);
        assertEquals(400, ruoka.getPisteet());
        ruoka.muutaPisteita(-500);
        assertEquals(0, ruoka.getPisteet());
        ruoka.muutaPisteita(-1);
        assertEquals(0, ruoka.getPisteet());
    }

    @Test
    public void palauttaaOikeanXKoordinaatin() {
        assertEquals(2, ruoka.getX());
    }

    @Test
    public void palauttaaOikeanYKoordinaatin() {
        assertEquals(3, ruoka.getY());
    }

    @Test
    public void toStringPalauttaaOikeanNimen() {
        assertEquals("Sapuska", ruoka.toString());
    }
}
