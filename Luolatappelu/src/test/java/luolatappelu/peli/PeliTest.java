/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
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
public class PeliTest {

    private Peli peli;

    public PeliTest() {
        this.peli = new Peli();
    }

    @Test
    public void pelinLuominen() {
        Huone huone = peli.getHuone();
        assertEquals(huone.getKorkeus(), 20);
        assertEquals(huone.getLeveys(), 20);
        assertEquals(peli.getOrkit().toString(), "[]");
        assertEquals(peli.getPelaaja().getNimi(), "Pelaaja");
    }

    @Test
    public void pelajanSijoitusToimii() {
        peli.sijoitaPelaaja();
        assertEquals(peli.getPelaaja().getX(), 10);
        assertEquals(peli.getPelaaja().getY(), 19);
    }

    @Test
    public void orkkienLisaaminenJaSijoitus() {
        for (int i = 0; i < 5; i++) {
            peli.uusiOrkki();
        }
        assertEquals(peli.getOrkit().size(), 5);
        assertEquals(5, peli.getViholliset().size());
    }

    @Test
    public void seuraajienLuonti() {
        for (int i = 0; i < 5; i++) {
            peli.uusiSeuraaja();
        }
        assertEquals(5, peli.getSeuraajat().size());
        assertEquals(5, peli.getViholliset().size());
    }

    @Test
    public void vihollistenSijoitus() {
        for (int i = 0; i < 5; i++) {
            peli.uusiSeuraaja();
            peli.uusiOrkki();
        }
        peli.sijoitaViholliset();
        for (int j = 0; j < 100; j++) {
            for (Orkki orkki : peli.getOrkit()) {
                assertFalse(orkki.getX() > peli.getHuone().getLeveys());
                assertFalse(orkki.getX() < 0);
                assertFalse(orkki.getY() > peli.getHuone().getKorkeus());
                assertFalse(orkki.getY() < 0);
            }
        }
    }

    @Test
    public void eiMeneReunanYliTestaus() {
        peli.uusiOrkki();
        Orkki orkki = peli.getOrkit().get(0);
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 25; j++) {
                orkki.liiku();
            }
            peli.eiMeneReunanYli(orkki);
            assertFalse(orkki.getX() > peli.getHuone().getLeveys());
            assertFalse(orkki.getX() < 0);
            assertFalse(orkki.getY() > peli.getHuone().getKorkeus());
            assertFalse(orkki.getY() < 0);
        }
    }

    @Test
    public void koordinaatinOlioTesti() {
        peli.getPelaaja().setX(5);
        peli.getPelaaja().setY(5);
        assertEquals(peli.koordinaatinOlio(5, 5), peli.getPelaaja());
    }

    @Test
    public void getNaapuritTesti() {
        peli.uusiOrkki();
        peli.uusiSeuraaja();
        peli.getOrkit().get(0).setX(1);
        peli.getSeuraajat().get(0).setY(1);
        assertEquals(peli.getNaapurit(peli.getPelaaja()), peli.getViholliset());
    }

    @Test
    public void liikutaOlioitaTesti() {
        peli.uusiOrkki();
        peli.uusiSeuraaja();
        int i = 0;
        for (Olio olio : peli.getViholliset()) {
            olio.setX(10 + i);
            olio.setY(10 + i);
            i++;
        }
        peli.liikutaOlioita();
        assertFalse(peli.getOrkit().get(0).getX() == 10 && peli.getOrkit().get(0).getY() == 10);
        assertFalse(peli.getSeuraajat().get(0).getX() == 11 && peli.getSeuraajat().get(0).getY() == 11);
    }
}
