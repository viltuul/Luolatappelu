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

    public void liiku() {
        super.liiku(this.arvoSuunta());
    }

    @Override
    public String toString() {
        return "Ö";
    }
}
