/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import java.util.ArrayList;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seina;
import luolatappelu.hahmot.Seuraaja;

/**
 *
 * @author ville
 */
public class Oliokanta {

    private ArrayList<Orkki> orkit;
    private ArrayList<Seuraaja> seuraajat;
    private ArrayList<Olio> viholliset;
    private ArrayList<Seina> seinat;

    public Oliokanta() {
        this.orkit = new ArrayList();
        this.seinat = new ArrayList();
        this.viholliset = new ArrayList();
        this.seuraajat = new ArrayList();
    }
    
    public ArrayList<Olio> getViholliset() {
        return viholliset;
    }

    public void uusiOrkki() {
        Orkki orkki = new Orkki();
        orkit.add(orkki);
        viholliset.add(orkki);
    }
    public ArrayList<Orkki> getOrkit(){
        return orkit;
    }

    public void uusiSeuraaja() {
        Seuraaja seuraaja = new Seuraaja();
        seuraajat.add(seuraaja);
        viholliset.add(seuraaja);
    }

    public ArrayList<Seuraaja> getSeuraajat() {
        return seuraajat;
    }
}
