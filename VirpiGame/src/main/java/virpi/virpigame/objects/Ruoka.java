package virpi.virpigame.objects;

public class Ruoka implements Liikkuva {

    private String nimi;
    private int x;
    private int y;
    private int points;

    public Ruoka(String name, int x, int y, int points) {
        this.nimi = name;
        this.x = x;
        this.y = y;
        this.points = points;
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

    public int getPoints() {
        return points;
    }

    public String toString() {
        return "R";
    }

}
