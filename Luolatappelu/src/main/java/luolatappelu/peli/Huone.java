package luolatappelu.peli;

import java.util.Random;

public class Huone {

    private int leveys;
    private int korkeus;

    public Huone() {
        Random random = new Random();
        this.leveys = random.nextInt(9) + 12;
        this.korkeus = 20;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

}
