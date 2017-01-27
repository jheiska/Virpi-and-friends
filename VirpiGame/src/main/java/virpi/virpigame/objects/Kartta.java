package virpi.virpigame.objects;

import virpi.virpigame.objects.*;

public class Kartta {

    private Object[][] pelialue;

    // Luodaan ruudukko, joko oletusarvoilla 5x30 tai erikseen annetuilla mitoilla
    public Kartta() {
        pelialue = new Object[5][30];
    }

    public Kartta(int korkeus, int leveys) {
        pelialue = new Object[korkeus][leveys];
    }
    
    public Object[][] palautaKartta() {
        return this.pelialue;
    }

    // Pelihahmon aloitusruuduksi ruudukon keskimmäinen "kaista"
    public int haeAloitusRuutu() {
        return pelialue.length / 2;
    }

    // Tulostetaan pelialue, tyhjiin ruutuihin _ 
    // Objectien ruutuihin toStringin ensimmäinen merkki
    public void tulostaKartta() {
        for (Object[] objects : pelialue) {
            for (Object object : objects) {
                if (object == null) {
                    System.out.print("_");
                } else {
                    System.out.print(object.toString().charAt(0));
                }
            }
            System.out.println("");

        }
    }

    public void lisaaKissa(Object kissa) {
        pelialue[this.haeAloitusRuutu()][0] = kissa;
    }

    public void lisaaLiikkuva(Liikkuva asia) {
        if (this.mahtuukoRuudukkoon(asia)) {
            pelialue[asia.getY()][asia.getX()] = asia;
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

    public void liikutaAlas(Liikkuva asia) {
        if (asia.getY() + 1 < pelialue.length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuAlas();
            this.lisaaLiikkuva(asia);
        }
    }

    public void liikutaOikealle(Liikkuva asia) {
        if (asia.getX() + 1 < pelialue[0].length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuOikealle();
            this.lisaaLiikkuva(asia);
        }
    }

    public void liikutaVasemmalle(Liikkuva asia) {
        if (asia.getX() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuVasemmalle();
            this.lisaaLiikkuva(asia);
        }
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
    
    
}
