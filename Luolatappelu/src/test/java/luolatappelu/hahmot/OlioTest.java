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

    private Olio olio1;
    private Olio olio2;

    public OlioTest() {
        this.olio1 = new Olio("testi1");
        this.olio2 = new Olio("testi2");
    }

    @Test
    public void olionLuonninJalkeenKaikkiOikein() {
        assertEquals(olio1.getElamat(), 1);
        assertEquals(olio1.getNimi(), "testi1");
        assertTrue(olio1.isElossa());
    }

    @Test
    public void kuoleekoOlioKunElamatLoppuvat() {
        olio1.setElamat(0);
        assertFalse(olio1.isElossa());
    }

    @Test
    public void olioOnElossaKunLuodaan() {
        assertTrue(olio1.isElossa());
    }

    @Test
    public void olionGetteritJaSetteritToimii() {
        olio1.setX(0);
        olio1.setY(0);
        assertEquals(olio1.getX(), 0);
        assertEquals(olio1.getY(), 0);
    }

    @Test
    public void olioLyoToistaNiinElamatVahenee() {
        olio1.lyo(olio2);
        assertTrue(olio1.getElamat() > olio2.getElamat());
    }

    @Test
    public void olioJaaHenkiinJosLyonninJalkeenOnElamia() {
        olio2.setElamat(2);
        olio1.lyo(olio2);
        assertTrue(olio2.isElossa());
    }

}
