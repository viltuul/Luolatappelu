/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.objektit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ville
 */
public class OviaukkoTest {

    private Oviaukko ovi;

    public OviaukkoTest() {
        this.ovi = new Oviaukko(0, 0);
    }

    @Test
    public void getteriTesti() {
        assertEquals(0, ovi.getX());
        assertEquals(0, ovi.getY());
    }

    @Test
    public void setteriTest() {
        ovi.setX(1);
        ovi.setY(1);
        assertEquals(1, ovi.getX());
        assertEquals(1, ovi.getY());
    }
}
