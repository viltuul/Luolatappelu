/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import java.util.ArrayList;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.objektit.Olio;
import luolatappelu.objektit.Seina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class PeliTest {

    private Peli peli;

    public PeliTest() {
        this.peli = new Peli(new Kayttoliittyma());
    }

    @Test
    public void pelinLuominen() {
        Taso huone = peli.getTaso();
        assertEquals(huone.getLuolasto().getKorkeus(), 20);
        assertEquals(peli.getOliokanta().getOrkit().toString(), "[]");
        assertEquals(peli.getPelaaja().getNimi(), "Pelaaja");
    }

    @Test
    public void pelajanSijoitusToimii() {
        peli.getTaso().sijoitaPelaaja();
        assertEquals(peli.getPelaaja().getY(), 19);
    }

    @Test
    public void orkkienLisaaminenJaSijoitus() {
        for (int i = 0; i < 5; i++) {
            peli.getOliokanta().uusiOrkki(1);
        }
        assertEquals(peli.getOliokanta().getOrkit().size(), 5);
        assertEquals(5, peli.getOliokanta().getViholliset().size());
    }

    @Test
    public void seuraajienLuonti() {
        for (int i = 0; i < 5; i++) {
            peli.getOliokanta().uusiSeuraaja(1, peli.getPelaaja());
        }
        assertEquals(5, peli.getOliokanta().getSeuraajat().size());
        assertEquals(5, peli.getOliokanta().getViholliset().size());
    }

    @Test
    public void koordinaatinOlioTesti() {
        peli.getPelaaja().setX(5);
        peli.getPelaaja().setY(5);
        assertEquals(peli.koordinaatinOliot(5, 5).toString(), "[" + peli.getPelaaja() + "]");
    }

    @Test
    public void getNaapuritTesti() {
        peli.getOliokanta().uusiOrkki(1);
        peli.getOliokanta().uusiSeuraaja(1, peli.getPelaaja());
        peli.getOliokanta().getOrkit().get(0).setX(1);
        peli.getOliokanta().getSeuraajat().get(0).setY(1);
        assertEquals(peli.getNaapurit(peli.getPelaaja()), peli.getOliokanta().getViholliset());
    }

    @Test
    public void uudenTasonTestaaminen1() {
        peli.getPelaaja().setElamat(5);
        peli.uusiTaso();
        peli.uusiTaso();
        assertEquals(8, peli.getPelaaja().getElamat());
        assertEquals(2, peli.getVaikeustaso());
        assertEquals(peli.getPelaaja().getX(), 1);
        assertEquals(peli.getPelaaja().getY(), 19);
        assertEquals(6, peli.getOliokanta().getElossaOlevat().size());
        peli.uusiTaso();
        assertEquals(peli.getVaikeustaso(), 3);
    }

    @Test
    public void olioLyoJosPelaajaOnVieressa() {
        peli.getTaso().sijoitaPelaaja();
        int elamat = peli.getPelaaja().getElamat();
        peli.getOliokanta().uusiOrkki(1);
        peli.getOliokanta().getViholliset().get(0).setX(2);
        peli.getOliokanta().getViholliset().get(0).setY(19);
        peli.getOliokanta().getViholliset().get(0).setOsumatarkkuus(1.0);
        peli.paivita();
        assertEquals(elamat - 1, peli.getPelaaja().getElamat());
    }

    @Test
    public void seuraajatHyokkaavatPelaajanKimppuun() {
        for (int i = 0; i < 5; i++) {
            peli.uusiTaso();
        }
        int elamatAlussa = peli.getPelaaja().getElamat();
        for (int i = 0; i < 1000; i++) {
            peli.paivita();
            if (peli.getPelaaja().getElamat() < elamatAlussa) {
                break;
            }
        }
        assertTrue(peli.getPelaaja().getElamat() < elamatAlussa);
    }

    @Test
    public void naapurienTestaus() {
        peli.getOliokanta().uusiOrkki(1);
        assertEquals(new ArrayList<Olio>(), peli.getNaapurit(peli.getOliokanta().getViholliset().get(0)));
    }

    @Test
    public void olioEiLiikuJosYmparoituOlioilla() {
        peli.getOliokanta().uusiTankki(1);
        Olio tankki = peli.getOliokanta().getViholliset().get(0);
        Seina seina1 = new Seina(1, 0);
        peli.getTaso().getLuolasto().getSeinat().add(seina1);
        Seina seina2 = new Seina(1, 2);
        peli.getTaso().getLuolasto().getSeinat().add(seina2);
        Seina seina3 = new Seina(0, 1);
        peli.getTaso().getLuolasto().getSeinat().add(seina3);
        Seina seina4 = new Seina(2, 1);
        peli.getTaso().getLuolasto().getSeinat().add(seina4);
        tankki.setX(1);
        tankki.setY(1);
        for (int i = 0; i < 10; i++) {
            peli.paivita();
        }
        assertEquals(tankki.getX(), 1);
        assertEquals(tankki.getY(), 1);
    }

    @Test
    public void paivitaMetodinTest() {
        peli.uusiTaso();
        Olio ekaOlio = peli.getOliokanta().getViholliset().get(0);
        ekaOlio.setElamat(0);
        peli.paivita();
        assertTrue(ekaOlio.getX() > 20);
    }
}
