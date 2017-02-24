package virpi.virpigame.logiikka;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import virpi.virpigame.objects.*;
import virpi.virpigame.ui.Ruudut;

public class Peli extends JPanel {

    private Kartta kartta;
    private Ruudut ruudut;
    private int laskuri;
    private Kissa pelihahmo;
    private Pelitila tila;

    /**
     * Konstruktorissa luodaan uusi Kartta -olio ja ruudut, asetetaan laskuri
     * nollaan ja aloitetaan peli.
     */
    public Peli() {
        kartta = new Kartta(10, 1200);
        ruudut = new Ruudut(this);
        laskuri = 0;
        aloita();
    }

    /**
     * Pelin aloituskomento luo pelihahmon ja lisää pelihahmon karttaan. Sitten
     * kutsuu omia koirien ja ruokien lisäilymetodeita.
     */
    public void aloita() {
        tila = Pelitila.ALKURUUTU;
        pelihahmo = new Kissa("Virpi", 0, kartta.haeAloitusRuutu());
        kartta.lisaaPelihahmo(pelihahmo);
        this.lisaaRuokia();
        this.lisaaKoiria();
    }

    /**
     * Piirretään ruutu uusiksi ja lopuksi päivitetään pelin tila. Mikäli
     * pelitilana on ALKURUUTU tai LOPPURUUTU piirretään vastaavat screenit.
     *
     * @param g grafiikkaparametri
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, 1200, 480);
        if (tila.equals(Pelitila.PELI)) {
            kartta.piirraOliot(g);
            ruudut.piirraPisteet(g);
            paivitaTila();
        } else if (tila.equals(Pelitila.ALKURUUTU)) {
            ruudut.piirraAlkuruutu(g);
        } else if (tila.equals(Pelitila.LOPPURUUTU)) {
            ruudut.piirraLoppuruutu(g);
        } else if (tila.equals(Pelitila.OHJEET)) {
            ruudut.piirraKayttoOhje(g);
        }

    }

    /**
     * Päivitetään pelin tilaa. Laskuri juoksee ja tietyillä laskurin arvoilla
     * lisätään erilaisia olioita ruudulle. Nämä vielä kiinteitä, pitää lisätä
     * randomia. Mikäli pisteet menevät miinukselle, pelitilaksi LOPPURUUTU.
     */
    private void paivitaTila() {
        laskuri++;
        if (laskuri == 90) {
            kartta.lisaaLiikkuva(new Koira(-300, 1100, 7));
        } else if (laskuri == 180) {
            kartta.lisaaLiikkuva(new Koira(-300, 1100, 9));
        } else if (laskuri == 300) {
            kartta.lisaaLiikkuva(new Koira(-300, 1100, 5));
        }

        if (laskuri == 140) {
            kartta.lisaaLiikkuva(new Ruoka("safka" + laskuri, 400, 1100, 3));
        }
        if (laskuri == 360) {
            kartta.lisaaLiikkuva(new Ruoka("safka" + laskuri, 400, 1100, 8));
            laskuri = 0;
        }
        kartta.paivitaKartta();
        if (kartta.getVirpi().getPisteet() < 0) {
            tila = Pelitila.LOPPURUUTU;
        }
    }

    /**
     * Hahmo liikkuu ja piirretään uusiksi.
     */
    public void liikutaYlos() {
        kartta.liikutaHahmoaYlosJaPiirra(this.getGraphics());
        repaint();
    }

    /**
     * Hahmo liikkuu ja piirretään uusiksi.
     */
    public void liikutaAlas() {
        kartta.liikutaHahmoaAlasJaPiirra(this.getGraphics());
        repaint();
    }

    /**
     * Hahmo liikkuu ja piirretään uusiksi.
     */
    public void liikutaVasemmalle() {
        for (int i = 0; i < 40; i++) {
            kartta.liikutaHahmoaVasemmalleJaPiirra(this.getGraphics());
            repaint();
        }

    }

    /**
     * Hahmo liikkuu ja piirretään uusiksi.
     */
    public void liikutaOikealle() {
        for (int i = 0; i < 40; i++) {
            kartta.liikutaHahmoaOikealleJaPiirra(this.getGraphics());
            repaint();
        }

    }

    public Kartta getKartta() {
        return kartta;
    }

    public int getPisteet() {
        return this.kartta.getVirpi().getPisteet();
    }

    public Pelitila getTila() {
        return this.tila;
    }

    public void setTila(Pelitila tila) {
        this.tila = tila;
    }

    /**
     * Luodaan ja lisätään muutamia ruoka -olioita kartalle.
     */
    public void lisaaRuokia() {
        Ruoka ruoka1 = new Ruoka("Latz", 100, 800, 3);
        Ruoka ruoka2 = new Ruoka("Whiskas", 300, 900, 2);
        Ruoka ruoka3 = new Ruoka("Royal Canin", 500, 1100, 0);
        kartta.lisaaLiikkuva(ruoka1);
        kartta.lisaaLiikkuva(ruoka2);
        kartta.lisaaLiikkuva(ruoka3);
    }

    /**
     * Luodaan ja lisätään muutamia koira -olioita kartalle.
     */
    public void lisaaKoiria() {
        Koira k1 = new Koira(-200, 1200, 4);
        Koira k2 = new Koira(-200, 1000, 0);
        Koira k3 = new Koira(-200, 700, 2);
        Koira k4 = new Koira(-200, 250, 1);
        kartta.lisaaLiikkuva(k1);
        kartta.lisaaLiikkuva(k2);
        kartta.lisaaLiikkuva(k3);
        kartta.lisaaLiikkuva(k4);
    }

}
