package luolatappelu.objektit;

import java.util.Random;

/**
 * Tankki on luokan Olio aliluokka. Tankki sisältää tankille ominaiset
 * liikkumismetodit.
 */
public class Tankki extends Olio {

    private Random random;
    private Boolean lepo;

    /**
     * Konstruktorissa asetetaan oliolle kolme elämää sekä asetetaan parempi
     * osumistarkkuus kuin muilla olioilla.
     */
    public Tankki() {
        super("Tankki");
        this.random = new Random();
        this.lepo = true;
        super.setElamat(3);
        super.setOsumatarkkuus(0.8);
    }

    /**
     * Metodi käskee tankin liikkua jos se ei ole liikkunut tai lyönyt
     * viimevuorolla.
     */
    @Override
    public void liiku() {
        if (lepo) {
            lepo = false;
            super.liiku(valitseSuunta(random.nextInt(4)));
        } else {
            lepo = true;
        }
    }

    /**
     * Metodi käskee tankin lyoda jos se ei ole lyönyt tai liikkunut
     * viimevuorolla.
     */
    @Override
    public boolean lyo(Olio lyotava) {
        if (lepo == true) {
            lepo = false;
            super.lyo(lyotava);
            return true;
        } else {
            lepo = true;
            return false;
        }

    }

    private Suunta valitseSuunta(int nro) {
        if (nro == 1) {
            return Suunta.ALAS;
        } else if (nro == 2) {
            return Suunta.YLOS;
        } else if (nro == 3) {
            return Suunta.VASEN;
        } else if (nro == 0) {
            return Suunta.OIKEA;
        }
        return null;
    }

    @Override
    public String toString() {
        return "T";
    }
}
