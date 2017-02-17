/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virpi.virpigame.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import virpi.virpigame.*;

public class Kayttoliittyma implements Runnable {
    
    private JFrame frame;
    
    public Kayttoliittyma() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("Virpi and friends");
        Peli peli = new Peli();
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.add(peli);
        frame.addKeyListener(peli);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //luoKomponentit(frame.getContentPane());
        frame.pack();
    }
    
//    private void luoKomponentit(Container container) {        
//        container.add(new JLabel("Tervetuloa peliin Virpi and friends. Paina enter aloittaaksesi!"), BorderLayout.NORTH);
//        Peli peli = new Peli();
//        container.add(peli);
//        frame.addKeyListener(peli);
//    }
    
    public JFrame getFrame() {
        return frame;
    }
}
