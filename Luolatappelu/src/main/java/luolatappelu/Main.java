package luolatappelu;

import javax.swing.SwingUtilities;
import luolatappelu.kayttoliittyma.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kl = new Kayttoliittyma();
        SwingUtilities.invokeLater(kl);
    }

}
