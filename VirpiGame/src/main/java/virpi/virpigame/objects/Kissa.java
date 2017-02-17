package virpi.virpigame.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Kissa implements Liikkuva {

    private String nimi;
    private int pisteet;
    private int x;
    private int y;

    /**    
     * Luodaan pelihahmona toimiva Kissa-olio.
     * @param nimi kissalle nimi.
     * @param x -koordinaatti.
     * @param y -koordinaatti.
     */
    public Kissa(String nimi, int x, int y) {
        this.nimi = nimi;
        this.x = x;
        this.y = y;
        this.pisteet = 0;
    }

    @Override
    public void liikuYlos() {
        if (this.y > 0) {
            this.y--;
        }
    }

    @Override
    public void liikuAlas() {
        this.y++;
    }

    @Override
    public void liikuOikealle() {
        this.x++;
    }

    @Override
    public void liikuVasemmalle() {
        if (this.x > 0) {
            this.x--;
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getPisteet() {
        return pisteet;
    }

    @Override
    public void muutaPisteita(int muutos) {
        pisteet += muutos;
        if (pisteet < 0) {
            pisteet = 0;
        }
    }

    @Override
    public String toString() {
        //return this.nimi;
        return "X";
    }

    @Override
    public void piirraLiikkuva(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x * 40, y * 40, 40, 40);
    }

}
