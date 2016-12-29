/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

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
public class PaahahmoTest {

    public PaahahmoTest() {
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
    public void luodaanPaahahmo() {
        Pelaaja pelaaja = new Pelaaja("testi");
        assertEquals(pelaaja.getNimi(), "testi");
        assertEquals(pelaaja.getElamat(), 10);
    }

    @Test
    public void liikuMetodiToimiiEka() {
        Pelaaja pelaaja = new Pelaaja("testi");
        pelaaja.liiku(Suunta.OIKEA);
        assertEquals(pelaaja.getX(), 1);
        pelaaja.liiku(Suunta.VASEN);
        assertEquals(pelaaja.getX(), 0);
        assertEquals(pelaaja.getY(), 0);
    }

    @Test
    public void liikuMetodiToimiiToka() {
        Pelaaja pelaaja = new Pelaaja("testi");
        pelaaja.liiku(Suunta.ALAS);
        pelaaja.liiku(Suunta.ALAS);
        pelaaja.liiku(Suunta.ALAS);
        pelaaja.liiku(Suunta.OIKEA);
        assertEquals(pelaaja.getY(), 3);
        assertEquals(pelaaja.getX(), 1);
        pelaaja.liiku(Suunta.YLOS);
        pelaaja.liiku(Suunta.YLOS);
        pelaaja.liiku(Suunta.YLOS);
        pelaaja.liiku(Suunta.YLOS);
        assertEquals(pelaaja.getY(), -1);
        assertEquals(pelaaja.getX(), 1);
    }

    @Test
    public void toStringToimii() {
        Pelaaja pelaaja = new Pelaaja("testi");
        assertEquals(pelaaja.toString(),"@");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
