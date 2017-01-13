package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

/**
 * Ruudukko luokassa luodaan tekstiruudukko grafiikoiden viereen.
 */
public class Ruudukko extends JTextArea {

    private JScrollPane rulla;
    private JTextArea ylaruutu;
    private JTextArea pelaajanTiedot;
    private StringBuilder tuloste;

    /**
     * Asetetaan ruudukolle taustaväri ja rajat. Luodaan myös esillepano ja
     * lisätään tarvittavat komponentit siihen.
     */
    public Ruudukko() {
        super.setBounds(840, 0, 440, 870);
        super.setLayout(new GridLayout(2, 1));
        this.ylaruutu = new JTextArea();
        this.rulla = new JScrollPane(ylaruutu);
        super.add(rulla);
        
        rulla.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.pelaajanTiedot = new JTextArea();
        super.add(pelaajanTiedot);
        ylaruutu.setEnabled(false);
        pelaajanTiedot.setEnabled(false);
        ylaruutu.setBackground(Color.black);
        pelaajanTiedot.setBackground(Color.BLACK);

    }

    public void tekstinTuloste() {

    }

    /**
     * Kirjoittaa tapahtumien kuvauksen ikkunan oikeaan laitaan.
     *
     * @param teksti Peli luokka antaa tekstin.
     */
    public void kirjoitin(String teksti) {
        ylaruutu.setFont(new Font("Calibri", 3, 16));
        ylaruutu.setText(teksti);
    }

    /**
     * Kirjoittaa pelaajan tiedot ikkunan oikeaan laitaan.
     *
     * @param tiedot Peli luokka antaa tiedot.
     */
    public void pelaajanTiedot(String tiedot) {
        pelaajanTiedot.setFont(new Font("", 4, 20));
        pelaajanTiedot.setForeground(Color.green);
        pelaajanTiedot.setText(tiedot);
    }
}
