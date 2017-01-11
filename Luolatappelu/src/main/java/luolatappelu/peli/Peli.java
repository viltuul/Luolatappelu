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

    /**
     * Konstruktorissa luodaan taso, pelaaja, satunnaismuuttuja ja asetetaan
     * vaikeustaso.
     *
     * @param kayttoliittyma on pelin tarvitsema käyttöliittymä.
     */
    public Peli(Kayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
        this.taso = new Taso(this);
        this.pelaaja = new Pelaaja("Pelaaja", this);
        this.arpoja = new Random();
        this.vaikeustaso = 0;
    }

    /**
     * uusiTaso metodi luo uuden tason ja lisää yhdellä attribuuttia leveli.
     */
    public void uusiTaso() {
        this.taso = new Taso(this);
        vaikeustaso++;
        pelaaja.kasvataMaksimia();
        pelaaja.parannaPelaajaa();
        taso.uusiTaso(vaikeustaso);
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
        if (pelaaja.getX() == x && pelaaja.getY() == y) {
            lista.add(pelaaja);
        }
        for (Olio olio : taso.getOliokanta().getViholliset()) {
            if (olio.getX() == x && olio.getY() == y) {
                lista.add(olio);
            }
        }
        for (Seina seina : taso.getLuolasto().getSeinat()) {
            if (seina.getX() == x && seina.getY() == y) {
                lista.add(seina);
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
            if (lista.contains(pelaaja)) {
                tapahtumaTekstiksi(olio.lyo(pelaaja));
            } else {
                olio.liiku();
                if (tormaysObjektiin(olio)) {
                    olio.liikuTakaisin();
                }
            }
        }
    }

    /**
     * Pivita metodi liikuttaa olioita, poistaa kuolleet oliot kentältä,
     * tarkistaa onko pelaajalla vielä elämiä jäljellä sekä ilmoittaa jos taso
     * on läpi. Metodi myös kirjoittaa Ruudukkoon tapahtumienkulun.
     */
    public void paivita() {
        taso.getOliokanta().poistaKuolleet();
        liikutaOlioita();
        if (pelaaja.getElamat() == 0) {
            kayttoliittyma.peliOhi();
        }
        kayttoliittyma.getRuudukko().kirjoitin(tapahtumienKirjoitin());
        kayttoliittyma.getRuudukko().pelaajanTiedot(tietojenKirjoitin());
    }

    private String tapahtumienKirjoitin() {
        this.tapahtuma = new StringBuilder();
        for (Olio olio : taso.getOliokanta().getViholliset()) {
            tapahtuma.append("\n" + tapahtumaTekstiksi(true) + " ");
        }
        return tapahtuma.toString();
    }

    private String tapahtumaTekstiksi(boolean osuiko) {
        if (osuiko) {
            return "osuma";
        } else {
            return "ohi";
        }
    }

    private String tietojenKirjoitin() {
        StringBuilder tietojenTulostin = new StringBuilder();
        tietojenTulostin.append("Taso: " + vaikeustaso + "\n");
        tietojenTulostin.append("Pelaajan elämät: " + pelaaja.getElamat() + "/" + pelaaja.getMaksimiElamat());
        return tietojenTulostin.toString();
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

}
