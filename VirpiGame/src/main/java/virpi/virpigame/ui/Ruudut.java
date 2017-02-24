package virpi.virpigame.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import virpi.virpigame.logiikka.Peli;

public class Ruudut {

    private Peli peli;
    
    public Ruudut(Peli peli) {
        this.peli = peli;
    }

    
    
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
        g.drawString("Paina <SPACE> jos haluat nähdä ohjeet", 200, 200);
    }
    
    public void piirraLoppuruutu(Graphics g) {
        Font otsikkofontti = new Font("Comic Sans MS", Font.BOLD, 30);
        g.setFont(otsikkofontti);
        g.setColor(Color.BLACK);
        g.drawString("Peli loppui!", 200, 50);
        g.drawString("Sait pisteitä " + peli.getPisteet(), 200, 150);
        g.drawString("Paina <ENTER> palataksesi alkuun", 200, 300);
    }
    
    public void piirraPisteet(Graphics g){
        Font pistefontti = new Font("Comic Sans MS", Font.BOLD, 15);
        g.setFont(pistefontti);
        g.setColor(Color.BLACK);
        g.drawString("Pisteesi: " + peli.getPisteet(), 250, 440);        
        
    }
    
    public void piirraKayttoOhje(Graphics g){
        Font ohjefontti = new Font("Comic Sans MS", Font.BOLD, 15);
        g.setFont(ohjefontti);
        g.setColor(Color.BLACK);
        g.drawString("Ohjaa pelihahmoa eli mustaa palloa nuolinäppäimillä tai WASD.", 200, 150);
        g.drawString("Neliöitä pitää varoa, niistä tulee miinuspisteitä ja jos pisteet menevät miinukselle, peli loppuu.", 200, 180);
        g.drawString("Palloja keräämällä saat lisäpisteitä.", 200, 210);
        g.drawString("Paina <ENTER> palataksesi alkuun", 200, 300);
    }
    
    

}
