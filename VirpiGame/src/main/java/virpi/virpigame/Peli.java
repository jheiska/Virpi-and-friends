package virpi.virpigame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import virpi.virpigame.objects.*;
import virpi.virpigame.ui.Alkuruutu;

public class Peli extends JPanel implements KeyListener {

    private Kartta kartta;
    private Kissa pelihahmo;

    private enum Pelitila {
        ALKURUUTU, PELI
    };
    private Pelitila tila = Pelitila.ALKURUUTU;
    private Alkuruutu aloitus;

    /**
     * Konstruktorissa luodaan uusi Kartta -olio ja pelihahmo ja aloitetaan
     * peli.
     */
    public Peli() {
        aloitus = new Alkuruutu();
        kartta = new Kartta();
        pelihahmo = new Kissa("Virpi", 0, kartta.haeAloitusRuutu());
        kartta.lisaaPelihahmo(pelihahmo);
        this.aloita();
    }

    /**
     * Pelin aloituskomto kutsuu omia koirien ja ruokien lisäilymetodeita.
     */
    public void aloita() {
        this.lisaaRuokia();
        this.lisaaKoiria();

    }

    /**
     * Tyhjätään, piirretään ja päivitetään kenttää. Mikäli pelitilana on ALKURUUTU, piirretään alkuruutu.
     * @param g grafiikkaparametri
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, 1200, 240);
        if (tila.equals(Pelitila.PELI)) {
            kartta.piirraOliot(g);
            kartta.paivitaKartta();
        } else if (tila.equals(Pelitila.ALKURUUTU)) {
            aloitus.piirraAlkuruutu(g);
        }
        sleepRefresh();
    }

    /**
     * Odotellaan ja piirretään uudestaan.
     */
    void sleepRefresh() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
        }
        repaint();
    }

    public Kartta getKartta() {
        return kartta;
    }

    public int getPisteet() {
        return this.kartta.getVirpi().getPisteet();
    }

    /**
     * Luodaan ja lisätään muutamia ruoka -olioita kartalle.
     */
    public void lisaaRuokia() {
        Ruoka ruoka1 = new Ruoka("Latz", 100, 3, 3);
        Ruoka ruoka2 = new Ruoka("Whiskas", 300, 15, 2);
        Ruoka ruoka3 = new Ruoka("Royal Canin", 500, 22, 0);
        Ruoka ruoka4 = new Ruoka("Makkara", 500, 30, 4);
        kartta.lisaaLiikkuva(ruoka1);
        kartta.lisaaLiikkuva(ruoka2);
        kartta.lisaaLiikkuva(ruoka3);
        kartta.lisaaLiikkuva(ruoka4);
    }

    /**
     * Luodaan ja lisätään muutamia koira -olioita kartalle.
     */
    public void lisaaKoiria() {
        Koira k1 = new Koira(-200, 20, 4);
        Koira k2 = new Koira(-200, 10, 0);
        Koira k3 = new Koira(-200, 17, 2);
        Koira k4 = new Koira(-200, 25, 1);
        kartta.lisaaLiikkuva(k1);
        kartta.lisaaLiikkuva(k2);
        kartta.lisaaLiikkuva(k3);
        kartta.lisaaLiikkuva(k4);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (tila.equals(Pelitila.ALKURUUTU) && ke.getKeyCode() == KeyEvent.VK_ENTER) {
            tila = Pelitila.PELI;
        }
        if (tila.equals(Pelitila.PELI)) {
            if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
                kartta.liikutaHahmoaVasemmalle();
            } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
                kartta.liikutaHahmoaOikealle();
            } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
                kartta.liikutaHahmoaYlos();
            } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
                kartta.liikutaHahmoaAlas();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
    }

}
