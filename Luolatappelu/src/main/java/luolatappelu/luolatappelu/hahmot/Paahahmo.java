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
        if (suunta.equals(suunta.ALAS)){
            super.setY(super.getY()+1);
        }
        if (suunta.equals(suunta.YLOS)){
            super.setY(super.getY()-1);
        }
        if (suunta.equals(suunta.VASEN)){
            super.setX(super.getX()-1);
        }
        if(suunta.equals(suunta.OIKEA)){
            super.setX(super.getX()+1);
        }
    }

}
