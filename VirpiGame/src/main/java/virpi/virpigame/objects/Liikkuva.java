package virpi.virpigame.objects;

public interface Liikkuva {

    void liikuYlos();

    void liikuAlas();

    void liikuOikealle();

    void liikuVasemmalle();

    int getX();

    int getY();
    
    int getPisteet();
    
    void muutaPisteita(int muutos);
}
