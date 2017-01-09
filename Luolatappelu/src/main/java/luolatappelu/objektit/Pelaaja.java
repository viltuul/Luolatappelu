package luolatappelu.objektit;

import luolatappelu.Suunta;
import luolatappelu.peli.Peli;

/**
 * Pelaaja on luokan olio aliluokka. Pelaaja luokassa on pelaajan liikkumiseen
 * vaadittavat metodit.
 */
public class Pelaaja extends Olio {

    private Peli peli;
    private int maksimiElamat;

    public Pelaaja(String nimi, Peli peli) {
        super(nimi);
        this.peli = peli;
        this.maksimiElamat = 9;
        super.setElamat(maksimiElamat);
    }

    @Override
    public void setElamat(int elama) {
        if (elama > maksimiElamat) {
            super.setElamat(maksimiElamat);
        } else {
            super.setElamat(elama);
        }
    }

    public int getMaksimiElamat() {
        return maksimiElamat;
    }

    public void kasvataMaksimia() {
        maksimiElamat++;
    }

    public void setMaksimiElamat(int maksimiElamat) {
        this.maksimiElamat = maksimiElamat;
    }

    @Override
    public String toString() {
        return "@";
    }

    /**
     * Pelaaja toteuttaa metodin lyoTaiLiiku koordinaateilla jotka ovat yhden
     * askeleen päästä pelaajasta.
     *
     * @param suunta Toiminnan suunta pelaajasta katsottuna.
     */
    public void toimi(Suunta suunta) {
        if (suunta.equals(suunta.ALAS)) {
            lyoTaiLiiku(super.getX(), super.getY() + 1);
        } else if (suunta.equals(suunta.YLOS)) {
            lyoTaiLiiku(super.getX(), super.getY() - 1);
        } else if (suunta.equals(suunta.VASEN)) {
            lyoTaiLiiku(super.getX() - 1, super.getY());
        } else if (suunta.equals(suunta.OIKEA)) {
            lyoTaiLiiku(super.getX() + 1, super.getY());
        }
    }

    /**
     * Metodi tarkistaa onko annetussa koordinaatissa toista oliota. Jos siinä
     * on jokin toinen olio, niin pelaaja lyö, jos ei niin pelaaja liikkuu.
     *
     * @param x koordinaatti
     * @param y koordinaatti
     */
    public void lyoTaiLiiku(int x, int y) {
        if (peli.koordinaatinOliot(x, y).isEmpty()) {
            super.setX(x);
            super.setY(y);
        } else {
            super.lyo(peli.koordinaatinOliot(x, y).get(0));
        }
    }

}
