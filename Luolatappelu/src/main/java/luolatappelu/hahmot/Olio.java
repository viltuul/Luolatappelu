package luolatappelu.hahmot;

import java.util.Random;
import luolatappelu.Suunta;

/**
 * Luokka on kaikkien olioluokkien yliluokka.
 */
public class Olio {

    private String nimi;
    private int elamat;
    private int x;
    private int y;
    private boolean elossa;
    private Suunta viimeinenSuunta;
    private double osumatarkkuus;

    public Olio(String nimi) {
        this.nimi = nimi;
        this.elamat = 1;
        this.elossa = true;
        this.x = 0;
        this.y = 0;
        this.osumatarkkuus = 0.5;
    }

    public String getNimi() {
        return nimi;
    }

    public int getElamat() {
        return elamat;
    }

    /**
     * Tarkistaa olion elämät ja palauttaa totuusarvon sen mukaisesti.
     *
     * @return true jos olio on elossa
     */
    public boolean isElossa() {
        if (elamat <= 0) {
            elossa = false;
        }
        return elossa;
    }

    public void vahennaElamaa() {
        this.elamat--;
    }

    public void setElamat(int elama) {
        this.elamat = elama;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metodi liikuttaa oliota muuttamalla sen x tai y koordinaattia. Metodi
     * myös tallentaa viimeisen liikkumissuunnan.
     *
     * @param suunta Suunta johon olio liikkuu
     */
    public void liiku(Suunta suunta) {
        this.viimeinenSuunta = suunta;
        if (suunta.equals(suunta.ALAS)) {
            y++;
        } else if (suunta.equals(suunta.YLOS)) {
            y--;
        } else if (suunta.equals(suunta.VASEN)) {
            x--;
        } else if (suunta.equals(suunta.OIKEA)) {
            x++;
        }
    }

    /**
     * Jos olio törmääkin toiseen olioon niin liikutetaan Olio takaisin siihen
     * kohtaan mistä se lähti alunperin.
     */
    public void liikuTakaisin() {
        if (viimeinenSuunta.equals(Suunta.ALAS)) {
            y--;
        } else if (viimeinenSuunta.equals(Suunta.YLOS)) {
            y++;
        } else if (viimeinenSuunta.equals(Suunta.VASEN)) {
            x++;
        } else if (viimeinenSuunta.equals(Suunta.OIKEA)) {
            x--;
        }
    }

    /**
     * Metodi käskee oliota lyömään toista oliota jolloin lyötävän elämät
     * vähenee. Lyönti osuu, jos satunnaismuuttuja on pienempi, kuin olion
     * osumatarkkuus.
     *
     * @param lyotava kertoo Oliolle mitä oliota tulee lyödä.
     */
    public void lyo(Olio lyotava) {
        if (lyotava != null) {
            Random osuuko = new Random();
            if (osuuko.nextDouble() > osumatarkkuus) {
                System.out.println(this.getNimi() + " ei osunut olioon " + lyotava.getNimi());
            } else {
                lyotava.vahennaElamaa();
                System.out.println(this.getNimi() + " osui olioon " + lyotava.getNimi());
            }
        }
    }

    public double getOsumatarkkuus() {
        return osumatarkkuus;
    }

    public void setOsumatarkkuus(double osumatarkkuus) {
        this.osumatarkkuus = osumatarkkuus;
    }

}
