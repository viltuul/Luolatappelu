package luolatappelu.objektit;

import luolatappelu.objektit.Pelaaja;
import luolatappelu.objektit.Suunta;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    private Pelaaja pelaaja;
    private Peli peli;

    public PelaajaTest() {
        this.peli = new Peli(new Kayttoliittyma());
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

    @Test
    public void setMaksimiElamatTesti() {
        pelaaja.setMaksimiElamat(10);
        assertEquals(10, pelaaja.getMaksimiElamat());
        pelaaja.kasvataMaksimia();
        assertEquals(11, pelaaja.getMaksimiElamat());
    }

    @Test
    public void setElamatTesti() {
        pelaaja.setMaksimiElamat(10);
        pelaaja.setElamat(11);
        assertEquals(10, pelaaja.getElamat());
        pelaaja.setElamat(10);
        assertEquals(10, pelaaja.getElamat());
        pelaaja.setElamat(9);
        assertEquals(9, pelaaja.getElamat());
    }

    @Test
    public void parannusTest() {
        pelaaja.setMaksimiElamat(10);
        pelaaja.setElamat(3);
        pelaaja.parannaPelaajaa();
        assertEquals(6, pelaaja.getElamat());
        pelaaja.kasvataParannusta();
        pelaaja.parannaPelaajaa();
        assertEquals(10, pelaaja.getElamat());
    }

    @Test
    public void kehitaOsumistarkkuuttaTest() {
        pelaaja.kehitaOsumistarkkuuttak();
        double osuminen = 0.55;
        assertEquals(osuminen, pelaaja.getOsumatarkkuus(),0.001);
    }
}
