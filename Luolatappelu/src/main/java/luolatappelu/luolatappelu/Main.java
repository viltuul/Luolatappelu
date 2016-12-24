/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu;

import luolatappelu.luolatappelu.hahmot.Olio;
import luolatappelu.luolatappelu.kayttoliittyma.Peli;

/**
 *
 * @author tuulio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Peli kl = new Peli();
        kl.uusiHuone();
        System.out.println("asdf");
        kl.getHuoneet();
    }
    
}
