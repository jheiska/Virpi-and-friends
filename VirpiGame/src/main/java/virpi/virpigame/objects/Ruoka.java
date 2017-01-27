package virpi.virpigame.objects;

public class Ruoka implements Liikkuva {

    private String nimi;
    private int x;
    private int y;

    public Ruoka(String name, int x, int y) {
        this.nimi = name;
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
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return this.nimi;
    }

}
