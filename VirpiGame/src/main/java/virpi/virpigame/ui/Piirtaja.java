package virpi.virpigame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import virpi.virpigame.logiikka.*;
import virpi.virpigame.objects.*;

public class Piirtaja extends JPanel {

    private Peli peli;
    private Ruudut ruudut;
    private BufferedImage pelihahmo;
    private BufferedImage ruoka;
    private BufferedImage koira;

    Piirtaja(Peli peli) {
        this.peli = peli;
        ruudut = new Ruudut(peli);
        ruoka = LoadImage("Hiiri.png");
        koira = LoadImage("Koira.png");
        pelihahmo = LoadImage("Virpi.png");
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
            if (piirrettava.toString().equals("ruoka")) {
                //               BufferedImage ruoka = LoadImage("Hiiri.png");
                g.drawImage(ruoka, piirrettava.getX(), (piirrettava.getY() * 40), null);
//                g.setColor(Color.WHITE);
//                g.fillOval(piirrettava.getX(), piirrettava.getY() * 40, 40, 40);
            }
            if (piirrettava.toString().equals("koira")) {
                //               BufferedImage koira = LoadImage("Koira.png");
                g.drawImage(koira, piirrettava.getX(), (piirrettava.getY() * 40), null);

//               g.setColor(Color.RED);
                //               g.fillRect(piirrettava.getX(), piirrettava.getY() * 40, 40, 40);
            }
        }

//        BufferedImage pelihahmo = LoadImage("Virpi.png");
        g.drawImage(pelihahmo, peli.getPelihahmo().getX(), (peli.getPelihahmo().getY() * 40), null);
//        g.setColor(Color.BLACK);
//        g.fillOval(peli.getPelihahmo().getX(), (peli.getPelihahmo().getY() * 40), 40, 40);
    }

    BufferedImage LoadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {

        }
        return img;
    }

}
