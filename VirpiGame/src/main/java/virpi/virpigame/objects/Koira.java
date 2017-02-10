package virpi.virpigame.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Koira implements Liikkuva {

    private int pisteet;
    private int x;
    private int y;

    public Koira(int pisteet, int x, int y) {
        this.pisteet = pisteet;
        this.x = x;
        this.y = y;
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
    }

    @Override
    public String toString() {
        return "K";

    }

    @Override
    public void piirraLiikkuva(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, 20, 20);
    }
}
