package luolatappelu.hahmot;

import luolatappelu.objektit.Pelaaja;
import luolatappelu.Suunta;
import luolatappelu.peli.Peli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Pelaaja pelaaja;
    private Peli peli;

    public PelaajaTest() {
        this.peli = new Peli();
        this.pelaaja = new Pelaaja("testi", peli);
    }

    @Test
    public void konstruktoriToimii() {
        assertEquals(pelaaja.getNimi(), "testi");
        assertEquals(pelaaja.getElamat(), 10);
        assertEquals(pelaaja.toString(), "@");
    }

    @Test
    public void pelaajaLyoKunEdessaOnVihollinen() {
        peli.uusiTaso();
        peli.getOliokanta().uusiOrkki();
        peli.getOliokanta().getOrkit().get(0).setX(1);
        peli.getOliokanta().getOrkit().get(0).setY(1);
        pelaaja.setX(1);
        pelaaja.setY(0);
        pelaaja.toimi(Suunta.ALAS);
        assertEquals(pelaaja.getY(), 0);
    }
}
