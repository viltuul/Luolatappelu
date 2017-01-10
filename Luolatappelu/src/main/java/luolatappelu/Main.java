package luolatappelu;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import luolatappelu.peli.Peli;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Peli peli = new Peli();
        SwingUtilities.invokeLater(peli.getKayttoliittyma());
    }

}
