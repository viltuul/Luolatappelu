/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

/**
 *
 * @author tuulio
 */
public class Olio {

    private String nimi;
    private int elamat;
    private int x;
    private int y;
    private boolean elossa;

    public Olio(String nimi) {
        this.nimi = nimi;
        this.elamat = 1;
        this.elossa = true;
    }

    public String getNimi() {
        return nimi;
    }

    public int getElamat() {
        return elamat;
    }

    public boolean isElossa() {
        return elossa;
    }

    public void setElamat(int elama) {
        this.elamat = elama;
        if (elamat == 0) {
            elossa = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public int[] getKoordinaatit() {
//        int[] koordinaatit = {x, y};
//        return koordinaatit;
//    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public boolean osuu(Olio olio) {
//        if (this.x == olio.getX() && this.y == olio.getY()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    @Override
    public String toString() {
        return this.nimi;
    }

    public void lyo(Olio lyotava) {
        lyotava.setElamat(lyotava.getElamat() - 1);
    }
}
