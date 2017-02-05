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
        Kartta kartta = new Kartta();
        System.out.println("Tervetuloa kissapeliin Virpi and friends!");
        System.out.print("Anna kissalle nimi, eka kirjain on hahmosi kartalla:");        
        kartta.lisaaPelihahmo(lukija.nextLine());
        
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
                kartta.liikutaHahmoaYlos();
            } else if (komento.equals("a") || komento.equals("alas")) {
                kartta.liikutaHahmoaAlas();
            } else if (komento.equals("o") || komento.equals("oikea")) {
                kartta.liikutaHahmoaOikealle();
            } else if (komento.equals("v") || komento.equals("vasen")) {
                kartta.liikutaHahmoaVasemmalle();
            } else {
                System.out.println("Virheellinen komento, anna ylös, y,  alas, a, oikea, o, vasen, v tai lopeta.");
            }
            System.out.println("");
        }
    }

}
