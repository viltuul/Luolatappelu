package luolatappelu.peli;

import java.util.ArrayList;
import luolatappelu.hahmot.Olio;

public class Huone {

    private int leveys;
    private int korkeus;

    public Huone(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

}
