package virpi.virpigame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import virpi.virpigame.logiikka.*;
import virpi.virpigame.objects.*;

public class Piirtaja extends JPanel {

    private Peli peli;
    private Ruudut ruudut;


    Piirtaja(Peli peli) {
        this.peli = peli;
        ruudut = new Ruudut(peli);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(0, 0, 1200, 480);
        if (peli.getTila().equals(Pelitila.PELI)) {
            piirraOliot(g);
            ruudut.piirraPisteet(g);
        } else if (peli.getTila().equals(Pelitila.ALKURUUTU)) {
            ruudut.piirraAlkuruutu(g);
        } else if (peli.getTila().equals(Pelitila.LOPPURUUTU)) {
            ruudut.piirraLoppuruutu(g);
        } else if (peli.getTila().equals(Pelitila.OHJEET)) {
            ruudut.piirraKayttoOhje(g);
        }
    }

    private void piirraOliot(Graphics g) {
        for (Liikkuva piirrettava : peli.getLiikkuvat()) {
            if (piirrettava.toString().equals("ruoka")){
                g.setColor(Color.WHITE);
                g.fillOval(piirrettava.getX(), piirrettava.getY() * 40, 40, 40);
            }
            if (piirrettava.toString().equals("koira")){
                g.setColor(Color.RED);
                g.fillRect(piirrettava.getX(), piirrettava.getY() * 40, 40, 40);
            }
        }
        g.setColor(Color.BLACK);
        g.fillOval(peli.getPelihahmo().getX(), (peli.getPelihahmo().getY() * 40), 40, 40);
    }

}
