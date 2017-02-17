package virpi.virpigame.objects;

import java.awt.Graphics;

/**
 * Kaikilla liikkuvilla olioilla on metodit joilla liikutellaan niitä eri
 * suuntiin, sekä pisteiden hallintaan ja piirtelyyn.
 */
public interface Liikkuva {

    /**
     * Liikutetaan Liikkuvaa ylös, eli pienennetään sen y-koordinaattia koska
     * pystysuuntaan koordinaatit ovat "väärinpäin". Varotaan ettei mene
     * negatiiviseksi.
     */
    void liikuYlos();

    /**
     * Liikutetaan Liikkuvaa alas eli kasvatetaan sen y-koordinaattia.
     */
    void liikuAlas();

    /**
     * Liikutetaan Liikkuvaa oikealle, eli kasvatetaan sen x-koordinaattia.
     */
    void liikuOikealle();

    /**
     * Liikutetaan Liikkuvaa vasemmalle, eli pienennetään sen x-koordinaattia.
     * Varotaan ettei mene negatiiviseksi.
     */
    void liikuVasemmalle();

    /**
     * Sijainti.
     *
     * @return x-koordinaatti
     */
    int getX();

    /**
     * Sijainti.
     *
     * @return y-koordinaatti
     */
    int getY();

    /**
     * Kaikilla Liikkuvilla on pistemäärä.
     *
     * @return pisteet
     */
    int getPisteet();

    /**
     * Pistemäärää on pystyttävä myös muuttamaan.
     *
     * @param muutos paljonko pisteet muuttuvat.
     */
    void muutaPisteita(int muutos);

    /**
     * Piirretään Liikkuva näytölle.
     *
     * @param g grafiikkaparametri
     */
    void piirraLiikkuva(Graphics g);
}
