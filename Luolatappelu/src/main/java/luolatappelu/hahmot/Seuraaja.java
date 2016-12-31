package luolatappelu.hahmot;

import java.util.Random;

public class Seuraaja extends Olio {

    public Seuraaja() {
        super("Seuraaja");
    }

    public int arvoSuunta() {
        Random arpoja = new Random();
        int arpa = arpoja.nextInt(1);
        return arpa;
    }

    public void liiku(Pelaaja pelaaja) {
        int x = pelaaja.getX();
        int y = pelaaja.getY();
        if (super.getX() == x) {
            liikuYAkseli(y);
        } else if (super.getY() == y) {
            liikuXAkseli(x);
        } else {
            if (arvoSuunta() == 0) {
                liikuYAkseli(y);
            } else {
                liikuXAkseli(x);
            }
        }
    }

    public void liikuXAkseli(int x) {
        if (super.getX() < x) {
            super.liiku(Suunta.OIKEA);
        } else if (super.getX() > x) {
            super.liiku(Suunta.VASEN);
        }
    }

    public void liikuYAkseli(int y) {
        if (super.getY() < y) {
            super.liiku(Suunta.ALAS);
        } else if (super.getY() > y) {
            super.liiku(Suunta.YLOS);
        }
    }
}
