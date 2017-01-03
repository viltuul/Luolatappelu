package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Seina;

public class Taso {

    private int leveys;
    private int korkeus;
    private ArrayList<Seina> seinat;
    private Random arpoja;
    private Oliokanta oliot;
    private Peli peli;

    public Taso(Peli peli) {
        this.peli = peli;
        this.arpoja = new Random();
        this.leveys = arpoja.nextInt(9) + 12;
        this.korkeus = 20;
        this.seinat = new ArrayList();
        this.oliot = new Oliokanta();
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public ArrayList<Seina> getSeina() {
        return seinat;
    }

    public void rakennaSeinat() {
        for (int i = 0; i < this.getLeveys() + 1; i++) {
            Seina seinaYla = new Seina(i, 0);
            seinat.add(seinaYla);
            Seina seinaAla = new Seina(i, this.getKorkeus());
            seinat.add(seinaAla);
        }
        for (int j = 0; j < this.getKorkeus(); j++) {
            Seina seinaVas = new Seina(0, j);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(this.getLeveys(), j);
            seinat.add(seinaOik);
        }
    }

    public void sijoitaPelaaja() {
        peli.getPelaaja().setX(this.getLeveys() / 2);
        peli.getPelaaja().setY(this.getKorkeus() - 1);
    }

    public void sijoitaViholliset() {
        for (Olio sijoitettava : oliot.getViholliset()) {
            sijoitettava.setX(arpoja.nextInt(this.getLeveys() - 2) + 1);
            sijoitettava.setY(arpoja.nextInt(this.getKorkeus() - 2) + 1);
        }
    }

    public Oliokanta getOliokanta() {
        return oliot;
    }

    public void uudetOliot(int taso) {
        System.out.println("tämä taso on jo" + taso);
        this.oliot = new Oliokanta();
        for (int i = 0; i < 5; i++) {
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
        rakennaSeinat();
        sijoitaPelaaja();
        sijoitaViholliset();
    }

}
