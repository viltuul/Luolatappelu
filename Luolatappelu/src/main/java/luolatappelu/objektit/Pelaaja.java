package luolatappelu.objektit;

import luolatappelu.peli.Peli;

/**
 * Pelaaja on luokan olio aliluokka. Pelaaja luokassa on pelaajan liikkumiseen
 * vaadittavat metodit.
 */
public class Pelaaja extends Olio {

    private Peli peli;
    private int maksimiElamat;
    private int parannus;

    /**
     * Konstruktorissa asetetaan pelaajalle haluttu nimi, ja maksimielämät.
     *
     * @param nimi pelaajan nimi.
     * @param peli peli jossa pelaaja on.
     */
    public Pelaaja(Peli peli) {
        super("Pelaaja");
        this.peli = peli;
        this.maksimiElamat = 10;
        this.parannus = 3;
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

    public void setMaksimiElamat(int maksimiElamat) {
        this.maksimiElamat = maksimiElamat;
    }

    /**
     * Metodi kasvattaa maksimielämiä yhdellä.
     */
    public void kasvataMaksimia() {
        maksimiElamat++;
    }

    /**
     * Metodi parantaa pelaajaa parannuksen verran.
     */
    public void parannaPelaajaa() {
        this.setElamat(super.getElamat() + parannus);
    }

    /**
     * Metodi kasvattaa parannusta.
     */
    public void kasvataParannusta() {
        parannus++;
    }

    public int getParannus() {
        return parannus;
    }

    public void setParannus(int arvo) {
        parannus = arvo;
    }

    /**
     * Metodi parantaa pelaajan osumistarkkuutta.
     */
    public void kehitaOsumistarkkuuttak() {
        super.setOsumatarkkuus(super.getOsumatarkkuus() + 0.05);
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
        } else if (super.lyo(peli.koordinaatinOliot(x, y).get(0))) {
            
        } else {

        }
    }

}
