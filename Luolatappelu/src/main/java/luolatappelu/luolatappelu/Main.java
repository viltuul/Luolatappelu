/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu;

import java.util.Scanner;
import luolatappelu.luolatappelu.hahmot.Olio;
import luolatappelu.luolatappelu.peli.Peli;

/**
 *
 * @author tuulio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        UI peli = new UI(lukija);
        peli.run();
    }
    
}
