package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Orkki;
import luolatappelu.peli.Peli;
import luolatappelu.peli.Huone;

/**
 *
 * @author Ville
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;

    public Piirtoalusta(Peli peli) {
        super.setBackground(Color.gray);
        this.peli = peli;
    }

    @Override
    protected void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        Pelaaja pelaaja = peli.getPelaaja();
        grafiikka.setColor(Color.BLUE);
        grafiikka.fill3DRect(pelaaja.getX() * 40, pelaaja.getY() * 40, 40, 40, true);
        piirraSeuraajat(grafiikka);
        piirraOrkit(grafiikka);
    }

    public void piirraSeuraajat(Graphics grafiikka) {
        for (Olio olio : peli.getSeuraajat()) {
            grafiikka.setColor(Color.RED);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }

    public void piirraOrkit(Graphics grafiikka) {
        for (Olio olio : peli.getOrkit()) {
            grafiikka.setColor(Color.GREEN);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }
}
