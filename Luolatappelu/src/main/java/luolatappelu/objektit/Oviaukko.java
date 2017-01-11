package luolatappelu.objektit;

/**
 * Oviaukko on objekti, josta pääsee seuraavalle tasolle. Luokka ei tunne muuta
 * kuin sijainnin.
 */
public class Oviaukko {

    private int x;
    private int y;
/**
 * Konstruktorissa sijoitetaan oviaukko.
 * @param x x koorinaatti
 * @param y y koordinaatti
 */
    public Oviaukko(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
