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
        if (peli.getElamat() == 0){
        g.drawString("Peli loppui!", 200, 50);
        g.drawString("Sait pisteitä " + peli.getPisteet(), 200, 150);
        g.drawString("Paina <ENTER> palataksesi alkuun", 200, 300);
        }
        if (peli.getPisteet() == 5000){
        g.drawString("Onneksi olkoon, sait 5000 pistettä ja pääsit pelin läpi!", 200, 50);
        g.drawString("Sinulle jäi vielä " + peli.getElamat() + " elämää.", 200, 150);
        g.drawString("Paina <ENTER> palataksesi alkuun", 200, 300);
        }
    }
    
    public void piirraPisteet(Graphics g){
        Font pistefontti = new Font("Comic Sans MS", Font.BOLD, 15);
        g.setFont(pistefontti);
        g.setColor(Color.BLACK);
        g.drawString("Pisteesi: " + peli.getPisteet() + "                      Elämiä jäljellä: " + peli.getElamat(), 350, 420);
    }
    
    public void piirraKayttoOhje(Graphics g){
        Font ohjefontti = new Font("Comic Sans MS", Font.BOLD, 15);
        g.setFont(ohjefontti);
        g.setColor(Color.BLACK);
        g.drawString("Ohjaa pelihahmoa eli mustaa kissaa nuolinäppäimillä tai WASD.", 200, 150);
        g.drawString("Varo vihaisia koiria, niistä menettää elämiä ja jos elämät loppuvat, pelikin loppuu.", 200, 180);
        g.drawString("Hiiriä keräämällä saat pisteitä, jos saat kasaan 5000, olet päässyt pelin läpi!", 200, 210);
        g.drawString("Paina <ENTER> palataksesi alkuun", 200, 300);
    }
    
    

}
