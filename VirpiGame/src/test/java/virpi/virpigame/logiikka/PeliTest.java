
package virpi.virpigame.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import virpi.virpigame.objects.Ruoka;


public class PeliTest {

    Peli peli;

    public PeliTest() {

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
        peli.aloita();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettiOikeatKoordinaatit() {
        assertEquals(10, peli.getY());
        assertEquals(1220, peli.getX());
    }

    @Test
    public void aloitusLoiKartanJaAsettiPelihahmon() {
        assertEquals("kissa", peli.getPelihahmo().toString());
    }

    @Test
    public void kaikkiMuuttujatOikeissaAloitusarvoissa() {
        assertEquals(0, peli.getPisteet());
        assertEquals(5, peli.getElamat());
        assertEquals(0, peli.getLaskuri());
        assertEquals(1, peli.getTaso());
        assertEquals(Pelitila.ALKURUUTU, peli.getTila());
    }

    @Test
    public void paivitysPaivittaaLaskuriaJaNollaa() {
        peli.paivitaTila();
        assertEquals(1, peli.getLaskuri());        
        peli.setLaskuri(180);
        peli.paivitaTila();
        assertEquals(0, peli.getLaskuri());
    }
    
    @Test 
        public void lopputilaJosElamatLoppuu() {
        peli.setElamat(0);
        peli.paivitaTila();
        assertEquals(Pelitila.LOPPURUUTU, peli.getTila());
    }
    
    @Test
    public void lopputilaJosTasoYli10() {
        peli.setTaso(11);
        peli.paivitaTila();
        assertEquals(Pelitila.LOPPURUUTU, peli.getTila());
    }

    @Test
    public void paivitysLisaaLiikkuvan() {
        peli.setLaskuri(179);
        peli.paivitaTila();
        assertEquals(1, peli.getKartta().getLiikkuvat().size());
    }
    
    @Test
    public void liikkuvienLisaysToimii() {
        peli.setLaskuri(45);
        peli.lisaaLiikkuvia();
        assertEquals(1, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(135);
        peli.lisaaLiikkuvia();        
        assertEquals(2, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(90);
        peli.lisaaLiikkuvia();
        assertEquals(3, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(180);
        peli.lisaaLiikkuvia();
        assertEquals(4, peli.getKartta().getLiikkuvat().size());        
    }
    
    @Test
    public void kartanPaivitysToimii() {
        Kartta kartta = peli.getKartta();
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
    public void tasoVaihtuuJosTarpeeksiPisteita() {
        assertEquals(1, peli.getTaso());
        peli.setPisteet(500);
        peli.paivitaTila();
        assertEquals(2, peli.getTaso());        
    }
    
    @Test
    public void josOsuuRuokaanNiinSaaPisteita() {
        Ruoka ruoka = new Ruoka("R1", 10, 5);
        peli.getKartta().lisaaLiikkuva(ruoka);
        assertEquals(ruoka, peli.getKartta().getLiikkuvat().get(0));
        peli.paivitaTila();
        assertEquals(100, peli.getPisteet());
        assertEquals(true, peli.getKartta().getLiikkuvat().isEmpty());
    }

    @Test
    public void liikutteluToimii() {
        peli.liikutaOikealle();
        assertEquals(20, peli.getPelihahmo().getX());
        peli.liikutaVasemmalle();
        assertEquals(0, peli.getPelihahmo().getX());
        peli.liikutaYlos();
        assertEquals(4, peli.getPelihahmo().getY());
        peli.liikutaAlas();
        assertEquals(5, peli.getPelihahmo().getY());
    }

    @Test
    public void tilanAsetusToimii() {
        peli.setTila(Pelitila.PELI);
        assertEquals(Pelitila.PELI, peli.getTila());
    }

}
