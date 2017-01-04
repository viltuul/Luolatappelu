package luolatappelu.hahmot;

import luolatappelu.Suunta;
import java.util.Random;

/**
 * Seuraaja on luokan Olio aliluokka. Seuraaja sisältää seuraajalle ominaiset
 * liikkumismetodit.
 */
public class Seuraaja extends Olio {

    private Random arpoja;
    private Pelaaja pelaaja;

    public Seuraaja(Pelaaja pelaaja) {
        super("Seuraaja");
        this.arpoja = new Random();
        this.pelaaja = pelaaja;
    }

    /**
     * Toinen konstruktori luotu testejä varten
     *
     * @param pelaaja
     * @param random Tässä voidaan luoda halutunmukainen Random luokka
     */
    public Seuraaja(Pelaaja pelaaja, Random random) {
        super("Seuraaja");
        this.arpoja = random;
        this.pelaaja = pelaaja;
    }

    /**
     * Liiku metodi liikuttaa oliota pelaajan suuntaan. Jos pelaaja on samalla
     * koordinaattiakselilla, kutsutaan metodia liikuXAkseli tai liikuYAkseli.
     * Jos taas pelaaja on eri akselilla kuin seuraaja, niin metodi arpoo
     * seuraajan seuraavan liikkumissuunnan.
     */
    public void liiku() {
        int x = pelaaja.getX();
        int y = pelaaja.getY();
        if (super.getX() == x) {
            liikuYAkseli(y);
        } else if (super.getY() == y) {
            liikuXAkseli(x);
        } else if (arpoja.nextBoolean()) {
            liikuYAkseli(y);
        } else {
            liikuXAkseli(x);
        }
    }

    /**
     * Kun pelaaja ja seuraaja ovat y-akselilla niin tämä metodi liikuttaa
     * seuraajaa x akselia pitkin pelaajan suuntaan.
     *
     * @param x pelaajan x koordinaatti
     */
    private void liikuXAkseli(int x) {
        if (super.getX() < x) {
            super.liiku(Suunta.OIKEA);
        } else if (super.getX() > x) {
            super.liiku(Suunta.VASEN);
        }
    }

    /**
     * Kun pelaaja ja seuraaja ovat x-akselilla niin tämä metodi liikuttaa
     * seuraajaa y akselia pitkin pelaajan suuntaan.
     *
     * @param y pelaajan y koordinaatti
     */
    private void liikuYAkseli(int y) {
        if (super.getY() < y) {
            super.liiku(Suunta.ALAS);
        } else if (super.getY() > y) {
            super.liiku(Suunta.YLOS);
        }
    }

    @Override
    public String toString() {
        return "S";
    }
}
