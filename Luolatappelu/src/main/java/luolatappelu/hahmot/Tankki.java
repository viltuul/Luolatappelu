/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

import java.util.Random;

/**
 *
 * @author ville
 */
public class Tankki extends Olio {

    private Random random;
    private Boolean lepo;

    public Tankki() {
        super("Tankki");
        this.random = new Random();
        this.lepo = true;
        super.setElamat(3);
    }

    public Suunta valitseSuunta(int nro) {
        if (nro == 1) {
            return Suunta.ALAS;
        } else if (nro == 2) {
            return Suunta.YLOS;
        } else if (nro == 3) {
            return Suunta.VASEN;
        } else if (nro == 0) {
            return Suunta.OIKEA;
        }
        return null;
    }

    public void liiku() {
        if (lepo) {
            lepo = false;
            super.liiku(valitseSuunta(random.nextInt(4)));
        } else {
            lepo = true;
        }
    }

    @Override
    public String toString() {
        return "T";
    }

}
