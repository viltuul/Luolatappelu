
package luolatappelu;

import java.util.Scanner;
import luolatappelu.hahmot.Olio;
import luolatappelu.kayttoliittyma.UI;
import luolatappelu.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli();
//        for (int i = 0;i<20;i++){
//            peli.uusiOrkki();
//        }
        for (int j = 0;j<399;j++){
            peli.uusiSeuraaja();
        }
        UI kayttis = new UI(lukija,peli);
        kayttis.run();
    }
    
}
