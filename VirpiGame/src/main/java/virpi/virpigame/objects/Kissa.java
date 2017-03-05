package virpi.virpigame.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Kissa extends Liikkuva {

//    private int x;
//    private int y;

    /**
     * Luodaan pelihahmona toimiva Kissa-olio.
     *
     * @param x -koordinaatti.
     * @param y -koordinaatti.
     */
    public Kissa(int x, int y) {
        super(x, y);
    }
    
    @Override
    public void liikuVasemmalle() {
        if (super.getX() > 0) {
            super.liikuVasemmalle();
        }

    }

    @Override
    public String toString() {
        return "kissa";
    }

}
