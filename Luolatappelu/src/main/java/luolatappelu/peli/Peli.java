package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seina;
import luolatappelu.hahmot.Seuraaja;
import luolatappelu.hahmot.Tankki;
import luolatappelu.kayttoliittyma.Kayttoliittyma;

/**
 * Peli luokka sisältää pelin toimintalogiikan.
 */

public class Peli {

    private ArrayList<Seina> seinat;
    private Taso taso;
    private Pelaaja pelaaja;
    private Random arpoja;
    private int leveli;
    private Kayttoliittyma kayttoliittyma;

    public Peli() {
        this.kayttoliittyma = new Kayttoliittyma(this);
        this.taso = new Taso(this);
        this.seinat = new ArrayList();
        this.pelaaja = new Pelaaja("Pelaaja", this);
        this.arpoja = new Random();
        this.leveli = 0;
    }

    public void uusiTaso() {
        this.taso = new Taso(this);
        leveli++;
        taso.uusiTaso(leveli);
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
        for (Seina seina : taso.getSeina()) {
            if (seina.getX() == x && seina.getY() == y) {
                lista.add(seina);
            }
        }
        return lista;
    }

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

    public void lyoNaapuria(Olio lyoja) {
        ArrayList<Olio> lista = getNaapurit(lyoja);
        if (!lista.isEmpty()) {
            lyoja.lyo(lista.get(arpoja.nextInt(lista.size())));
        }
    }

    public void liikutaOlioita() {
        for (Olio olio : taso.getOliokanta().getViholliset()) {
            ArrayList<Olio> lista = this.getNaapurit(olio);
            if (lista.contains(pelaaja)) {
                olio.lyo(pelaaja);
            } else if (olio.toString().equals("Ö")) {
                liikutaOrkkia(olio);
            } else if (olio.toString().equals("S")) {
                liikutaSeuraajaa(olio);
            } else if (olio.toString().equals("T")) {
                liikutaTankkia(olio);
            }
        }
    }

    public void paivita() {
        liikutaOlioita();
        taso.getOliokanta().poistaKuolleet();
        if (taso.isTasoLapi()) {
            System.out.println("Paina space niin pääset seuraavalle tasolle");
        }
    }

    public void liikutaOrkkia(Olio olio) {
        Orkki orkki = (Orkki) olio;
        orkki.liiku();
        if (tormaysObjektiin(orkki)) {
            orkki.liikuTakaisin();
        }
    }

    public void liikutaSeuraajaa(Olio olio) {
        Seuraaja seuraaja = (Seuraaja) olio;
        seuraaja.liiku();
        if (tormaysObjektiin(seuraaja)) {
            seuraaja.liikuTakaisin();
        }
    }

    private void liikutaTankkia(Olio olio) {
        Tankki tankki = (Tankki) olio;
        tankki.liiku();
        if (tormaysObjektiin(tankki)) {
            tankki.liikuTakaisin();
        }
    }

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
