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
    private int taso;
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
     * mitoilla. Pisteet, elämät, laskuri, taso ja pelitila asetetaan alkuarvoihinsa.
     * Luodaan pelihahmoksi Kissa-olio ja asetetaan se karttaan.
     */
    public void aloita() {
        kartta = new Kartta(x, y);
        pisteet = 0;
        elamat = 5;
        laskuri = 0;
        taso = 1;
        tila = Pelitila.ALKURUUTU;
        pelihahmo = new Kissa(0, 5);
        kartta.lisaaPelihahmo(pelihahmo);
    }

    /**
     * Päivitetään pelin tilaa. Laskuri juoksee ja päivittäjä-luokkaa kutsumalla
     * lisätään ruokia ja koiria kentälle. Mikäli elämät loppuvat tai päästään viimeinen
     * taso läpi, pelitilaksi LOPPURUUTU.
     */
    public void paivitaTila() {
        laskuri++;
        lisaaLiikkuvia();
        kartta.paivitaKartta();
        osuukoLiikkuvaan();
        if (pisteet == (500 * taso)){
            taso++;
        }
        if (elamat == 0 || taso == 8) {
            tila = Pelitila.LOPPURUUTU;
        }
        if (laskuri == 181) {
            laskuri = 0;
        }
        
    }
    
    /**
     * Lisätään liikkuvia riippuen laskurista. Mitä isompi taso, sitä enemmän koiria.
     */
    public void lisaaLiikkuvia() {
        if (laskuri == 45 || laskuri == 135) {
            for (int i = 0; i < taso; i++) {
                kartta.lisaaKoira();
            }
        } else if (laskuri == 90 || laskuri == 180) {
            kartta.lisaaRuoka();
        }
    }

    /**
     * Mikäli jokin kartan liikkuvat-olioista on riittävän lähellä pelihahmoa, sama y-koordinaatti
     * ja x-akselilla +/- 30. Osuman löytyessä kyseisen olion indeksi liikkuvien listassa otetaan talteen. 
     * Sitten menetetään elämä mikäli liikkuva oli koira ja saadaan 100 pistettä mikäli se oli ruoka. 
     * Lopuksi poistetaan kyseinen olio listalta.
     */
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
    
    public void setTaso(int t) {
        taso = t;
    }
    
    public int getTaso() {
        return taso;
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
