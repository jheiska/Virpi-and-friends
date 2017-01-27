
package virpi.virpigame.objects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KarttaTest {
    
    Kartta kartta;
    
    public KarttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kartta = new Kartta();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriLuoOikeanKokoisenOletusKartan(){
        assertEquals(5,  kartta.palautaKartta().length);
        assertEquals(30, kartta.palautaKartta()[0].length, 30);
    }
    
    @Test
    public void customKonstruktoriLuoOikeanKokoisenOletusKartan(){
        kartta = new Kartta(10, 50);
        assertEquals(10,  kartta.palautaKartta().length);
        assertEquals(50, kartta.palautaKartta()[0].length, 30);
    }
    
    @Test
    public void oikeaAloitusRuutu() {
        assertEquals(2, kartta.haeAloitusRuutu());
    }
    
    
    
    
    
    
}
