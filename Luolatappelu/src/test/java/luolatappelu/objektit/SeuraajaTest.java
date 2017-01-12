/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.objektit;

import luolatappelu.objektit.Seuraaja;
import luolatappelu.objektit.Pelaaja;
import java.util.Random;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class SeuraajaTest {

    private Seuraaja seuraaja;
    private Pelaaja pelaaja;
    private Peli peli;

    public SeuraajaTest() {
        this.peli = new Peli(new Kayttoliittyma());
        this.pelaaja = new Pelaaja(peli);
        this.seuraaja = new Seuraaja(pelaaja);
        pelaaja.setX(10);
        pelaaja.setY(10);
    }

    @Test
    public void seuraajaJaPelaajaXAkselilla() {
        seuraaja.setX(10);
        for (int i = 0; i < 100; i++) {
            seuraaja.setY(0);
            seuraaja.liiku();
            seuraaja.liiku();
            assertEquals(seuraaja.getY(), 2);
        }
    }

    @Test
    public void seuraajaJaPelaajaYAkselilla() {
        seuraaja.setY(10);
        for (int i = 0; i < 100; i++) {
            seuraaja.setX(0);
            seuraaja.liiku();
            seuraaja.liiku();
            assertEquals(seuraaja.getX(), 2);
        }
    }

    @Test
    public void seuraajanLiikkuminenKunPelaajaEiSamallaAkselilla() {
        pelaaja.setX(0);
        pelaaja.setY(0);
        for (int i = 0; i < 100; i++) {
            seuraaja.setX(1);
            seuraaja.setY(1);
            seuraaja.liiku();
            assertTrue(seuraaja.getX() == 0 || seuraaja.getY() == 0);
        }
    }
}
