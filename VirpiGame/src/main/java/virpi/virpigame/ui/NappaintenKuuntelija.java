
package virpi.virpigame.ui;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import virpi.virpigame.Peli;
import virpi.virpigame.Pelitila;


public class NappaintenKuuntelija implements KeyListener  {
    
    private Peli peli;
    private Graphics g;
    
    public NappaintenKuuntelija(Peli peli){
        this.peli = peli;
        
    }
    
//    @Override
    public void keyPressed(KeyEvent ke) {
        if (peli.getTila().equals(peli.getTila().ALKURUUTU) && ke.getKeyCode() == KeyEvent.VK_ENTER) {
            peli.setTila(Pelitila.PELI);
        }
        if (peli.getTila().equals(peli.getTila().PELI)) {
            if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
                peli.liikutaVasemmalle();
            } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
                peli.liikutaOikealle();
            } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
                peli.liikutaYlos();
            } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
                peli.liikutaAlas();
            }
        }
    }
    
//    public void liikutaYlos(){
//        peli.getKartta().liikutaHahmoaYlosJaPiirra(g);
//    }
//    
//    public void liikutaAlas(){
//        peli.getKartta().liikutaHahmoaAlasJaPiirra(g);
//    }
//    public void liikutaVasemmalle(){
//        peli.getKartta().liikutaHahmoaVasemmalleJaPiirra(g);
//    }
//    public void liikutaOikealle(){
//        peli.getKartta().liikutaHahmoaOikealleJaPiirra(g);
//    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
    }

}