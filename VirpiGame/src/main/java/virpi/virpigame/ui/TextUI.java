package virpi.virpigame.ui;

import java.util.Scanner;
import virpi.virpigame.objects.Kissa;

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
        kartta.lisaaKissa(virpi);

        while (true) {
            kartta.tulostaKartta();
            System.out.print("Liiku ylös tai alas (y/a) tai lopeta: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            } else if (komento.equals("y") || komento.equals("ylös")) {
                kartta.liikutaYlos(virpi);
            } else if (komento.equals("a") || komento.equals("alas")) {
                kartta.liikutaAlas(virpi);
            } else {
                System.out.println("Virheellinen komento, anna ylös, alas, y, a tai lopeta.");
            }
            System.out.println("");
        }
    }

}
