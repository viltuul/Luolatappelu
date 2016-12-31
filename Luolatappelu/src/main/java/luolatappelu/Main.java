
package luolatappelu;

import java.util.Scanner;
import luolatappelu.hahmot.Olio;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli();
        for (int i = 0;i<20;i++){
            peli.uusiOrkki();
        }
        for (int j = 0;j<10;j++){
            peli.uusiSeuraaja();
        }
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija,peli);
        kayttis.run();
    }
    
}
