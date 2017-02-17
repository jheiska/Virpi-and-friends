package virpi.virpigame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import virpi.virpigame.Peli;

public class Alkuruutu {

    /**
     * Piirretään aloitusruutu - lähinnä tekstiä ainakin tässä vaiheessa.
     *
     * @param g grafiikkaparametri
     */
    public void piirraAlkuruutu(Graphics g) {
        Font otsikkofontti = new Font("Comic Sans MS", Font.BOLD, 30);
        g.setFont(otsikkofontti);
        g.setColor(Color.BLACK);
        g.drawString("Virpi and Friends", 200, 50);
        g.drawString("Paina <ENTER> aloittaaksesi", 200, 150);
    }

}
