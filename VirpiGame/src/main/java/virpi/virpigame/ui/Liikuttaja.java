package virpi.virpigame.ui;

import virpi.virpigame.objects.Kartta;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Liikuttaja implements KeyListener {

    private Kartta kartta;

    Liikuttaja(Kartta kartta) {
        this.kartta = kartta;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT || ke.getKeyCode() == KeyEvent.VK_A) {
            kartta.liikutaHahmoaVasemmalle();
        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT || ke.getKeyCode() == KeyEvent.VK_D) {
            kartta.liikutaHahmoaOikealle();
        } else if (ke.getKeyCode() == KeyEvent.VK_UP || ke.getKeyCode() == KeyEvent.VK_W) {
            kartta.liikutaHahmoaYlos();
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN || ke.getKeyCode() == KeyEvent.VK_S) {
            kartta.liikutaHahmoaAlas();
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
    }

}
