package virpi.virpigame.ui;

import virpi.virpigame.objects.Kissa;
import virpi.virpigame.objects.Liikkuva;

public class Kartta {

    private Object[][] pelialue;

    public Kartta() {
        pelialue = new Object[5][20];
    }

    public Kartta(int korkeus, int leveys) {
        pelialue = new Object[korkeus][leveys];
    }

    public int haeAloitusRuutu() {
        return pelialue.length / 2;
    }

    public void tulostaKartta() {
        for (Object[] objects : pelialue) {
            for (Object object : objects) {
                if (object == null) {
                    System.out.print("_");
                } else {
                    System.out.print(object.toString());
                }
            }
            System.out.println("");

        }
    }

    public void lisaaKissa(Object kissa) {
        pelialue[this.haeAloitusRuutu()][0] = kissa;
        System.out.println(pelialue.length);
    }
    
    public void lisaaLiikkuva(Liikkuva asia, int x, int y){
        pelialue[y][x] = asia;
    }

    public void liikutaYlos(Liikkuva asia) {
        if (asia.getY() > 0) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuYlos();
            this.lisaaLiikkuva(asia, asia.getX(), asia.getY());
        }
    }

    public void liikutaAlas(Liikkuva asia) {
        if (asia.getY() + 1  < pelialue.length) {
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuAlas();
            this.lisaaLiikkuva(asia, asia.getX(), asia.getY());
        }
    }
    
    public void liikutaOikealle(Liikkuva asia){
        if (asia.getX() + 1 < pelialue[0].length){
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuOikealle();
            this.lisaaLiikkuva(asia, asia.getX(), asia.getY());
        }
    }
    
    public void liikutaVasemmalle(Liikkuva asia){
        if (asia.getX() == 0){
            pelialue[asia.getY()][asia.getX()] = null;
        }
        if (asia.getX() > 0){
            pelialue[asia.getY()][asia.getX()] = null;
            asia.liikuVasemmalle();
            this.lisaaLiikkuva(asia, asia.getX(), asia.getY());
        }
    }

    
}
