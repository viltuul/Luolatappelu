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
public class Orkki extends Olio {

    public Orkki() {
        super("Örkki");
    }

    public Suunta arvoSuunta() {
        Random random = new Random();
        int nro = random.nextInt(4);
        if (nro == 1) {
            return Suunta.ALAS;
        }
        if (nro == 2) {
            return Suunta.YLOS;
        }
        if (nro == 3) {
            return Suunta.VASEN;
        }
        if (nro == 0) {
            return Suunta.OIKEA;
        }
        return null;
    }

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
        return "Ö";
    }

    @Override
    public void lyo(Olio olio) {
        super.lyo(olio);
        System.out.println("Vihu löi");
    }

}
