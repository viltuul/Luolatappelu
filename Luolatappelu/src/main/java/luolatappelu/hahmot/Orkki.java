package luolatappelu.hahmot;

/**
 * Orkki on luokan olio aliluokka. Luokka Orkki sisältää orkeille ominaisen
 * liikkumistyylin.
 */
import luolatappelu.Suunta;
import java.util.Random;

public class Orkki extends Olio {

    private Random random;

    public Orkki() {
        super("Örkki");
        this.random = new Random();
    }

    public Orkki(Random random) {
        super("Örkki");
        this.random = random;
    }

    /**
     * Liiku metodi liikuttaa oliota yhden askeleen verran satunnaisesti
     * arvottuun suuntaan
     */
    public void liiku() {
        super.liiku(valitseSuunta(random.nextInt(4)));
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
        return "Ö";
    }
}
