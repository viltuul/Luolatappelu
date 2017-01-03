package luolatappelu.hahmot;

import luolatappelu.Suunta;
import luolatappelu.peli.Peli;

public class Pelaaja extends Olio {

    private Peli peli;

    public Pelaaja(String nimi, Peli peli) {
        super(nimi);
        super.setElamat(10);
        this.peli = peli;
    }

    @Override
    public String toString() {
        return "@";
    }

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

    public void lyoTaiLiiku(int x, int y) {
        if (peli.koordinaatinOliot(x, y).size() == 0) {
            super.setX(x);
            super.setY(y);
        } else {
            super.lyo(peli.koordinaatinOliot(x, y).get(0));
        }
    }

}
