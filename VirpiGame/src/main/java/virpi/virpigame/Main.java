package virpi.virpigame;

import virpi.virpigame.ui.Kayttoliittyma;
import virpi.virpigame.ui.TextUI;

public class Main {

    public static void main(String[] args) {
        //TextUI kayttoliittyma = new TextUI();
        //kayttoliittyma.start();

        Kayttoliittyma kayttis = new Kayttoliittyma();
        kayttis.run();

    }

}
