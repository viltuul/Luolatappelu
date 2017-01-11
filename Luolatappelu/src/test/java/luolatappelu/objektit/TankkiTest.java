package luolatappelu.objektit;

import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;
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
public class TankkiTest {

    private Tankki tankki;
    private Pelaaja pelaaja;

    public TankkiTest() {
        this.tankki = new Tankki();
        tankki.setX(4);
        tankki.setY(4);
        this.pelaaja = new Pelaaja("testi", new Peli(new Kayttoliittyma()));
    }

    @Test
    public void konstruktoriTest() {
        assertEquals("T", tankki.toString());
        assertEquals(0.8, tankki.getOsumatarkkuus(), 0.01);
        assertEquals(3, tankki.getElamat());
    }

    @Test
    public void liikkuminenTest() {
        tankki.liiku();
        int x = tankki.getX();
        int y = tankki.getY();
        tankki.liiku();
        assertEquals(x, tankki.getX());
        assertEquals(y, tankki.getY());
    }

    @Test
    public void lyominenTest() {
        pelaaja.setX(4);
        pelaaja.setY(3);
        int elamat = pelaaja.getElamat();
        tankki.setOsumatarkkuus(1.0);
        tankki.lyo(pelaaja);
        tankki.lyo(pelaaja);
        assertEquals(elamat - 1, pelaaja.getElamat());
    }

}
