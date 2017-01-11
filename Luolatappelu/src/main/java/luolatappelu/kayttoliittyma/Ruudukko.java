package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Ruudukko luokassa luodaan tekstiruudukko grafiikoiden viereen.
 */
public class Ruudukko extends JTextArea {

    private JTextPane tuloste;
    private JTextArea pelaajanTiedot;

    /**
     * Asetetaan ruudukolle taustaväri ja rajat. Luodaan myös esillepano ja
     * lisätään tarvittavat komponentit siihen.
     */
    public Ruudukko() {
        super.setBackground(Color.white);
        super.setBounds(840, 0, 460, 870);
        super.setLayout(new GridLayout(2, 1));
        this.tuloste = new JTextPane();
        this.pelaajanTiedot = new JTextArea();
        super.add(tuloste);
        super.add(pelaajanTiedot);
        tuloste.setEnabled(false);
        pelaajanTiedot.setEnabled(false);
    }

    /**
     * Kirjoittaa tapahtumien kuvauksen ikkunan oikeaan laitaan.
     *
     * @param teksti Peli luokka antaa tekstin.
     */
    public void kirjoitin(String teksti) {
        tuloste.setFont(new Font("Calibri", 3, 20));
        tuloste.setText(teksti);
    }

    /**
     * Kirjoittaa pelaajan tiedot ikkunan oikeaan laitaan.
     *
     * @param tiedot Peli luokka antaa tiedot.
     */
    public void pelaajanTiedot(String tiedot) {
        pelaajanTiedot.setFont(new Font("", 4, 20));
        pelaajanTiedot.setText(tiedot);
    }
}
