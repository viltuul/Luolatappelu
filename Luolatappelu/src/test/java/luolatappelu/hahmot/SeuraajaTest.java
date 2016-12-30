/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

import java.util.Random;
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
public class SeuraajaTest {

    private Seuraaja seuraaja;
    private Pelaaja pelaaja;

    public SeuraajaTest() {
        this.seuraaja = new Seuraaja();
        this.pelaaja = new Pelaaja("testaaja");
        pelaaja.setX(10);
        pelaaja.setY(10);
    }

    @Test
    public void suunnanArpominenYAkseli() {
        Random stubi = new RandomStub(0, 0, 0, 0, 0, 0);
        Seuraaja ylosTaiAlas = new Seuraaja(stubi);
        ylosTaiAlas.liiku(pelaaja);
        ylosTaiAlas.liiku(pelaaja);
        ylosTaiAlas.liiku(pelaaja);
        assertEquals(ylosTaiAlas.getY(), 3);
    }

    @Test
    public void suunnanArpominenXAkseli() {
        Random stubi = new RandomStub(1, 1, 1, 1, 1, 1);
        Seuraaja vasenTaiOikea = new Seuraaja(stubi);
        vasenTaiOikea.liiku(pelaaja);
        vasenTaiOikea.liiku(pelaaja);
        vasenTaiOikea.liiku(pelaaja);
        assertEquals(vasenTaiOikea.getX(), 3);
    }

    @Test
    public void seuraajaJaPelaajaXAkselilla() {
        seuraaja.setX(10);
        for (int i = 0; i < 100; i++) {
            seuraaja.setY(0);
            seuraaja.liiku(pelaaja);
            seuraaja.liiku(pelaaja);
            assertEquals(seuraaja.getY(), 2);
        }
    }

    @Test
    public void seuraajaJaPelaajaYAkselilla() {
        seuraaja.setY(10);
        for (int i = 0; i < 100; i++) {
            seuraaja.setX(0);
            seuraaja.liiku(pelaaja);
            seuraaja.liiku(pelaaja);
            assertEquals(seuraaja.getX(), 2);
        }
    }
}
