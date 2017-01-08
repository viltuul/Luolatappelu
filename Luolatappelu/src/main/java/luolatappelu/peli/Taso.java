package luolatappelu.peli;

import java.util.Random;
import luolatappelu.hahmot.Olio;

/**
 * Taso luokka sisältää tason luomiseen tarvittavat metodit.
 */
public class Taso {

    private Random arpoja;
    private Oliokanta oliot;
    private Peli peli;
    private Luolasto luolasto;

    /**
     * Taso konstruktori luo uuden Luolaston sekä uuden oliokannan.
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
     * Metodi luo uuden oliokannan uudelle tasolle.
     *
     * @param moneskoTaso kertoo metodille monesko taso on menossa.
     */
    private void uudetOliot(int moneskoTaso) {
        this.oliot = new Oliokanta();
        for (int i = 0; i < 4 + moneskoTaso; i++) {
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

    public void uusiTaso(int moneskoTaso) {
        System.out.println("Tämä taso on " + moneskoTaso + ". taso!");
        uudetOliot(moneskoTaso);
        luolasto.uusiLuola();
        sijoitaPelaaja();
        sijoitaViholliset();
    }

    /**
     * Metodi tarkistaa onko enää elossa olevia olioita.
     *
     * @return palauttaa true jos kaikki oliot ovat kuolleet.
     */
    public boolean isTasoLapi() {
        boolean tasoLapi = false;
        if (oliot.getElossaOlevat().isEmpty()) {
            tasoLapi = true;
        }
        return tasoLapi;
    }
}
