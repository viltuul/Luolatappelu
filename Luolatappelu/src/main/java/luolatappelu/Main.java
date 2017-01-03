package luolatappelu;

import java.util.Scanner;
import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli();
        for (int i = 0; i < 20; i++) {
            peli.getOliokanta().uusiOrkki();
        }
        for (int j = 0; j < 10; j++) {
            peli.getOliokanta().uusiSeuraaja(peli.getPelaaja());
        }
        for (int j = 0; j < 5; j++) {
            peli.getOliokanta().uusiTankki();
        }
        Kayttoliittyma kayttis = new Kayttoliittyma(lukija, peli);
        kayttis.run();
    }

}
