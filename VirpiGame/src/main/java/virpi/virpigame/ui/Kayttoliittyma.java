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

        //    frame.setPreferredSize(new Dimension(1000, 500));        
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.pack();
    }

    private void luoKomponentit(Container container) {
        //JLabel tervehdys = new JLabel("Tervetuloa peliin Virpi and friends!");
        container.add(new JLabel("Tervetuloa peliin Virpi and friends!"), BorderLayout.NORTH);
        container.add(new Peli());
    }

    public JFrame getFrame() {
        return frame;
    }
}
