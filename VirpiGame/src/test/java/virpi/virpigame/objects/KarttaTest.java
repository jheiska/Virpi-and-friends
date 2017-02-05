package virpi.virpigame.objects;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KarttaTest {

    Kartta kartta;

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
        kartta = new Kartta();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriLuoOikeanKokoisenOletusKartan() {
        assertEquals(5, kartta.palautaKartta().length);
        assertEquals(30, kartta.palautaKartta()[0].length, 30);
    }

    @Test
    public void customKonstruktoriLuoOikeanKokoisenOletusKartan() {
        kartta = new Kartta(10, 50);
        assertEquals(10, kartta.palautaKartta().length);
        assertEquals(50, kartta.palautaKartta()[0].length, 30);
    }

    @Test
    public void oikeaAloitusRuutu() {
        assertEquals(2, kartta.haeAloitusRuutu());
        kartta = new Kartta(10, 50);
        assertEquals(5, kartta.haeAloitusRuutu());
    }

//    @Test
//    public void palauttaaOikeanKokoisenKartan() {
//        assertEquals(kartta, kartta.palautaKartta());
//    }
    @Test
    public void tyhjanKartanTulostusToimii() {
        Kartta kartta = new Kartta(2, 4);
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));
        kartta.tulostaKartta();
        assertEquals("____" + "\n" + "____" + "\n", tuloste.toString());
    }

    @Test
    public void kartanTulostusToimiiParillaLiikkuvalla() {
        Kartta kartta = new Kartta(3, 4);
        Kissa virpi = new Kissa("Virpi", 0, kartta.haeAloitusRuutu());
        kartta.lisaaLiikkuva(virpi);
        Ruoka ruoka = new Ruoka("Latz", 2, 1);
        kartta.lisaaLiikkuva(ruoka);
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));
        kartta.tulostaKartta();
        assertEquals("____" + "\n" + "V_L_" + "\n" + "____" + "\n", tuloste.toString());
    }

    @Test
    public void liikkuvienSijoitusJaLiikutteluToimii() {
        Kissa virpi = new Kissa("Virpi", 0, kartta.haeAloitusRuutu());
        kartta.lisaaLiikkuva(virpi);
        Ruoka ruoka = new Ruoka("Latz", 2, 1);
        kartta.lisaaLiikkuva(ruoka);
        assertEquals(virpi, kartta.palautaKartta()[2][0]);
        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
        kartta.liikutaOikealle(virpi);
        kartta.liikutaVasemmalle(ruoka);
        assertEquals(virpi, kartta.palautaKartta()[2][1]);
        assertEquals(ruoka, kartta.palautaKartta()[1][1]);
        kartta.liikutaAlas(virpi);
        kartta.liikutaYlos(ruoka);
        assertEquals(virpi, kartta.palautaKartta()[3][1]);
        assertEquals(ruoka, kartta.palautaKartta()[0][1]);
    }
    
    public void liikutusUlosLaudaltaEiOnnistu() {
        Ruoka ruoka1 = new Ruoka("R1", 0, 0);
        Ruoka ruoka2 = new Ruoka("R2", 0, 4);
        Ruoka ruoka3 = new Ruoka("R3", 29, 0);
        Ruoka ruoka4 = new Ruoka("R4", 29, 4);
        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
        assertEquals(ruoka2, kartta.palautaKartta()[4][0]);
        assertEquals(ruoka3, kartta.palautaKartta()[0][29]);
        kartta.liikutaYlos(ruoka1);
        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
        kartta.liikutaVasemmalle(ruoka1);
        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
        kartta.liikutaAlas(ruoka2);
        assertEquals(ruoka2, kartta.palautaKartta()[4][0]);
        kartta.liikutaOikealle(ruoka3);
        assertEquals(ruoka3, kartta.palautaKartta()[0][29]);
    }
    
    public void sijoitusKartanUlkopuolelleEiOnnistuMuttaKarttaanOnnistuu() {
        Ruoka ruoka1 = new Ruoka("R1", -1, -1);
        Ruoka ruoka2 = new Ruoka("R2", 0, 5);
        Ruoka ruoka3 = new Ruoka("R3", 30, 0);
        Ruoka ruoka4 = new Ruoka("R4", 29, 6);
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka1));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka2));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka3));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka4));
        Ruoka ruoka5 = new Ruoka("R1", 0, 0);
        Ruoka ruoka6 = new Ruoka("R2", 20, 3);
        Ruoka ruoka7 = new Ruoka("R3", 29, 0);
        Ruoka ruoka8 = new Ruoka("R4", 15, 4);
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka5));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka6));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka7));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka8));
    }
}
