package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seina;
import luolatappelu.hahmot.Seuraaja;

public class Peli {

    private ArrayList<Seina> seinat;
    private Huone huone;
    private Pelaaja pelaaja;
    private Oliokanta oliot;

    public Peli() {
        this.oliot = new Oliokanta();
        this.huone = new Huone(20, 20);
        this.seinat = new ArrayList();
        this.pelaaja = new Pelaaja("Pelaaja");
    }

    public Oliokanta getOliokanta() {
        return oliot;
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

    public ArrayList<Seina> getSeina() {
        return seinat;
    }

    public void rakennaSeinat() {
        for (int i = 0; i < 21; i++) {
            Seina seinaYla = new Seina(i, 0);
            seinat.add(seinaYla);
            Seina seinaAla = new Seina(i, 20);
            seinat.add(seinaAla);
            Seina seinaVas = new Seina(0, i);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(20, i);
            seinat.add(seinaOik);
        }
    }

    public void sijoitaViholliset() {
        Random random = new Random();
        for (Olio sijoitettava : oliot.getViholliset()) {
//            while (true) {
            sijoitettava.setX(random.nextInt(huone.getLeveys() - 1));
            sijoitettava.setY(random.nextInt(huone.getKorkeus() - 1));
//                if (this.tormaysObjektiin(sijoitettava)) {
//                    break;
//                }
//            }
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

    public ArrayList<Olio> koordinaatinOliot(int x, int y) {
        ArrayList<Olio> lista = new ArrayList();
        if (pelaaja.getX() == x && pelaaja.getY() == y) {
            lista.add(pelaaja);
        }
        for (Olio olio : oliot.getViholliset()) {
            if (olio.getX() == x && olio.getY() == y) {
                lista.add(olio);
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
            Random r = new Random();
            lyoja.lyo(lista.get(r.nextInt(lista.size())));
        }
    }

    public void poistaKuolleet() {
        for (Olio olio : oliot.getViholliset()) {
            if (!olio.isElossa()) {
                olio.setX(99999999);
            }
        }
    }

    public void liikutaOlioita() {
        for (Olio olio : oliot.getViholliset()) {
            ArrayList<Olio> lista = this.getNaapurit(olio);
            if (lista.contains(pelaaja)) {
                this.lyoNaapuria(olio);
            } else if (olio.toString().equals("Ö")) {
                Orkki orkki = (Orkki) olio;
                orkki.liiku();
                if (tormaysObjektiin(orkki)) {
                    orkki.liikuTakaisin();
                }
            } else {
                Seuraaja seuraaja = (Seuraaja) olio;
                seuraaja.liiku(pelaaja);
                if (tormaysObjektiin(seuraaja)) {
                    seuraaja.liikuTakaisin();
                }
            }
        }
    }

    public boolean tormaysObjektiin(Olio olio) {
        if (this.koordinaatinOliot(olio.getX(), olio.getY()).size() <= 1) {
            return false;
        } else {
            return true;
        }
//        Liiku -> tarkista oliko uudessa kohdassa objektia -> jos oli liiku takaisin
    }
}
