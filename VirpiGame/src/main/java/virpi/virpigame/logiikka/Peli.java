package virpi.virpigame.logiikka;

import java.util.ArrayList;
import virpi.virpigame.objects.*;

public class Peli {

    private int x;
    private int y;
    private Kartta kartta;
    private int pisteet;
    private int elamat;
    private int laskuri;
    private Pelitila tila;
    private Kissa pelihahmo;

    /**
     * Konstruktorissa asetetaan pelialueen mitat. Hieman isompi x-akseli kuin
     * peliruudussa, jotta objektit rullailevat ruudulle kivasti oikeasta laidasta.
     *
     */
    public Peli() {
        this.x = 1220;
        this.y = 10;
    }

    /**
     * Pelin aloituskomento luo uuden Kartta-olion konstruktorissa annetuilla
     * mitoilla. Pisteet, elämät, laskuri ja pelitila asetetaan alkuarvoihinsa.
     * Luodaan pelihahmoksi Kissa-olio ja asetetaan se karttaan.
     */
    public void aloita() {
        kartta = new Kartta(x, y);
        pisteet = 0;
        elamat = 5;
        laskuri = 0;
        tila = Pelitila.ALKURUUTU;
        pelihahmo = new Kissa(0, 5);
        kartta.lisaaPelihahmo(pelihahmo);
    }

    /**
     * Päivitetään pelin tilaa. Laskuri juoksee ja tietyillä laskurin arvoilla
     * lisätään ruokia ja koiria kentälle. Mikäli elämät loppuvat, pelitilaksi LOPPURUUTU.
     */
    public void paivitaTila() {
        laskuri++;
        if (laskuri == 45 || laskuri == 135) {
            kartta.lisaaKoira();
        } else if (laskuri == 90 || laskuri == 180) {
            kartta.lisaaRuoka();
        }
        if (laskuri == 180) {
            laskuri = 0;
        }
        kartta.paivitaKartta();
        osuukoLiikkuvaan();
        if (elamat == 0) {
            tila = Pelitila.LOPPURUUTU;
        }
    }

    public void osuukoLiikkuvaan() {
        if (!kartta.getLiikkuvat().isEmpty()){
            
        
        int osuma = -1;
        for (int i = 0; i < kartta.getLiikkuvat().size(); i++) {
            Liikkuva vertailtava = kartta.getLiikkuvat().get(i);
            if (vertailtava.getY() == pelihahmo.getY() && (vertailtava.getX() - 30) <= pelihahmo.getX() && (vertailtava.getX() + 30) >= pelihahmo.getX()) {
                osuma = i;
            }
        }
        if (osuma > -1) {
            if (kartta.getLiikkuvat().get(osuma).toString().equals("koira")) {
                elamat--;
            } else if (kartta.getLiikkuvat().get(osuma).toString().equals("ruoka")) {
                pisteet += 100;
            }
            kartta.getLiikkuvat().remove(osuma);
        }
        }
    }

    /**
     * Hahmo liikkuu.
     */
    public void liikutaYlos() {
        kartta.liikutaHahmoaYlos();
    }

    /**
     * Hahmo liikkuu.
     */
    public void liikutaAlas() {
        kartta.liikutaHahmoaAlas();
    }

    /**
     * Hahmo liikkuu sivusuunnassa 40 askelta kerrallaan, jotta liike olisi
     * samansuuruinen pystysuunnan kanssa.
     */
    public void liikutaVasemmalle() {
        for (int i = 0; i < 20; i++) {
            kartta.liikutaHahmoaVasemmalle();
        }
    }

    /**
     * Hahmo liikkuu.
     */
    public void liikutaOikealle() {
        for (int i = 0; i < 20; i++) {
            kartta.liikutaHahmoaOikealle();
        }
    }

    public Kartta getKartta() {
        return kartta;
    }

    public Liikkuva getPelihahmo() {
        return pelihahmo;
    }

    public ArrayList<Liikkuva> getLiikkuvat() {
        return kartta.getLiikkuvat();
    }

    public int getPisteet() {
        return pisteet;
    }
    
    public void setElamat(int e) {
        elamat = e;
    }

    public int getElamat() {
        return elamat;
    }
    
    public void setLaskuri(int l) {
        laskuri = l;
    }
    
    public int getLaskuri() {
        return laskuri;
    }

    public Pelitila getTila() {
        return this.tila;
    }

    public void setTila(Pelitila tila) {
        this.tila = tila;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
