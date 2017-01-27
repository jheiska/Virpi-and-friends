package virpi.virpigame.ui;

import virpi.virpigame.objects.Kartta;
import java.util.Scanner;
import virpi.virpigame.objects.Kissa;
import virpi.virpigame.objects.Ruoka;

public class TextUI {

    private Scanner lukija;

    public TextUI() {
        lukija = new Scanner(System.in);
    }

    public void start() {
        Kartta kartta = new Kartta(5, 30);

        System.out.println("Tervetuloa kissapeliin Virpi and friends!");
        System.out.print("Anna kissalle nimi: ");
        Kissa virpi = new Kissa(lukija.nextLine(), 0, kartta.haeAloitusRuutu());
        kartta.lisaaLiikkuva(virpi);
        Ruoka ruoka1 = new Ruoka("Latz", 3, 3);
        Ruoka ruoka2 = new Ruoka("Whiskas", 15, 2);
        kartta.lisaaLiikkuva(ruoka1);
        kartta.lisaaLiikkuva(ruoka2);

        //ensimmäiset liikkumiset - pelihahmon liikuttelua ylös ja alas, oikealle ja vasemmalle
        while (true) {
            kartta.tulostaKartta();
            System.out.print("Liiku ylös, alas, oikea tai vasen (y/a/o/v) tai lopeta: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            } else if (komento.equals("y") || komento.equals("ylös")) {
                kartta.liikutaYlos(virpi);
            } else if (komento.equals("a") || komento.equals("alas")) {
                kartta.liikutaAlas(virpi);
            } else if (komento.equals("o") || komento.equals("oikea")) {
                kartta.liikutaOikealle(virpi);
            } else if (komento.equals("v") || komento.equals("vasen")) {
                kartta.liikutaVasemmalle(virpi);
            } else {
                System.out.println("Virheellinen komento, anna ylös, y,  alas, a, oikea, o, vasen, v tai lopeta.");
            }
            System.out.println("");
        }
    }

}
