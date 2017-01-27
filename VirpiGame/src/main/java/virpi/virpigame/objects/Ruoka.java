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
        this.y--;
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
        this.x--;
    }

    public String getName() {
        return nimi;
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
        return this.nimi + " on sijainnissa (" + this.x + "," + this.y + ")";
    }

}
