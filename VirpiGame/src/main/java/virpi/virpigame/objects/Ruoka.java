package virpi.virpigame.objects;

public class Ruoka extends Liikkuva {

    private String nimi;
    
    /**
     * Luodaan sapuskaa kissan syötäväksi.
     *
     * @param x -koordinaatti.
     * @param y -koordinaatti.
     */
    public Ruoka(String nimi, int x, int y) {
        super(x, y);
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    @Override
    public String toString() {
        return "ruoka";
    }

}
