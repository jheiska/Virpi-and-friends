package virpi.virpigame;

import virpi.virpigame.objects.*;

public class Peli {

    private Kartta kartta;

    public Peli() {
        kartta = new Kartta();
    }

    public void aloita(String kissanNimi) {
        this.lisaaRuokia();
        this.lisaaKoiria();
        kartta.lisaaPelihahmo(kissanNimi);
    }

    public Kartta getKartta() {
        return kartta;
    }

    public int getPisteet() {
        return kartta.virpinPisteet();
    }

    public void lisaaRuokia() {
        Ruoka ruoka1 = new Ruoka("Latz", 100, 3, 3);
        Ruoka ruoka2 = new Ruoka("Whiskas", 300, 15, 2);
        Ruoka ruoka3 = new Ruoka("Royal Canin", 500, 22, 0);
        kartta.lisaaLiikkuva(ruoka1);
        kartta.lisaaLiikkuva(ruoka2);
        kartta.lisaaLiikkuva(ruoka3);
    }
    
    public void lisaaKoiria() {
        Koira k1 = new Koira(-200, 20, 4);
        Koira k2 = new Koira(-200, 10, 0);
        Koira k3 = new Koira(-200, 15, 2);
        Koira k4 = new Koira(-200, 25, 1);
        kartta.lisaaLiikkuva(k1);
        kartta.lisaaLiikkuva(k2);
        kartta.lisaaLiikkuva(k3);
        kartta.lisaaLiikkuva(k4);
    }

}
