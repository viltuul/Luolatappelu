/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu.kayttoliittyma;

import java.util.ArrayList;
import luolatappelu.luolatappelu.hahmot.Olio;
import luolatappelu.luolatappelu.hahmot.Paahahmo;

/**
 *
 * @author tuulio
 */
public class Peli {

    private ArrayList<Olio> oliot;
    private ArrayList<Huone> huoneet;

    public Peli() {
        this.huoneet = new ArrayList();
        this.oliot = new ArrayList();
    }

    public void uusiHuone() {
        Huone huone = new Huone(10, 10);
        huoneet.add(huone);
    }

    public void uusiHahmo(String nimi) {
        Olio pelaaja = new Paahahmo("Pelaaja");
        oliot.add(pelaaja);
    }

    public ArrayList<Huone> getHuoneet() {
        return huoneet;
    }

    public ArrayList<Olio> getOliot() {
        return oliot;
    }

}
