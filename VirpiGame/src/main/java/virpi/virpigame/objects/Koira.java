package virpi.virpigame.objects;

public class Koira extends Liikkuva {

    private String nimi;
    
    /**     
     * Luodaan koira kissan väisteltäväksi.
     * @param x -koordinaatti.
     * @param y -koordinaatti.
     */
    public Koira(String nimi, int x, int y) {
        super(x, y);  
        this.nimi = nimi;
    }      

    public String getNimi() {
        return nimi;
    }
    
    
    @Override
    public String toString() {
        return "koira";
    }
    
    
    
 

}
