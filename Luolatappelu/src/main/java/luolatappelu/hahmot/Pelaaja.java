package luolatappelu.hahmot;

public class Pelaaja extends Olio {

    public Pelaaja(String nimi) {
        super(nimi);
        super.setElamat(10);
    }

    @Override
    public String toString() {
        return "@";
    }

}
