package luolatappelu.luolatappelu.hahmot;

public class Paahahmo extends Olio implements Toimiva {

    public Paahahmo(String nimi) {
        super(nimi);
        super.setElamat(100);
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
    public void lyo(Olio olio) {
        olio.setElamat(olio.getElamat() - 1);
    }
}
