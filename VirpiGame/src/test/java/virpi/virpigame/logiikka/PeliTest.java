/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virpi.virpigame.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaakk_000
 */
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
    public void paivitysPaivittaaLaskuriaJaAsettaaLopputilan() {
        peli.paivitaTila();
        assertEquals(1, peli.getLaskuri());
        peli.setElamat(0);
        peli.paivitaTila();
        assertEquals(Pelitila.LOPPURUUTU, peli.getTila());
    }

    @Test
    public void paivitysLisaaRuokiaJaKoiriaJaNollaaLaskurin() {
        peli.setLaskuri(44);
        peli.paivitaTila();
        assertEquals(1, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(134);
        peli.paivitaTila();
        assertEquals(2, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(89);
        peli.paivitaTila();
        assertEquals(3, peli.getKartta().getLiikkuvat().size());
        peli.setLaskuri(179);
        peli.paivitaTila();
        assertEquals(4, peli.getKartta().getLiikkuvat().size());
        peli.paivitaTila();
        assertEquals(0, peli.getLaskuri());
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
