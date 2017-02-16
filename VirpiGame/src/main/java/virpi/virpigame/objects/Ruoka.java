package virpi.virpigame.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Ruoka implements Liikkuva {

    private String nimi;
    private int pisteet;
    private int x;
    private int y;

    public Ruoka(String name, int pisteet, int x, int y) {
        this.nimi = name;
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
    public int getPisteet() {
        return this.pisteet;
    }

    @Override
    public void muutaPisteita(int muutos) {
        pisteet += muutos;
        if (pisteet < 0) {
            pisteet = 0;
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
    public String toString() {
        return this.nimi;
    }

    @Override
    public void piirraLiikkuva(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x * 20, y * 20, 20, 20);
    }

}
