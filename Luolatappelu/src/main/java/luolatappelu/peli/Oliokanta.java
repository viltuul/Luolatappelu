package luolatappelu.peli;

import java.util.ArrayList;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Ovi;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seina;
import luolatappelu.hahmot.Seuraaja;
import luolatappelu.hahmot.Tankki;

public class Oliokanta {

    private ArrayList<Orkki> orkit;
    private ArrayList<Seuraaja> seuraajat;
    private ArrayList<Tankki> tankit;
    private ArrayList<Olio> viholliset;
    private ArrayList<Seina> seinat;

    public Oliokanta() {
        this.orkit = new ArrayList();
        this.seinat = new ArrayList();
        this.viholliset = new ArrayList();
        this.seuraajat = new ArrayList();
        this.tankit = new ArrayList();
    }

    public ArrayList<Olio> getViholliset() {
        if (viholliset.size() == 0) {
            this.uusiOvi();
        }
        return viholliset;
    }

    public void uusiOrkki() {
        Orkki orkki = new Orkki();
        orkit.add(orkki);
        viholliset.add(orkki);
    }

    public ArrayList<Orkki> getOrkit() {
        return orkit;
    }

    public void uusiSeuraaja(Pelaaja pelaaja) {
        Seuraaja seuraaja = new Seuraaja(pelaaja);
        seuraajat.add(seuraaja);
        viholliset.add(seuraaja);
    }

    public ArrayList<Seuraaja> getSeuraajat() {
        return seuraajat;
    }

    public void uusiTankki() {
        Tankki tankki = new Tankki();
        tankit.add(tankki);
        viholliset.add(tankki);
    }

    public ArrayList<Tankki> getTankit() {
        return tankit;
    }

    public void poistaKuolleet() {
        for (Olio olio : viholliset) {
            if (!olio.isElossa()) {
                olio.setX(99999999);
            }
        }
    }

    public Ovi uusiOvi() {
        Ovi ovi = new Ovi();
        return ovi;
    }
}
