package luolatappelu.peli;


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
