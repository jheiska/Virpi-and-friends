package virpi.virpigame.ui;

import java.util.Scanner;
import virpi.virpigame.Peli;

public class TextUI {

    private Scanner lukija;

    public TextUI() {
        lukija = new Scanner(System.in);
    }

    public void start() {
        Peli peli = new Peli();
                
        System.out.println("Tervetuloa kissapeliin Virpi and friends!");        
        System.out.println("Kartalla K-kirjaimet ovat koiria, varo niitä!");
        System.out.println("Muut kirjaimet ovat ruokia, hahmosi on @");
        System.out.print("Anna kissalle nimi (tyhjällä Virpi): ");        
        String nimi = lukija.nextLine();
        if (nimi.equals("")){
            peli.aloita("Virpi");
        } else {
            peli.aloita(nimi);
        }        

        //ensimmäiset liikkumiset - pelihahmon liikuttelua ylös ja alas, oikealle ja vasemmalle
        while (true) {
            System.out.println("Sinulla on " + peli.getPisteet() + " pistettä");
            peli.getKartta().tulostaKartta();
            System.out.println("Liiku ylös, alas, oikea tai vasen (y/a/o/v)");
            System.out.print("Tyhjällä tai virheellisillä komennoilla pysyt paikallasi, lopeta lopettaa pelin:");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            } else if (komento.equals("y") || komento.equals("ylös")) {
                peli.getKartta().liikutaHahmoaYlos();
            } else if (komento.equals("a") || komento.equals("alas")) {
                peli.getKartta().liikutaHahmoaAlas();
            } else if (komento.equals("o") || komento.equals("oikea")) {
                peli.getKartta().liikutaHahmoaOikealle();
            } else if (komento.equals("v") || komento.equals("vasen")) {
                peli.getKartta().liikutaHahmoaVasemmalle();
            } 
            System.out.println("");
            
            // kartta päivittyy joka komennon päätteeksi
            peli.getKartta().paivitaKartta();
        }
    }

}
