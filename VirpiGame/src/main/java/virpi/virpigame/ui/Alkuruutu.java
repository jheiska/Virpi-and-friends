
package virpi.virpigame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import virpi.virpigame.Peli;


public class Alkuruutu {

    public Alkuruutu() {
    }
    
    public void PiirraAlkuruutu(Graphics g){
        Font otsikkofontti = new Font("Comic Sans MS", Font.BOLD, 50);
        g.setFont(otsikkofontti);
        g.setColor(Color.BLACK);
        g.drawString("Virpi and Friends", 200, 50);
        g.drawString("Paina <ENTER> aloittaaksesi", 200, 150);
    }
    
}
