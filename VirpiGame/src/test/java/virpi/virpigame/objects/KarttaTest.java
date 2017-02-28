package virpi.virpigame.objects;

import virpi.virpigame.logiikka.Kartta;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virpi.virpigame.logiikka.Peli;

public class KarttaTest {

    // Testaillaan samalla myös Peli -luokan toimivuutta
    Kartta kartta;
    Peli peli;

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
        peli = new Peli();
        kartta = peli.getKartta();
    }

    @After
    public void tearDown() {
    }

        

//    @Test
//    public void pelihahmonLiikutteluToimii() {
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][0]);
//        kartta.liikutaHahmoaOikealle();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][1]);
//        kartta.liikutaHahmoaOikealle();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][2]);
//        kartta.liikutaHahmoaVasemmalle();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][1]);
//        kartta.liikutaHahmoaAlas();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[3][1]);
//        kartta.liikutaHahmoaYlos();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][1]);
//        kartta.liikutaHahmoaVasemmalle();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][0]);
//    }

//    @Test
//    public void liikkuvienLiikutteluToimii() {
//        Ruoka ruoka = new Ruoka("Latz", 100, 2, 1);
//        kartta.lisaaLiikkuva(ruoka);        
//        kartta.liikutaVasemmalle(ruoka);
//        assertEquals(1, kartta.palautaKartta()[1][1]);
//        kartta.liikutaOikealle(ruoka);
//        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
//        kartta.liikutaYlos(ruoka);
//        assertEquals(ruoka, kartta.palautaKartta()[0][2]);
//        kartta.liikutaAlas(ruoka);
//        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
//    }

//    public void liikutusUlosLaudaltaEiOnnistu() {
//        Ruoka ruoka1 = new Ruoka("R1", 100, 0, 0);
//        Ruoka ruoka2 = new Ruoka("R2", 100, 0, 4);
//        Ruoka ruoka3 = new Ruoka("R3", 100, 29, 0);
//        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
//        assertEquals(ruoka2, kartta.palautaKartta()[4][0]);
//        assertEquals(ruoka3, kartta.palautaKartta()[0][29]);
//        kartta.liikutaYlos(ruoka1);
//        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
//        kartta.liikutaVasemmalle(ruoka1);
//        assertEquals(ruoka1, kartta.palautaKartta()[0][0]);
//        kartta.liikutaAlas(ruoka2);
//        assertEquals(ruoka2, kartta.palautaKartta()[4][0]);
//        kartta.liikutaOikealle(ruoka3);
//        assertEquals(ruoka3, kartta.palautaKartta()[0][29]);
//    }

    public void sijoitusKartanUlkopuolelleEiOnnistuMuttaKarttaanOnnistuu() {
        Ruoka ruoka1 = new Ruoka("R1", -1, -1);
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

//      
//    @Test
//    public void kartanPaivitysToimii() {
//        Ruoka ruoka5 = new Ruoka("R1", 0, 0);
//        kartta.lisaaLiikkuva(ruoka5);
//        Ruoka ruoka6 = new Ruoka("R2", 100, 3);
//        kartta.lisaaLiikkuva(ruoka6);
//
//        assertNotEquals(null, kartta.palautaKartta()[0][0]);
//        assertNotEquals(null, kartta.palautaKartta()[3][100]);
//        kartta.paivitaKartta();
//        assertEquals(null, kartta.palautaKartta()[0][0]);
//        assertNotEquals(null, kartta.palautaKartta()[3][99]);
//        assertEquals(null, kartta.palautaKartta()[3][100]);
//        
//  }
    
    
    
    @Test
    public void pisteetOikein() {
        assertEquals(0, peli.getPisteet());
    }
}
