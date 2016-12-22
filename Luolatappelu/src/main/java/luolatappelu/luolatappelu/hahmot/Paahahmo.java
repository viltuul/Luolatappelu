/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu.hahmot;

import luolatappelu.luolatappelu.hahmot.Olio;
import luolatappelu.luolatappelu.hahmot.Liikkuva;

/**
 *
 * @author tuulio
 */
public class Paahahmo extends Olio implements Liikkuva {

    public Paahahmo(String nimi) {
        super(nimi);
    }

    @Override
    public void liiku(Suunta suunta) {
        super.setX(0);
        super.setY(0);
    }

}
