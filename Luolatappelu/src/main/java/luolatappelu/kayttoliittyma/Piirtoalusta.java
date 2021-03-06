package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import luolatappelu.objektit.Olio;
import luolatappelu.objektit.Oviaukko;
import luolatappelu.objektit.Pelaaja;
import luolatappelu.peli.Peli;

/**
 * Piirtoalustassa luodaan kaikki pelin graafiset ominaisuudet.
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;
    private Graphics grafiikka;

    /**
     * Asetetaan piirtoalustalle harmaa taustaväri sekä asetetaan rajat.
     *
     * @param peli Peli kiinnitetään attribuuttiin.
     */
    public Piirtoalusta(Peli peli) {
        super.setBackground(Color.GRAY);
        this.peli = peli;
        super.setBounds(0, 0, 840, 870);
    }

    @Override
    public void paintComponent(Graphics grafiikka) {
        this.grafiikka = grafiikka;
        super.paintComponent(grafiikka);
        piirraPelaaja();
        piirraSeuraajat();
        piirraOrkit();
        piirraTankit();
        piirraSeinat();
        piirraOviaukko();
        piirraPuuseinat();
    }

    private void piirraPelaaja() {
        Pelaaja pelaaja = peli.getPelaaja();
        piirraVartalo(pelaaja, Color.BLUE);
        this.piirraNaama(pelaaja.getX(), pelaaja.getY(), false);
        piirraMiekka(pelaaja.getX() * 40, pelaaja.getY() * 40);
    }

    private void piirraSeuraajat() {
        for (Olio olio : peli.getOliokanta().getSeuraajat()) {
            piirraVartalo(olio, Color.RED);
            this.piirraNaama(olio.getX(), olio.getY(), true);
            piirraKeihas(olio.getX() * 40, olio.getY() * 40);
        }
    }

    private void piirraOrkit() {
        for (Olio olio : peli.getOliokanta().getOrkit()) {
            piirraVartalo(olio, Color.GREEN);
            this.piirraNaama(olio.getX(), olio.getY(), false);
            piirraMiekka(olio.getX() * 40, olio.getY() * 40);
        }
    }

    private void piirraTankit() {
        for (Olio olio : peli.getOliokanta().getTankit()) {
            piirraVartalo(olio, Color.YELLOW);
            this.piirraNaama(olio.getX(), olio.getY(), true);
            this.piirraKilpi(olio.getX() * 40, olio.getY() * 40);
        }
    }

    private void piirraVartalo(Olio olio, Color vari) {
        grafiikka.setColor(new Color(139, 69, 19));
        grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40 + 27, 12, 8);
        grafiikka.fillOval(olio.getX() * 40 + 20, olio.getY() * 40 + 27, 12, 8);
        grafiikka.setColor(vari);
        grafiikka.fillOval(olio.getX() * 40, olio.getY() * 40, 30, 30);
        grafiikka.fillOval(olio.getX() * 40 - 10, olio.getY() * 40 + 5, 15, 15);
        grafiikka.fillOval(olio.getX() * 40 + 20, olio.getY() * 40 + 5, 15, 15);
        grafiikka.setColor(Color.BLACK);
        grafiikka.drawOval(olio.getX() * 40, olio.getY() * 40, 30, 30);

    }

    private void piirraNaama(int x, int y, Boolean vihainen) {
        grafiikka.setColor(Color.BLACK);
        grafiikka.fillRect(x * 40 + 7, y * 40 + 7, 4, 12);
        grafiikka.fillRect(x * 40 + 18, y * 40 + 7, 4, 12);
        grafiikka.fillRect(x * 40 + 10, y * 40 + 23, 12, 4);
        grafiikka.fillRect(x * 40 + 8, y * 40 + 21, 4, 4);
        grafiikka.fillRect(x * 40 + 20, y * 40 + 21, 4, 4);
        if (vihainen) {
            grafiikka.fillRect(x * 40 + 5, y * 40 + 5, 4, 4);
            grafiikka.fillRect(x * 40 + 20, y * 40 + 5, 4, 4);
        }
    }

    private void piirraKeihas(int x, int y) {
        grafiikka.setColor(new Color(139, 69, 0));
        grafiikka.fillRect(x - 10, y + 5, 3, 30);
        grafiikka.setColor(Color.darkGray);
        grafiikka.fillOval(x - 11, y - 2, 5, 10);
    }

    private void piirraMiekka(int x, int y) {
        grafiikka.setColor(new Color(139, 69, 0));
        grafiikka.fill3DRect(x - 10, y + 8, 10, 6, true);
        grafiikka.setColor(Color.darkGray);
        grafiikka.fillOval(x - 8, y - 5, 5, 15);
    }

    private void piirraKilpi(int x, int y) {
        grafiikka.setColor(Color.darkGray);
        grafiikka.fillRect(x + 6, y + 13, 30, 15);
        grafiikka.setColor(Color.black);
        grafiikka.drawRect(x + 6, y + 13, 30, 15);
        grafiikka.setColor(Color.gray);
        grafiikka.fillOval(x + 6, y + 15, 30, 20);
        grafiikka.setColor(Color.BLACK);
        grafiikka.drawOval(x + 6, y + 15, 30, 20);
        grafiikka.setColor(Color.yellow);
        grafiikka.fillOval(x + 18, y + 18, 4, 4);
        grafiikka.fillOval(x + 24, y + 18, 4, 4);
        grafiikka.fillOval(x + 21, y + 24, 4, 4);

    }

    private void piirraSeinat() {
        for (Olio seina : peli.getTaso().getLuolasto().getSeinat()) {
            grafiikka.setColor(Color.black);
            grafiikka.fillRect(seina.getX() * 40, seina.getY() * 40, 40, 40);
            for (int i = 0; i < 4; i++) {
                grafiikka.setColor(Color.darkGray);
                grafiikka.fillOval(seina.getX() * 40, seina.getY() * 40 + (i * 10), 10, 5);
                grafiikka.fillOval(seina.getX() * 40 + 20, seina.getY() * 40 + (i * 10), 10, 5);
                grafiikka.fillOval(seina.getX() * 40 + 30, seina.getY() * 40 + (i * 10 + 5), 10, 5);
            }
        }
    }

    private void piirraOviaukko() {
        Oviaukko ovi = peli.getTaso().getOvi();
        if (peli.getTaso().isTasoLapi()) {
            grafiikka.setColor(Color.black);
        } else {
            grafiikka.setColor(Color.gray);
        }
        grafiikka.fillOval(ovi.getX() * 40, ovi.getY() * 40, 40, 40);

    }

    private void piirraPuuseinat() {
        for (Olio olio : peli.getOliokanta().getPuuseinat()) {
            grafiikka.setColor(new Color(210, 105, 30));
            grafiikka.fillRect(olio.getX() * 40, olio.getY() * 40, 40, 40);
        }
    }
}
