package virpi.virpigame;

import java.awt.Graphics;
import javax.swing.JPanel;
import virpi.virpigame.objects.*;

public class Peli extends JPanel {

    private Kartta kartta;
    private Ruoka sapuska;
    private Koira jali;

    /**
     * Konstruktorissa luodaan uusi Kartta -olio ja tällä hetkellä testailua
     * varten aloitetaan peli ja luodaan pari muuta liikkuvaa joilla testailla
     */
    public Peli() {
        kartta = new Kartta();
        aloita("Virpi");
    //    sapuska = new Ruoka("Joo", 100, 20, 10);
    //    jali = new Koira(200, 3, 20);

    }

    public void paintComponent(Graphics g) {
        kartta.virpi().piirraLiikkuva(g);
        this.sapuska.piirraLiikkuva(g);
        this.jali.piirraLiikkuva(g);
        sleepRefresh();
    }

    void sleepRefresh() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
        }
        repaint();
    }

    /**
     * luodaan uusi kartta annetulla pelihahmon nimella ja lisäillään asioita
     *
     * @param kissanNimi annetaan luotavan pelihahmon nimi parametrina
     */
    public void aloita(String kissanNimi) {
        this.lisaaRuokia();
        this.lisaaKoiria();
        kartta.lisaaPelihahmo(kissanNimi);
    }

    public Kartta getKartta() {
        return kartta;
    }

    public int getPisteet() {
        return kartta.virpinPisteet();
    }

    /**
     * luodaan ja lisätään muutamia ruoka -olioita kartalle
     */
    public void lisaaRuokia() {
        Ruoka ruoka1 = new Ruoka("Latz", 100, 300, 300);
        Ruoka ruoka2 = new Ruoka("Whiskas", 300, 150, 200);
        Ruoka ruoka3 = new Ruoka("Royal Canin", 500, 220, 0);
        kartta.lisaaLiikkuva(ruoka1);
        kartta.lisaaLiikkuva(ruoka2);
        kartta.lisaaLiikkuva(ruoka3);
    }

    /**
     * luodaan ja lisätään muutamia koira -olioita kartalle
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

}
