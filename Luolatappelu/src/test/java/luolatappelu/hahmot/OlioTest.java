/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

import luolatappelu.hahmot.Olio;
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
public class OlioTest {

    public OlioTest() {
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
    public void olionLuonninJalkeenKaikkiOikein() {
        Olio olio = new Olio("testi");
        assertEquals(olio.getElamat(), 1);
        assertEquals(olio.getNimi(), "testi");
        assertTrue(olio.isElossa());
    }

    @Test
    public void kuoleekoOlioKunElamatLoppuvat() {
        Olio olio = new Olio("testi");
        olio.setElamat(0);
        assertFalse(olio.isElossa());
    }

    @Test
    public void olioOnElossaKunLuodaan() {
        Olio olio = new Olio("testi");
        assertTrue(olio.isElossa());
    }

    @Test
    public void olionGetteritJaSetteritToimii() {
        Olio olio = new Olio("testi");
        olio.setX(0);
        olio.setY(0);
        assertEquals(olio.getX(), 0);
        assertEquals(olio.getY(), 0);
    }

    @Test
    public void olioLyoToistaNiinElamatVahenee() {
        Olio olio1 = new Olio("testi1");
        Olio olio2 = new Olio("testi2");
        olio1.lyo(olio2);
        assertTrue(olio1.getElamat() > olio2.getElamat());
    }

    @Test
    public void olioJaaHenkiinJosLyonninJalkeenOnElamia() {
        Olio olio1 = new Olio("testi1");
        Olio olio2 = new Olio("testi2");
        olio2.setElamat(2);
        olio1.lyo(olio2);
        assertTrue(olio2.isElossa());
    }

}
