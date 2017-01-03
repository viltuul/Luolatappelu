package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import luolatappelu.hahmot.Olio;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.peli.Peli;

/**
 *
 * @author Ville
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;

    public Piirtoalusta(Peli peli) {
        super.setBackground(Color.GRAY);
        this.peli = peli;
        super.setBounds(0, 0, 840, 870);
    }

    @Override
    protected void paintComponent(Graphics grafiikka) {
        super.paintComponent(grafiikka);
        Pelaaja pelaaja = peli.getPelaaja();
        grafiikka.setColor(Color.BLUE);
        grafiikka.fill3DRect(pelaaja.getX() * 40, pelaaja.getY() * 40, 40, 40, true);
        piirraSeuraajat(grafiikka);
        piirraOrkit(grafiikka);
        piirraTankit(grafiikka);
        piirraSeinat(grafiikka);
    }

    public void piirraSeuraajat(Graphics grafiikka) {
        for (Olio olio : peli.getOliokanta().getSeuraajat()) {
            grafiikka.setColor(Color.RED);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }

    public void piirraOrkit(Graphics grafiikka) {
        for (Olio olio : peli.getOliokanta().getOrkit()) {
            grafiikka.setColor(Color.GREEN);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }

    public void piirraTankit(Graphics grafiikka) {
        for (Olio olio : peli.getOliokanta().getTankit()) {
            grafiikka.setColor(Color.YELLOW);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }

    public void piirraSeinat(Graphics grafiikka) {
        for (Olio seina : peli.getSeina()) {
            grafiikka.setColor(Color.BLACK);
            grafiikka.fill3DRect(seina.getX() * 40, seina.getY() * 40, 40, 40, true);
        }
    }
}
