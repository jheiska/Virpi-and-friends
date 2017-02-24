package virpi.virpigame.logiikka;

import java.awt.Graphics;
import virpi.virpigame.objects.Kissa;
import virpi.virpigame.objects.Liikkuva;

public class Kartta {

    private Liikkuva[][] pelialue;
    private Kissa virpi;

    /**
     * Konstruktori luo kartan oletusmitoilla 5 x 30.
     */
    public Kartta() {
        pelialue = new Liikkuva[5][30];
    }

    /**
     * Luodaan kartta annetuilla mitoilla.
     *
     * @param korkeus kartan korkeus eli y-koordinaatit
     * @param leveys kartan leveys eli x-koordinaatit
     */
    public Kartta(int korkeus, int leveys) {
        pelialue = new Liikkuva[korkeus][leveys];
    }

    /**
     * Asetetaan pelihahmo ja lisätään se kartalle.
     * @param virpi pelihahmoksi Kissa-olio.
     */
    public void lisaaPelihahmo(Kissa virpi) {
        this.virpi = virpi;
        this.lisaaLiikkuva(virpi);
    }

    /**
     * Haetaan pelihahmo.
     * @return palauttaa pelihahmona toimivan Kissa-olion.
     */
    public Kissa palautaPelihahmo() {
        return this.virpi;
    }

    /**
     * Palautetaan pelikenttä.
     * @return Liikkuvia sisältävä "array-ruudukko".
     */
    public Liikkuva[][] palautaKartta() {
        return this.pelialue;
    }

    /**
     * Pelihahmon aloitusruuduksi ruudukon keskimmäinen "kaista".
     * @return aloitusruudun y-koordinaatti.
     */
    public int haeAloitusRuutu() {
        return pelialue.length / 2;
    }

     /**
     * Piirretään kaikki kartalta löytyvät liikkuvat kutsumalla niiden piirtometodia.
     * @param g grafiikkaparametri.
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
     * sopivat kartalle. Kommenteissa tarkennusta.
     *
     * @param asia on ruudukkoon lisättävä olio
     */
    public void lisaaLiikkuva(Liikkuva asia) {
        if (this.mahtuukoRuudukkoon(asia)) {
            // jos ruutuun ollaan laittamassa virpiä ja ruudussa on jo jokin asia, virpin pisteet muuttuvat
            if (asia.equals(virpi) && pelialue[asia.getY()][asia.getX()] != null) {
                virpi.muutaPisteita(pelialue[asia.getY()][asia.getX()].getPisteet());
            }
            pelialue[asia.getY()][asia.getX()] = asia;
        }
    }

    /**
     * Kaikissa liikuttelukomennoissa tarkistetaan ensin, ettei olla menossa
     * ulos pelialueelta. Jos ollaan, ei liikuta ollenkaan. Jos liikutaan,
     * poistetaan liikkuva kartasta, päivitetään sen koordinaatit ja lisätään se
     * uuteen sijaintiin. Tässä mennään ylös.
     *
     * @param asia Liikkuva-olio parametrina.
     */
    public void liikutaYlos(Liikkuva asia) {
        if (asia.getY() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuYlos();
            this.lisaaLiikkuva(asia);
        }
    }

    /**
     *  Pelihahmo liikkuu alas ja se piirretään uusiksi.
     *
     * @param g grafiikkaparametri
     */     
    public void liikutaHahmoaYlosJaPiirra(Graphics g) {
        this.liikutaYlos(virpi);
        virpi.piirraLiikkuva(g);
    }

    /**
     * Liikkuva liikkuu alas.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaAlas(Liikkuva asia) {
        if (asia.getY() + 1 < pelialue.length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuAlas();
            this.lisaaLiikkuva(asia);
        }
    }

    /**
     * Pelihahmo liikkuu alas ja se piirretään uusiksi.
     * 
     * @param g grafiikkaparametri
     */
    public void liikutaHahmoaAlasJaPiirra(Graphics g) {
        this.liikutaAlas(virpi);
        virpi.piirraLiikkuva(g);
    }

    /**
     * Liikkuva liikkuu oikealle.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaOikealle(Liikkuva asia) {
        if (asia.getX() + 1 < pelialue[0].length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuOikealle();
            this.lisaaLiikkuva(asia);
        }
    }

    /**
     * Pelihahmo liikkuu oikealle ja se piirretään uusiksi.
     * 
     * @param g grafiikkaparametri
     */
    public void liikutaHahmoaOikealleJaPiirra(Graphics g) {
        this.liikutaOikealle(virpi);
        virpi.piirraLiikkuva(g);
    }

    /**
     * Liikkuva liikkuu vasemmalle.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaVasemmalle(Liikkuva asia) {
        pelialue[asia.getY()][asia.getX()] = null;
        if (asia.getX() > 0) {
            asia.liikuVasemmalle();
            this.lisaaLiikkuva(asia);
        }
    }

    /**
     * Pelihahmo liikkuu vasemmalle ja se piirretään uusiksi.
     * 
     * @param g grafiikkaparametri
     */
    public void liikutaHahmoaVasemmalleJaPiirra(Graphics g) {
        this.liikutaVasemmalle(virpi);
        virpi.piirraLiikkuva(g);
    }

    /**
     * Testataan mahtuvatko parametrina annetun liikkuvan koordinaatit karttaan.
     *
     * @param asia on Liikkuva jota liikutetaan.
     * @return boolean mahtuuko vai eikö mahdu
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
     * Kommentteina tarkennuksia.
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

    public Liikkuva getVirpi() {
        return this.virpi;
    }

}