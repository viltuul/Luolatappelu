/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.objektit;

import luolatappelu.objektit.Pelaaja;
import luolatappelu.objektit.Suunta;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class PaahahmoTest {

    private Pelaaja pelaaja;
    private Peli peli;

    public PaahahmoTest() {
        this.peli = new Peli(new Kayttoliittyma());
        this.pelaaja = new Pelaaja("testi", peli);
    }

    @Test
    public void luodaanPaahahmo() {
        assertEquals(pelaaja.getNimi(), "testi");
        assertEquals(pelaaja.getElamat(), 10);
    }

    @Test
    public void liikuMetodiToimiiEka() {
        pelaaja.liiku(Suunta.OIKEA);
        assertEquals(pelaaja.getX(), 1);
        pelaaja.liiku(Suunta.VASEN);
        assertEquals(pelaaja.getX(), 0);
        assertEquals(pelaaja.getY(), 0);
    }

    @Test
    public void liikuMetodiToimiiToka() {
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
        assertEquals(pelaaja.toString(), "@");
    }

    @Test
    public void toimiMetodiTest() {
        peli.uusiTaso();
        Olio vihu = peli.getTaso().getOliokanta().getViholliset().get(0);
        pelaaja.setX(1);
        pelaaja.setY(1);
        vihu.setX(2);
        vihu.setY(1);
        int elamat = vihu.getElamat();
        pelaaja.setOsumatarkkuus(1.0);
        pelaaja.toimi(Suunta.OIKEA);
        assertEquals(1, pelaaja.getX());
        assertEquals(elamat - 1, vihu.getElamat());
    }
}
