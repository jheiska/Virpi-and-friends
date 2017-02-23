package virpi.virpigame.objects;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virpi.virpigame.Peli;

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

    @Test
    public void konstruktoriLuoOikeanKokoisenOletusKartan() {
        assertEquals(5, kartta.palautaKartta().length);
        assertEquals(30, kartta.palautaKartta()[0].length);
    }

    @Test
    public void customKonstruktoriLuoOikeanKokoisenKartan() {
        kartta = new Kartta(10, 50);
        assertEquals(10, kartta.palautaKartta().length);
        assertEquals(50, kartta.palautaKartta()[0].length);
    }

    @Test
    public void oikeaAloitusRuutu() {
        assertEquals(2, kartta.haeAloitusRuutu());
        kartta = new Kartta(10, 50);
        assertEquals(5, kartta.haeAloitusRuutu());
    }

    @Test
    public void tyhjanKartanTulostusToimii() {
        Kartta kartta = new Kartta(2, 4);
        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tuloste));
        kartta.tulostaKartta();
        assertEquals("____" + "\n" + "____" + "\n", tuloste.toString());
    }

//    @Test
//    public void kartanTulostusToimiiHahmollaJaSapuskalla() {
//        Kartta kartta = new Kartta(3, 4);          
//        Ruoka ruoka = new Ruoka("Latz", 100, 2, 1);
//        kartta.lisaaLiikkuva(ruoka);
//        ByteArrayOutputStream tuloste = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(tuloste));
//        kartta.tulostaKartta();
//        assertEquals("____" + "\n" + "X_L_" + "\n" + "____" + "\n", tuloste.toString());
//    }

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
//        kartta.liikutaHahmoaYlosJaPiirra();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][1]);
//        kartta.liikutaHahmoaVasemmalle();
//        assertEquals(kartta.palautaPelihahmo(), kartta.palautaKartta()[2][0]);
//    }

    @Test
    public void liikkuvienSijoitusJaLiikutteluToimii() {
        Ruoka ruoka = new Ruoka("Latz", 100, 2, 1);
        kartta.lisaaLiikkuva(ruoka);
        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
        kartta.liikutaVasemmalle(ruoka);
        assertEquals(ruoka, kartta.palautaKartta()[1][1]);
        kartta.liikutaOikealle(ruoka);
        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
        kartta.liikutaYlos(ruoka);
        assertEquals(ruoka, kartta.palautaKartta()[0][2]);
        kartta.liikutaAlas(ruoka);
        assertEquals(ruoka, kartta.palautaKartta()[1][2]);
    }

    public void liikutusUlosLaudaltaEiOnnistu() {
        Ruoka ruoka1 = new Ruoka("R1", 100, 0, 0);
        Ruoka ruoka2 = new Ruoka("R2", 100, 0, 4);
        Ruoka ruoka3 = new Ruoka("R3", 100, 29, 0);
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
        Ruoka ruoka1 = new Ruoka("R1", 100, -1, -1);
        Ruoka ruoka2 = new Ruoka("R2", 100, 0, 5);
        Ruoka ruoka3 = new Ruoka("R3", 100, 30, 0);
        Ruoka ruoka4 = new Ruoka("R4", 100, 29, 6);
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka1));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka2));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka3));
        assertEquals(false, kartta.mahtuukoRuudukkoon(ruoka4));
        Ruoka ruoka5 = new Ruoka("R1", 100, 0, 0);
        Ruoka ruoka6 = new Ruoka("R2", 100, 20, 3);
        Ruoka ruoka7 = new Ruoka("R3", 100, 29, 0);
        Ruoka ruoka8 = new Ruoka("R4", 100, 15, 4);
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka5));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka6));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka7));
        assertEquals(true, kartta.mahtuukoRuudukkoon(ruoka8));
    }

    @Test
    public void pelinLuominenOnAsettanutKartalleVirpinJaRuuatJaKoirat(){
        assertNotEquals(null, kartta.palautaKartta()[2][0]);
        assertNotEquals(null, kartta.palautaKartta()[3][800]);
        assertNotEquals(null, kartta.palautaKartta()[2][900]);
        assertNotEquals(null, kartta.palautaKartta()[0][1100]);
        assertNotEquals(null, kartta.palautaKartta()[4][1200]);
        assertNotEquals(null, kartta.palautaKartta()[0][1000]);
        assertNotEquals(null, kartta.palautaKartta()[2][750]);
        assertNotEquals(null, kartta.palautaKartta()[1][250]);
        assertEquals(null, kartta.palautaKartta()[2][2]);
    }
    
    @Test
    public void kartanPaivitysToimii() {
        kartta.paivitaKartta();
        assertNotEquals(null, kartta.palautaKartta()[2][0]);
        assertEquals(null, kartta.palautaKartta()[3][3]);
        assertNotEquals(null, kartta.palautaKartta()[3][2]);
        assertEquals(null, kartta.palautaKartta()[2][15]);
        assertNotEquals(null, kartta.palautaKartta()[2][14]);
        assertNotEquals(null, kartta.palautaKartta()[0][21]);
        assertNotEquals(null, kartta.palautaKartta()[4][19]);
        assertNotEquals(null, kartta.palautaKartta()[0][9]);
        assertNotEquals(null, kartta.palautaKartta()[2][14]);
        assertNotEquals(null, kartta.palautaKartta()[1][24]);
        
    }
    
    
    
    @Test
    public void virpinPisteetOikein() {
        assertEquals(0, peli.getPisteet());
    }
}
