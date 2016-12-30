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
public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;

    public Piirtoalusta(Peli peli) {
        super.setBackground(Color.gray);
        this.peli = peli;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Pelaaja pelaaja = peli.getPelaaja();
        g.setColor(Color.BLUE);
        g.fill3DRect(pelaaja.getX() * 40, pelaaja.getY() * 40, 40, 40, true);

        for (Orkki orkki : peli.getOrkit()) {
            g.setColor(Color.GREEN);
            g.fillOval(orkki.getX() * 40, orkki.getY() * 40, 40, 40);
        }
    }

    @Override
    public void paivita() {
        repaint();
    }
}
