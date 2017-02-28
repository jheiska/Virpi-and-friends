package virpi.virpigame.logiikka;

import java.util.ArrayList;
import java.util.Random;
import virpi.virpigame.objects.*;

public class Kartta {

    private Kissa virpi;
    private ArrayList<Liikkuva> liikkuvat;
    private int maxX;
    private int maxY;

    /**
     * Luodaan kartta -olio ja sinne lista liikkuvista.
     *
     * @param maxX pelialueen maksimileveys
     * @param maxY pelialueen maksimikorkeus
     */
    public Kartta(int maxX, int maxY) {
        liikkuvat = new ArrayList<Liikkuva>();
        this.maxX = maxX + 20;
        this.maxY = maxY;
    }

    /**
     * Asetetaan parametrina annettu kissa pelihahmoksi ja lisätään se kartalle.
     *
     * @param virpi pelihahmoksi Kissa-olio.
     */
    public void lisaaPelihahmo(Kissa virpi) {
        this.virpi = virpi;
    }

    /**
     * Lisätään listaan jokin olio, mikäli se ei olisi menossa pelihahmon päälle
     * eikä koordinaatiston ulkopuolelle.
     *
     * @param asia on ruudukkoon lisättävä olio
     */
    public void lisaaLiikkuva(Liikkuva asia) {
        if (asia.getX() != virpi.getX() && asia.getY() != virpi.getY()) {
            if (mahtuukoRuudukkoon(asia)) {
                liikkuvat.add(asia);
            }
        }
    }
    
    /**
     * Lisätään koira satunnaiselle kaistalle.
     */
    public void lisaaKoira(){
        Random random = new Random();
        int y = random.nextInt(maxY);
        lisaaLiikkuva(new Koira("Hauva", maxX, y));
    }
    
    /**
     * Lisätään ruoka satunnaiselle kaistalle.
     */
    public void lisaaRuoka(){
        Random random = new Random();
        int y = random.nextInt(maxY);
        lisaaLiikkuva(new Ruoka("Herkku", maxX, y));
    }
    

    /**
     * Kaikissa liikuttelukomennoissa tarkistetaan ensin, ettei olla menossa
     * ulos pelialueelta. Jos ollaan, ei liikuta ollenkaan. Ensimmäisenä
     * liikutaan ylös.
     *
     * @param asia Liikkuva-olio parametrina.
     */
    public void liikutaYlos(Liikkuva asia) {
        if (asia.getY() > 0) {
            asia.liikuYlos();
        }
    }

    /**
     * Pelihahmolle omat liikkumiskomennot. Pelihahmo liikkuu alas.
     *
     */
    public void liikutaHahmoaYlos() {
        liikutaYlos(virpi);
    }

    /**
     * Liikkuva liikkuu alas.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaAlas(Liikkuva asia) {
        if (asia.getY() < maxY) {
            asia.liikuAlas();
        }
    }

    /**
     * Pelihahmo liikkuu alas.
     *
     */
    public void liikutaHahmoaAlas() {
        liikutaAlas(virpi);
    }

    /**
     * Liikkuva liikkuu oikealle.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaOikealle(Liikkuva asia) {
        if (asia.getX() + 1 < maxX) {
            asia.liikuOikealle();
        }
    }

    /**
     * Pelihahmo liikkuu oikealle.
     *
     */
    public void liikutaHahmoaOikealle() {
        liikutaOikealle(virpi);
    }

    /**
     * Liikkuva liikkuu vasemmalle. Muut kuin pelihahmo voivat rullata ulos
     * ruudulta vasemmalle liikuttaessa.
     *
     * @param asia on Liikkuva jota liikutetaan.
     */
    public void liikutaVasemmalle(Liikkuva asia) {
        asia.liikuVasemmalle();
    }

    /**
     * Pelihahmo liikkuu vasemmalle. Tarkistetaan erikseen ettei mennä ulos.
     *
     */
    public void liikutaHahmoaVasemmalle() {
        if (virpi.getX() >= 0){
            this.liikutaVasemmalle(virpi);
        }
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
        if (x <= maxX && x >= 0 && y <= maxY && y >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Siirretään kaikkia liikkuvia pykälä vasemmalle. Poistetaan jos menee
     * vasemmalta ulos.
     */
    public void paivitaKartta() {        
        for (Liikkuva liikkuva : liikkuvat) {
            liikutaVasemmalle(liikkuva);
        }
    }

    public ArrayList<Liikkuva> getLiikkuvat() {
        return liikkuvat;
    }

    public Liikkuva getVirpi() {
        return this.virpi;
    }

}
