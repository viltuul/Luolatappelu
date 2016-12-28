package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Paahahmo;
import luolatappelu.hahmot.Suunta;

public class Peli {

    private ArrayList<Orkki> orkit;
    private Huone huone;
    private Paahahmo pelaaja;

    public Peli() {
        this.huone = new Huone(10, 5);
        this.orkit = new ArrayList();
        this.pelaaja = new Paahahmo("Pelaaja");
    }

    public Huone getHuone() {
        return huone;
    }

    public void pelaajanSijoitus() {
        pelaaja.setX(huone.getLeveys() / 2);
        pelaaja.setY(huone.getKorkeus() - 1);
    }

    public Paahahmo getPelaaja() {
        return pelaaja;
    }

    public void uusiOrkki() {
        Orkki orkki = new Orkki();
        orkit.add(orkki);
    }

    public void sijoitaOliot() {
        Random random = new Random();
        for (Olio sijoitettava : orkit) {
            sijoitettava.setX(random.nextInt(huone.getLeveys()));
            sijoitettava.setY(random.nextInt(huone.getKorkeus()) - 1);
        }
    }

    public void eiMeneReunanYli(Olio olio) {
        if (olio.isElossa()) {
            if (olio.getX() > huone.getLeveys() - 1) {
                olio.setX(huone.getLeveys() - 2);
            }
            if (olio.getY() > huone.getKorkeus() - 1) {
                olio.setY(huone.getKorkeus() - 2);
            }
            if (olio.getX() < 0) {
                olio.setX(0);
            }
            if (olio.getY() < 0) {
                olio.setY(0);
            }
        }
    }

    public ArrayList<Orkki> getOliot() {
        return orkit;
    }

    public Olio koordinaatinOlio(int x, int y) {
        if (pelaaja.getX() == x && pelaaja.getY() == y) {
            return pelaaja;
        }
        for (Olio olio : orkit) {
            if (olio.getX() == x && olio.getY() == y) {
                return olio;
            }
        }
        return null;
    }

    public void tulostaHuone() {
        for (int j = 0; j < huone.getKorkeus(); j++) {
            for (int i = 0; i < huone.getLeveys(); i++) {
                if (koordinaatinOlio(i, j) != null) {
                    System.out.print(koordinaatinOlio(i, j));
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public ArrayList<Olio> getNaapurit(Olio olio) {
        ArrayList<Olio> lista = new ArrayList();
        if (koordinaatinOlio(olio.getX() + 1, olio.getY()) != null) {
            lista.add(koordinaatinOlio(olio.getX() + 1, olio.getY()));
        }
        if (koordinaatinOlio(olio.getX() - 1, olio.getY()) != null) {
            lista.add(koordinaatinOlio(olio.getX() - 1, olio.getY()));
        }
        if (koordinaatinOlio(olio.getX(), olio.getY() - 1) != null) {
            lista.add(koordinaatinOlio(olio.getX(), olio.getY() - 1));
        }
        if (koordinaatinOlio(olio.getX(), olio.getY() + 1) != null) {
            lista.add(koordinaatinOlio(olio.getX(), olio.getY() + 1));
        }
        return lista;
    }

    public void lyoNaapuria(Olio lyoja) {
        ArrayList<Olio> lista = getNaapurit(lyoja);
        if (!lista.isEmpty()) {
            Random r = new Random();
            lyoja.lyo(lista.get(r.nextInt(lista.size())));
        }
    }

    public void poistaKuolleet() {
        for (Olio orkki : orkit) {
            if (!orkki.isElossa()) {
                orkki.setX(99999999);
            }
        }
//for (Olio orkki : orkit){
//    if (!orkki.isElossa()){
//        orkit.remove(orkki);
//    }
//}
    }
}
