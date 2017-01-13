package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.objektit.Olio;
import luolatappelu.objektit.Pelaaja;
import luolatappelu.objektit.Seina;
import luolatappelu.kayttoliittyma.Kayttoliittyma;

/**
 * Peli luokka sisältää pelin toimintalogiikan.
 */
public class Peli {

    private Taso taso;
    private Pelaaja pelaaja;
    private Random arpoja;
    private int vaikeustaso;
    private Kayttoliittyma kayttoliittyma;
    private StringBuilder tapahtuma;
    private Kirjoitin kirjoitin;

    /**
     * Konstruktorissa luodaan taso, pelaaja, satunnaismuuttuja ja asetetaan
     * vaikeustaso.
     *
     * @param kayttoliittyma on pelin tarvitsema käyttöliittymä.
     */
    public Peli(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
        this.taso = new Taso(this);
        this.pelaaja = new Pelaaja(this);
        this.arpoja = new Random();
        this.kirjoitin = new Kirjoitin(this);
        this.vaikeustaso = 0;
    }

    /**
     * uusiTaso metodi luo uuden tason ja lisää yhdellä attribuuttia leveli.
     */
    public void uusiTaso() {
        this.taso = new Taso(this);
        vaikeustaso++;
        taso.uusiTaso(vaikeustaso);
        if (vaikeustaso > 1) {
            kayttoliittyma.kehitysIkkuna();
            pelaaja.parannaPelaajaa();
        }
    }

    public int getVaikeustaso() {
        return vaikeustaso;
    }

    public Taso getTaso() {
        return taso;
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public Oliokanta getOliokanta() {
        return taso.getOliokanta();
    }

    /**
     * Metodi tarkistaa annettujen parametrien koordinaatissa olevat oliot.
     *
     * @param x koordinaatin x arvo
     * @param y koordinaatin y arvo
     * @return lista olioista jotka ovat annetussa koordinaatissa.
     */
    public ArrayList<Olio> koordinaatinOliot(int x, int y) {
        ArrayList<Olio> lista = new ArrayList();
        ArrayList<Olio> kaikki = new ArrayList();
        kaikki.add(pelaaja);
        kaikki.addAll(taso.getOliokanta().getPuuseinat());
        kaikki.addAll(taso.getOliokanta().getViholliset());
        kaikki.addAll(taso.getLuolasto().getSeinat());
        for (Olio olio : kaikki) {
            if (olio.getX() == x && olio.getY() == y) {
                lista.add(olio);
            }
        }
        return lista;
    }

    /**
     * Metodi tarkistaa parametrissä olevan olion viereiset ruudut ja palauttaa
     * listan olioista, jotka sijaitsevat niissä ruuduissa. Lista on tyhjä jos
     * naapureita ei ole.
     *
     * @param olio Tarkistettava olio.
     * @return Lista naapuriolioista.
     */
    public ArrayList<Olio> getNaapurit(Olio olio) {
        ArrayList<Olio> lista = new ArrayList();
        if (koordinaatinOliot(olio.getX() + 1, olio.getY()) != null) {
            lista.addAll(koordinaatinOliot(olio.getX() + 1, olio.getY()));
        }
        if (koordinaatinOliot(olio.getX() - 1, olio.getY()) != null) {
            lista.addAll(koordinaatinOliot(olio.getX() - 1, olio.getY()));
        }
        if (koordinaatinOliot(olio.getX(), olio.getY() - 1) != null) {
            lista.addAll(koordinaatinOliot(olio.getX(), olio.getY() - 1));
        }
        if (koordinaatinOliot(olio.getX(), olio.getY() + 1) != null) {
            lista.addAll(koordinaatinOliot(olio.getX(), olio.getY() + 1));
        }
        return lista;
    }

    private void liikutaOlioita() {
        for (Olio olio : taso.getOliokanta().getViholliset()) {
            ArrayList<Olio> lista = this.getNaapurit(olio);
            if (lista.contains(pelaaja) && !olio.toString().equals("P")) {
                if (olio.lyo(pelaaja)) {
                    kirjoitin.lyontitapahtuma(olio, pelaaja, true);
                } else {
                    kirjoitin.lyontitapahtuma(olio, pelaaja, false);
                }
            } else {
                olio.liiku();
                if (tormaysObjektiin(olio)) {
                    olio.liikuTakaisin();
                }
            }
        }
    }

    /**
     * Paivita metodi liikuttaa olioita, poistaa kuolleet oliot kentältä,
     * tarkistaa onko pelaajalla vielä elämiä jäljellä sekä ilmoittaa jos taso
     * on läpi. Metodi myös kirjoittaa Ruudukkoon tapahtumienkulun.
     */
    public void paivita() {
        taso.getOliokanta().poistaKuolleet();
        liikutaOlioita();
        if (pelaaja.getElamat() <= 0) {
            kayttoliittyma.peliOhi();
        }
        kayttoliittyma.getRuudukko().kirjoitin(kirjoitin.getTapahtuma());
        kayttoliittyma.getRuudukko().pelaajanTiedot(kirjoitin.tietojenKirjoitin());
    }

    /**
     * Metodi kysyy oliolta koordinaatit ja tarkistaa onko koordinaatissa
     * useampi kuin yksi olio.
     *
     * @param olio Tarkistettavan olion koordinaatit
     * @return true jos samassa koordinaatissa on useampi olio kuin yksi.
     */
    public boolean tormaysObjektiin(Olio olio) {
        if (this.koordinaatinOliot(olio.getX(), olio.getY()).size() > 1) {
            return true;
        } else {
            return false;
        }
    }

    public Runnable getKayttoliittyma() {
        return kayttoliittyma;
    }

    /**
     * Metodi palauttaa kaikki pelaajan ja pelin tiedot alkuasentoon.
     */
    public void nollaaKaikki() {
        pelaaja.setMaksimiElamat(10);
        pelaaja.setElamat(10);
        pelaaja.setOsumatarkkuus(0.5);
        pelaaja.setNimi("Pelaaja");
        pelaaja.setParannus(3);
        vaikeustaso = 0;
    }

    public boolean isTasoLapi() {
        if (taso.getOliokanta().getElossaOlevat().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Kirjoitin getKirjoitin() {
        return kirjoitin;
    }
    

}
