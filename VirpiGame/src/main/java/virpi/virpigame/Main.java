package virpi.virpigame;

import javax.swing.SwingUtilities;
import virpi.virpigame.ui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {

        Kayttoliittyma kayttis = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttis);     

    }

}
