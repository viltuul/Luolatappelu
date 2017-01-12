package luolatappelu.peli;

import java.util.Random;
import luolatappelu.objektit.Olio;
import luolatappelu.objektit.Oviaukko;
import luolatappelu.objektit.Seina;

/**
 * Taso luokka sisältää tason luomiseen tarvittavat metodit.
 */
public class Taso {

    private Random arpoja;
    private Oliokanta oliot;
    private Peli peli;
    private Luolasto luolasto;
    private Oviaukko ovi;

    /**
     * Taso konstruktori luo satunnaismuuttujan, uuden Luolaston sekä uuden
     * oliokannan.
     *
     * @param peli Peli jolle luodaan uusi taso.
     */
    public Taso(Peli peli) {
        this.peli = peli;
        this.arpoja = new Random();
        this.oliot = new Oliokanta();
        this.luolasto = new Luolasto();
    }

    public Luolasto getLuolasto() {
        return luolasto;
    }

    /**
     * Metodi sijoittaa pelaajan luolaston vasempaan alalaitaan.
     */
    public void sijoitaPelaaja() {
        peli.getPelaaja().setX(1);
        peli.getPelaaja().setY(luolasto.getKorkeus() - 1);
    }

    /**
     * Metodi sijoittaa viholliset satunnaisesti arvottuihin paikkoihin
     * luolastossa. Metodi myös tarkistaa, ettei viholliset sijoitu toistensa
     * tai seinien päälle.
     */
    public void sijoitaViholliset() {
        for (Olio sijoitettava : oliot.getViholliset()) {
            while (true) {
                int x = arpoja.nextInt(luolasto.getLeveys() - 2) + 1;
                int y = arpoja.nextInt(luolasto.getKorkeus() - 2) + 1;
                sijoitettava.setX(x);
                sijoitettava.setY(y);
                if (peli.koordinaatinOliot(x, y).size() < 2) {
                    break;
                }
            }
        }
    }

    public Oliokanta getOliokanta() {
        return oliot;
    }

    /**
     * Metodi luo uuden oliokannan uudelle tasolle. Jos taso on jaollinen
     * viidellä niin luodaan vain Seuraajaolioita.
     *
     * @param vaikeusTaso kertoo metodille monesko taso on menossa.
     */
    public void uudetOliot(int vaikeusTaso) {
        if (vaikeusTaso % 4 == 0) {
            bonustasonOliot(vaikeusTaso);
        } else {
            normaalinTasonOliot(vaikeusTaso);
        }
    }

    private void normaalinTasonOliot(int vaikeusTaso) {
        this.oliot = new Oliokanta();
        for (int i = 0; i < 4 + vaikeusTaso; i++) {
            double arpa = arpoja.nextDouble();
            if (arpa < 0.4) {
                oliot.uusiOrkki();
            } else if (arpa >= 0.4 && arpa < 0.7) {
                oliot.uusiSeuraaja(peli.getPelaaja());
            } else {
                oliot.uusiTankki();
            }
        }
    }

    private void bonustasonOliot(int vaikeusTaso) {
        this.oliot = new Oliokanta();
        for (int i = 0; i < 4 + vaikeusTaso; i++) {
            oliot.uusiSeuraaja(peli.getPelaaja());
        }
    }

    /**
     * Metodissa luodaan uusi taso. Metodi siis luo uudet oliot, uuden
     * luolaston, ja sijoittaa kaikki oliot sekä oviaukon.
     *
     * @param vaikeustaso kertoo monesko taso on menossa.
     */
    public void uusiTaso(int vaikeustaso) {
        uudetOliot(vaikeustaso);
        luolasto.uusiLuola();
        if (vaikeustaso % 12 != 0) {
            luolasto.uudetSeinat();
        }
        sijoitaPelaaja();
        sijoitaViholliset();
        sijoitaOviaukko();
    }

    /**
     * Metodi tarkistaa onko enää elossa olevia olioita.
     *
     * @return palauttaa true jos kaikki oliot ovat kuolleet.
     */
    public boolean isTasoLapi() {
        if (oliot.getElossaOlevat().isEmpty()) {
            return true;
        }
        return false;
    }

    public Oviaukko getOvi() {
        return ovi;
    }

    /**
     * Metodi sijoittaa oviaukon kohtaan luolastossa, jossa ei ole olioita.
     */
    public void sijoitaOviaukko() {
        while (true) {
            int x = arpoja.nextInt(19) + 1;
            int y = arpoja.nextInt(19) + 1;
            if (peli.koordinaatinOliot(x, y).isEmpty()) {
                this.ovi = new Oviaukko(x, y);
                break;
            }
        }
    }
}
