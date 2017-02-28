/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virpi.virpigame.ui;

import virpi.virpigame.logiikka.Peli;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import virpi.virpigame.logiikka.Pelitila;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     * Konstruktori.
     */
    public Kayttoliittyma() {
    }

    @Override
    public void run() {

        frame = new JFrame("Virpi and friends");
        Peli peli = new Peli();
        Piirtaja piirtaja = new Piirtaja(peli);
        frame.setPreferredSize(new Dimension(1200, 480));
        frame.add(piirtaja);
        frame.addKeyListener(new NappaintenKuuntelija(peli));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        
        Timer timer = new Timer(13, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if (peli.getTila() == Pelitila.PELI){
                    peli.paivitaTila();    
                }
                
                frame.repaint();
            }
        });
        
        peli.aloita();
        timer.start();

    }

    public JFrame getFrame() {
        return frame;
    }

}
