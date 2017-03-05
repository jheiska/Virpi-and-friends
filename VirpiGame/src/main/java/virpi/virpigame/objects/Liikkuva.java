package virpi.virpigame.objects;

public abstract class Liikkuva {

    private int x;
    private int y;

    /**
     * Luodaan Liikkuva-olio.
     *
     * @param x x-koordinaatti.
     * @param y y-koordinaatti.
     */
    public Liikkuva(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Liikutetaan Liikkuvaa ylös, eli pienennetään sen y-koordinaattia koska
     * pystysuuntaan koordinaatit ovat "väärinpäin". Varotaan ettei mene
     * negatiiviseksi.
     */
    public void liikuYlos() {
        if (this.y > 0) {
            this.y--;
        }
    }

    /**
     * Liikutetaan Liikkuvaa alas eli kasvatetaan sen y-koordinaattia.
     */
    public void liikuAlas() {
        this.y++;
    }

    /**
     * Liikutetaan Liikkuvaa oikealle, eli kasvatetaan sen x-koordinaattia.
     */
    public void liikuOikealle() {
        this.x++;
    }

    /**
     * Liikutetaan Liikkuvaa vasemmalle, eli pienennetään sen x-koordinaattia.
     */
    public void liikuVasemmalle() {
        this.x--;

    }

    /**
     * Sijainti.
     *
     * @return x-koordinaatti
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sijainti.
     *
     * @return y-koordinaatti
     */
    public int getY() {
        return this.y;
    }

}
