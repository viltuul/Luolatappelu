package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Orkki;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Seina;
import luolatappelu.hahmot.Seuraaja;
import luolatappelu.hahmot.Tankki;

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
            Seina seinaAla = new Seina(i, huone.getKorkeus());
            seinat.add(seinaAla);
            Seina seinaVas = new Seina(0, i);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(huone.getLeveys(), i);
            seinat.add(seinaOik);
        }
    }

    public void sijoitaViholliset() {
        Random random = new Random();
        for (Olio sijoitettava : oliot.getViholliset()) {
            sijoitettava.setX(random.nextInt(huone.getLeveys() - 2));
            sijoitettava.setY(random.nextInt(huone.getKorkeus() - 2));
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
        for (Seina seina : seinat) {
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
//        Liiku -> tarkista oliko uudessa kohdassa objektia -> jos oli liiku takaisin
    }

}
