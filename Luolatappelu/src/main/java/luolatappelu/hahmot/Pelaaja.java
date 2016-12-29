package luolatappelu.hahmot;

public class Pelaaja extends Olio implements Toimiva {

    public Pelaaja(String nimi) {
        super(nimi);
        super.setElamat(10);
    }

    @Override
    public void liiku(Suunta suunta) {
        if (suunta.equals(suunta.ALAS)) {
            super.setY(super.getY() + 1);
        }
        if (suunta.equals(suunta.YLOS)) {
            super.setY(super.getY() - 1);
        }
        if (suunta.equals(suunta.VASEN)) {
            super.setX(super.getX() - 1);
        }
        if (suunta.equals(suunta.OIKEA)) {
            super.setX(super.getX() + 1);
        }
    }

    @Override
    public String toString() {
        return "@";
    }
    @Override
    public void lyo(Olio olio){
        super.lyo(olio);
        System.out.println("Pelaaja löi");
    }

}
