package virpi.virpigame.objects;

public class Kartta {

    private Liikkuva[][] pelialue;
    private Kissa virpi;

    // Luodaan ruudukko, joko oletusarvoilla 5x30 tai erikseen annetuilla mitoilla. Parametrina mahdolliset mitat.
    public Kartta() {
        pelialue = new Liikkuva[5][30];
    }

    public Kartta(int korkeus, int leveys) {
        pelialue = new Liikkuva[korkeus][leveys];
    }

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

    // Pelihahmon aloitusruuduksi ruudukon keskimmäinen "kaista"
    public int haeAloitusRuutu() {
        return pelialue.length / 2;
    }

    // Tulostetaan pelialue, tyhjiin ruutuihin _ 
    // Liikkuvien ruutuihin toStringin ensimmäinen merkki
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

    // Kaikissa liikuttelukomennoissa tarkistetaan ensin, ettei olla menossa ulos pelialueelta - jos ollaan, ei liikuta ollenkaan,
    // sitten poistetaan asia "ruudukosta", päivitetään sen koordinaatit ja lisätään se uuteen sijaintiin
    public void liikutaYlos(Liikkuva asia) {
        if (asia.getY() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuYlos();
            this.lisaaLiikkuva(asia);
        }
    }

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

    public boolean mahtuukoRuudukkoon(Liikkuva asia) {
        int x = asia.getX();
        int y = asia.getY();
        if (x < pelialue[0].length && x >= 0 && y < pelialue.length && y >= 0) {
            return true;
        } else {
            return false;
        }
    }

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

}
