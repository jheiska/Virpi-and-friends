package virpi.virpigame.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virpi.virpigame.objects.Kissa;
import virpi.virpigame.objects.Ruoka;

public class KarttaTest {

    // Testaillaan samalla myös Peli -luokan toimivuutta
    Kartta kartta;
    Kissa pelihahmo;

    public KarttaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kartta = new Kartta(1200, 10);
        pelihahmo = new Kissa(0, 5);
        kartta.lisaaPelihahmo(pelihahmo);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelihahmonLisaaminenOnnistui() {
        assertEquals(pelihahmo, kartta.getVirpi());
    }

    @Test
    public void pelihahmonLiikutteluToimiiEikaMeneUlosVasemmalta() {
        kartta.liikutaHahmoaOikealle();
        assertEquals(1, pelihahmo.getX());
        kartta.liikutaHahmoaYlos();
        assertEquals(4, pelihahmo.getY());
        kartta.liikutaHahmoaVasemmalle();
        assertEquals(0, pelihahmo.getX());
        kartta.liikutaHahmoaVasemmalle();
        assertEquals(0, pelihahmo.getX());
        kartta.liikutaHahmoaAlas();
        assertEquals(5, pelihahmo.getY());
    }

    public void liikutusUlosLaudaltaEiOnnistu() {
        Ruoka ruoka1 = new Ruoka("R1", 1200, 0);
        Ruoka ruoka2 = new Ruoka("R2", 0, 10);
        kartta.liikutaYlos(ruoka1);
        assertNotEquals(-1 , ruoka1.getX());
        kartta.liikutaOikealle(ruoka1);
        assertNotEquals(1201, ruoka1.getX());
        kartta.liikutaAlas(ruoka2);
        assertNotEquals(11, ruoka2.getX());
        //paitsi vasemmalle, johon saa liikkua vapaasti ulos laudalta
        kartta.liikutaVasemmalle(ruoka2);
        assertEquals(-1, ruoka2.getX());
    }

    public void sijoitusKartanUlkopuolelleEiOnnistuMuttaKarttaanOnnistuu() {
        Ruoka ruoka1 = new Ruoka("R1", 0, -1);
        Ruoka ruoka2 = new Ruoka("R2", 0, 11);
        Ruoka ruoka3 = new Ruoka("R3", 1221, 0);
        Ruoka ruoka4 = new Ruoka("R4", 1220, 11);
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka1));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka2));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka3));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka4));
        Ruoka ruoka5 = new Ruoka("R1", 0, 0);
        Ruoka ruoka6 = new Ruoka("R2", 1200, 0);
        Ruoka ruoka7 = new Ruoka("R3", 1200, 10);
        Ruoka ruoka8 = new Ruoka("R4", 0, 10);
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka5));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka6));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka7));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka8));
    }

    @Test
    public void kartanPaivitysToimii() {
        Ruoka ruoka5 = new Ruoka("R1", 1, 0);
        kartta.lisaaLiikkuva(ruoka5);
        Ruoka ruoka6 = new Ruoka("R2", 100, 3);
        kartta.lisaaLiikkuva(ruoka6);

        assertEquals(1, kartta.getLiikkuvat().get(0).getX());
        assertEquals(100, kartta.getLiikkuvat().get(1).getX());
        kartta.paivitaKartta();
        assertEquals(0, kartta.getLiikkuvat().get(0).getX());
        assertEquals(99, kartta.getLiikkuvat().get(1).getX());
        kartta.paivitaKartta();
        assertEquals(-1, kartta.getLiikkuvat().get(0).getX());
        assertEquals(98, kartta.getLiikkuvat().get(1).getX());
    }

    @Test
    public void randomKoiranLisaysToimii() {
        kartta.lisaaKoira();
        assertEquals("koira", kartta.getLiikkuvat().get(0).toString());      
    }
    
    @Test
    public void randomSapuskanLisaysToimii() {
        kartta.lisaaRuoka();
        assertEquals("ruoka", kartta.getLiikkuvat().get(0).toString());        
    }
    
    

}
