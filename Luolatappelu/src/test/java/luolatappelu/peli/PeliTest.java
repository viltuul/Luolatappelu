/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import luolatappelu.hahmot.Orkki;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class PeliTest {

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinLuominen() {
        Peli peli = new Peli();
        Huone huone = peli.getHuone();
        assertEquals(huone.getKorkeus(), 5);
        assertEquals(huone.getLeveys(), 10);
        assertEquals(peli.getOrkit().toString(), "[]");
        assertEquals(peli.getPelaaja().getNimi(), "Pelaaja");
    }

    @Test
    public void pelajanSijoitusToimii() {
        Peli peli = new Peli();
        peli.sijoitaPelaaja();
        assertEquals(peli.getPelaaja().getX(), 5);
        assertEquals(peli.getPelaaja().getY(), 4);
    }

    @Test
    public void orkkienLisaaminenJaSijoitus() {
        Peli peli = new Peli();
        for (int i = 0; i < 5; i++) {
            peli.uusiOrkki();
        }
        assertEquals(peli.getOrkit().size(), 5);
        peli.sijoitaViholliset();
        for (int j = 0; j < 1000; j++) {
            for (Orkki orkki : peli.getOrkit()) {
                assertFalse(orkki.getX() > peli.getHuone().getLeveys());
                assertFalse(orkki.getX() < 0);
                assertFalse(orkki.getY() > peli.getHuone().getKorkeus());
                assertFalse(orkki.getY() < 0);
            }
        }

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
