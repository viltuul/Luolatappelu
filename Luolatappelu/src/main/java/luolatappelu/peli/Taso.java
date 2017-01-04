package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Seina;

/**
 * Taso luokka sisältää tason luomiseen tarvittavat metodit.
 */
public class Taso {

    private int leveys;
    private int korkeus;
    private ArrayList<Seina> seinat;
    private Random arpoja;
    private Oliokanta oliot;
    private Peli peli;
    private boolean tasoLapi;
    private Luolasto luolasto;

    public Taso(Peli peli) {
        this.peli = peli;
        this.arpoja = new Random();
        this.leveys = arpoja.nextInt(9) + 12;
        this.korkeus = 20;
        this.seinat = new ArrayList();
        this.oliot = new Oliokanta();
        this.tasoLapi = false;
        this.luolasto = new Luolasto();
    }


    public Luolasto getLuolasto() {
        return luolasto;
    }

    public void sijoitaPelaaja() {
        peli.getPelaaja().setX(1);
        peli.getPelaaja().setY(luolasto.getKorkeus() - 1);
    }

    public void sijoitaViholliset() {
        for (Olio sijoitettava : oliot.getViholliset()) {
            sijoitettava.setX(arpoja.nextInt(luolasto.getLeveys() - 2) + 1);
            sijoitettava.setY(arpoja.nextInt(luolasto.getKorkeus() - 2) + 1);
        }
    }

    public Oliokanta getOliokanta() {
        return oliot;
    }

    public void uudetOliot(int taso) {
        System.out.println("tämä taso on" + taso + ". taso!");
        this.oliot = new Oliokanta();
        for (int i = 0; i < 4 + taso; i++) {
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

    public void uusiTaso(int monesko) {
        uudetOliot(monesko);
        luolasto.uusiLuola();
        sijoitaPelaaja();
        sijoitaViholliset();
    }

    public boolean isTasoLapi() {
        if (oliot.getElossaOlevat().isEmpty()) {
            tasoLapi = true;
        }
        return tasoLapi;
    }
}
