package luolatappelu.objektit;

/**
 * Puuseina on objekti joka ei liiku ja sillä on 2 elämää.
 *
 * @author ville
 */
public class Puuseina extends Olio {

    /**
     * Konstruktori luo Puuseinä nimisen olion ja asettaa sille 2 elämää.
     */
    public Puuseina() {
        super("Puuseinä");
        super.setElamat(2);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean lyo(Olio lyotava) {
        return false;
    }

    @Override
    public void liikuTakaisin() {

    }

}
