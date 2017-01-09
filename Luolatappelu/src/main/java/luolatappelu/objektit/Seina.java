package luolatappelu.objektit;

/**
 * Seina on luokan olio aliluokka. Seina sisaltaa vain konstruktorin jossa
 * määritellään seinan sijainti.
 */
public class Seina extends Olio {

    public Seina(int x, int y) {
        super("Seinä");
        super.setX(x);
        super.setY(y);
    }

}
