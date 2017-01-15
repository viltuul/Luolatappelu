package luolatappelu.objektit;

/**
 * Orkki on luokan olio aliluokka. Luokka Orkki sisältää orkeille ominaisen
 * liikkumistyylin.
 */
import java.util.Random;

public class Orkki extends Olio {

    private Random random;

    /**
     * Konstruktori asettaa Orkille Örkki nimen ja luo attribuuttina uuden
     * Random attribuutin.
     *
     * @param vaikeustaso jos vaikeustaso on 50 ja yli niin orkit ovat
     * voimakkaampia.
     */
    public Orkki(int vaikeustaso) {
        super("Örkki");
        this.random = new Random();
        if (vaikeustaso > 49) {
            super.setElamat(3);
            super.setOsumatarkkuus(0.9);
        }
    }

    /**
     * Konstruktori jossa voidaan tuoda halutunlainen Random parametri.
     * Konstruktori on tehty lähinnä testejä varten.
     *
     * @param random parametrina tuodaan esimerkiksi halutunlainen Random
     * muuttuja.
     */
    public Orkki(Random random) {
        super("Örkki");
        this.random = random;
    }

    /**
     * Liiku metodi liikuttaa oliota yhden askeleen verran satunnaisesti
     * arvottuun suuntaan.
     */
    @Override
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
