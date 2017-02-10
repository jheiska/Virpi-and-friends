package virpi.virpigame.objects;

import java.awt.Graphics;

/**
 * Kaikilla liikkuvilla olioilla on metodit joilla liikutellaan niitä eri
 * suuntiin, sekä pisteiden hallintaan ja piirtelyyn
 */
public interface Liikkuva {

    void liikuYlos();

    void liikuAlas();

    void liikuOikealle();

    void liikuVasemmalle();

    int getX();

    int getY();

    int getPisteet();

    void muutaPisteita(int muutos);

    void piirraLiikkuva(Graphics g);
}
