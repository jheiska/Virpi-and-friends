package virpi.virpigame.objects;

public class Kissa implements Liikkuva {

    // hahmo on aina ruudun vasemmassa laidassa, joten x final. tarvitaan kuitenkin sijainnin vertailuun
    private int x;
    private int y;
    private String nimi;

    public Kissa(String nimi, int x, int y) {
        this.x = x;
        this.y = y;
        this.nimi = nimi;
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
    public String toString() {
        return this.nimi;

    }

}
