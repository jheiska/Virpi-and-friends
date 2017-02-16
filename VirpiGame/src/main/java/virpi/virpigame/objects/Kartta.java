package virpi.virpigame.objects;

import java.awt.Graphics;

public class Kartta {

    private Liikkuva[][] pelialue;
    private Kissa virpi;

    public Kartta() {
        pelialue = new Liikkuva[5][30];
    }

    /**
     * Luodaan ruudukko, joko oletusarvoilla 5x30 tai erikseen annetuilla
     * mitoilla. Parametrina siis mahdolliset mitat.
     *
     * @param korkeus
     * @param leveys
     */
    public Kartta(int korkeus, int leveys) {
        pelialue = new Liikkuva[korkeus][leveys];
    }

    /**
     * Luodaan pelaajan hahmo kartalle ja asetetaan sille koordinaatit
     *
     * @param nimi
     */
    public void lisaaPelihahmo(String nimi) {
        this.virpi = new Kissa(nimi, 0, this.haeAloitusRuutu());
        this.lisaaLiikkuva(virpi);
    }

    public Kissa palautaPelihahmo() {
        return this.virpi;
    }

    public Liikkuva[][] palautaKartta() {
        return this.pelialue;
    }

    /**
     * Pelihahmon aloitusruuduksi ruudukon keskimmäinen "kaista"
     *
     * @return
     */
    public int haeAloitusRuutu() {
        return pelialue.length / 2;
    }

    /**
     * Tulostetaan pelialue, tyhjiin ruutuihin _ Liikkuvien ruutuihin toStringin
     * ensimmäinen merkki. Lähinnä testailua varten tekstiversiona
     */
    public void tulostaKartta() {
        for (Liikkuva[] liikkuvat : pelialue) {
            for (Liikkuva liikkuva : liikkuvat) {
                if (liikkuva == null) {
                    System.out.print("_");
                } else {
                    System.out.print(liikkuva.toString().charAt(0));
                }
            }
            System.out.print("\n");
        }
    }

    /**
     *
     * @param g
     */
    public void piirraOliot(Graphics g) {
        for (Liikkuva[] liikkuvat : pelialue) {
            for (Liikkuva liikkuva : liikkuvat) {
                if (liikkuva != null) {
                    liikkuva.piirraLiikkuva(g);
                }

            }

        }
    }

    /**
     * Lisätään ruudukkoon jokin olio, tarkistetaan että sen koordinaatit
     * sopivat kartalle. Kommenteissa lisää
     *
     * @param asia on ruudukkoon lisättävä olio
     */
    public void lisaaLiikkuva(Liikkuva asia) {
        int x = asia.getX();
        int y = asia.getY();

        if (this.mahtuukoRuudukkoon(asia)) {
            // jos ruutuun ollaan laittamassa virpiä ja ruudussa on jo jokin asia, virpin pisteet muuttuvat
            if (asia.equals(virpi) && pelialue[y][x] != null) {
                virpi.muutaPisteita(pelialue[y][x].getPisteet());
            }
            pelialue[y][x] = asia;
        }
    }

    /**
     * Kaikissa liikuttelukomennoissa tarkistetaan ensin, ettei olla menossa
     * ulos pelialueelta - jos ollaan, ei liikuta ollenkaan, sitten poistetaan
     * asia "ruudukosta", päivitetään sen koordinaatit ja lisätään se uuteen
     * sijaintiin
     *
     * @param asia
     */
    public void liikutaYlos(Liikkuva asia) {
        if (asia.getY() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuYlos();
            this.lisaaLiikkuva(asia);
        }
    }

    /**
     *
     * Pelihahmolle on omat liikuttelukomennot helpottamaan asioita.
     */
    public void liikutaHahmoaYlos() {
        this.liikutaYlos(virpi);
    }

    public void liikutaAlas(Liikkuva asia) {
        if (asia.getY() + 1 < pelialue.length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuAlas();
            this.lisaaLiikkuva(asia);
        }
    }

    public void liikutaHahmoaAlas() {
        this.liikutaAlas(virpi);
    }

    public void liikutaOikealle(Liikkuva asia) {
        if (asia.getX() + 1 < pelialue[0].length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuOikealle();
            this.lisaaLiikkuva(asia);
        }
    }

    public void liikutaHahmoaOikealle() {
        this.liikutaOikealle(virpi);
    }

    public void liikutaVasemmalle(Liikkuva asia) {
        if (asia.getX() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuVasemmalle();
            this.lisaaLiikkuva(asia);
        }
    }

    public void liikutaHahmoaVasemmalle() {
        this.liikutaVasemmalle(virpi);
    }

    /**
     * Testataan mahtuvatko parametrina annetun liikkuvan koordinaatit karttaan
     *
     * @param asia
     * @return
     */
    public boolean mahtuukoRuudukkoon(Liikkuva asia) {
        int x = asia.getX();
        int y = asia.getY();
        if (x < pelialue[0].length && x >= 0 && y < pelialue.length && y >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Kaikkia kartalla olevia olioita siirretään pykälä vasemmalle.
     * Kommenteissa tarkennuksia
     */
    public void paivitaKartta() {
        // poistetaan ensin pelihahmo kartalta
        pelialue[virpi.getY()][virpi.getX()] = null;
        // liikutetaan kaikkia kartalla olevia asioita pykälä vasemmalle
        for (Liikkuva[] liikkuvat : pelialue) {
            for (Liikkuva liikkuva : liikkuvat) {
                if (liikkuva != null) {
                    this.liikutaVasemmalle(liikkuva);
                }
            }
        }
        // lopuksi hahmo takaisin kartalle
        this.lisaaLiikkuva(virpi);
    }

    public int virpinPisteet() {
        return virpi.getPisteet();
    }

    public Liikkuva virpi() {
        return this.virpi;
    }

}
