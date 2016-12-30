package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seuraaja;

public class Peli {

    private ArrayList<Orkki> orkit;
    private ArrayList<Seuraaja> seuraajat;
    private ArrayList<Olio> viholliset;
    private Huone huone;
    private Pelaaja pelaaja;

    public Peli() {
        this.huone = new Huone(20, 20);
        this.orkit = new ArrayList();
        this.viholliset = new ArrayList();
        this.seuraajat = new ArrayList();
        this.pelaaja = new Pelaaja("Pelaaja");
    }

    public Huone getHuone() {
        return huone;
    }

    public void sijoitaPelaaja() {
        pelaaja.setX(huone.getLeveys() / 2);
        pelaaja.setY(huone.getKorkeus() - 1);
    }

    public Pelaaja getPelaaja() {
        return pelaaja;
    }

    public ArrayList<Olio> getViholliset() {
        return viholliset;
    }

    public void uusiOrkki() {
        Orkki orkki = new Orkki();
        orkit.add(orkki);
        viholliset.add(orkki);
    }

    public void uusiSeuraaja() {
        Seuraaja seuraaja = new Seuraaja();
        seuraajat.add(seuraaja);
        viholliset.add(seuraaja);
    }

    public ArrayList<Seuraaja> getSeuraajat() {
        return seuraajat;
    }

    public void sijoitaViholliset() {
        Random random = new Random();
        for (Olio sijoitettava : viholliset) {
            while (true){
            sijoitettava.setX(random.nextInt(huone.getLeveys()));
            sijoitettava.setY(random.nextInt(huone.getKorkeus()));
            if (this.tormaysObjektiin(sijoitettava)){
                break;
            }}
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

    public ArrayList<Orkki> getOrkit() {
        return orkit;
    }

    public Olio koordinaatinOlio(int x, int y) {
        if (pelaaja.getX() == x && pelaaja.getY() == y) {
            return pelaaja;
        }
        for (Olio olio : viholliset) {
            if (olio.getX() == x && olio.getY() == y) {
                return olio;
            }
        }
        return null;
    }
//
//    public void tulostaHuone() {
//        for (int j = 0; j < huone.getKorkeus(); j++) {
//            for (int i = 0; i < huone.getLeveys(); i++) {
//                if (koordinaatinOlio(i, j) != null) {
//                    System.out.print(koordinaatinOlio(i, j));
//                } else {
//                    System.out.print(".");
//                }
//            }
//            System.out.println("");
//        }
//        System.out.println("");
//    }

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
//        for (Olio olio : viholliset) {
//            if (!olio.isElossa()) {
//                viholliset.remove(olio);
//            } 
//        } Pitää poistua loopista ennen kuin voi poistaaKuolleet muuten ohjelma kaatuu
    }

    public void liikutaOlioita() {
        for (Olio olio : viholliset) {
            ArrayList<Olio> lista = this.getNaapurit(olio);
            if (lista.contains(pelaaja)) {
                this.lyoNaapuria(olio);
            } else if (olio.toString().equals("Ö")) {
                Orkki orkki = (Orkki) olio;
                orkki.liiku();
            } else {
                Seuraaja seuraaja = (Seuraaja) olio;
                seuraaja.liiku(pelaaja);
            }
            this.eiMeneReunanYli(olio);
            this.poistaKuolleet();
        }
    }

    public boolean tormaysObjektiin(Olio olio) {
        if (this.koordinaatinOlio(olio.getX(), olio.getY()) == null) {
            return false;
        } else {
            return true;
        }
//        Liiku -> tarkista oliko uudessa kohdassa objektia -> jos oli liiku takaisin
    }
}
