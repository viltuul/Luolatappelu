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
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 30, 40);
            this.piirraNaama(grafiikka, olio.getX(), olio.getY());
        }
    }

    public void piirraOrkit(Graphics grafiikka) {
        for (Olio olio : peli.getOliokanta().getOrkit()) {
            grafiikka.setColor(Color.GREEN);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 30, 30);
            grafiikka.fillOval(olio.getX() * 40 - 10, olio.getY() * 40, 20, 20);
            grafiikka.fillOval(olio.getX() * 40 + 20, olio.getY() * 40, 20, 20);
            this.piirraNaama(grafiikka, olio.getX(), olio.getY());
        }
    }

    public void piirraTankit(Graphics grafiikka) {
        for (Olio olio : peli.getOliokanta().getTankit()) {
            grafiikka.setColor(Color.YELLOW);
            grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 30, 30);
            grafiikka.fillOval(olio.getX() * 40 - 10, olio.getY() * 40, 20, 20);
            grafiikka.fillOval(olio.getX() * 40 + 20, olio.getY() * 40, 20, 20);
            this.piirraNaama(grafiikka, olio.getX(), olio.getY());
        }
    }

    public void piirraNaama(Graphics grafiikka, int x, int y) {
        grafiikka.setColor(Color.BLACK);
        grafiikka.fillRect(x * 40 + 7, y * 40 + 7, 4, 12);
        grafiikka.fillRect(x * 40 + 18, y * 40 + 7, 4, 12);
        grafiikka.fillRect(x * 40 + 5, y * 40 + 5, 4, 4);
        grafiikka.fillRect(x * 40 + 20, y * 40 + 5, 4, 4);

        grafiikka.fillRect(x * 40 + 10, y * 40 + 23, 12, 4);
        grafiikka.fillRect(x * 40 + 8, y * 40 + 21, 4, 4);
        grafiikka.fillRect(x * 40 + 20, y * 40 + 21, 4, 4);
    }

    public void piirraSeinat(Graphics grafiikka) {
        for (Olio seina : peli.getSeina()) {
            grafiikka.setColor(Color.BLACK);
            grafiikka.fill3DRect(seina.getX() * 40, seina.getY() * 40, 20, 20, true);
            grafiikka.fill3DRect(seina.getX() * 40 + 20, seina.getY() * 40 + 20, 20, 20, true);
            grafiikka.setColor(Color.ORANGE);
            grafiikka.fill3DRect(seina.getX() * 40 + 20, seina.getY() * 40, 20, 20, true);
            grafiikka.fill3DRect(seina.getX() * 40, seina.getY() * 40 + 20, 20, 20, true);
        }
    }
}
