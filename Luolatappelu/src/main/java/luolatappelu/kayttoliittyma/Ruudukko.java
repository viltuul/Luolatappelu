package luolatappelu.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import static java.lang.System.out;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import luolatappelu.peli.Peli;

/**
 * Ruudukko luokassa luodaan tekstiruudukko grafiikoiden viereen.
 */
public class Ruudukko extends JTextArea {

    private JTextArea tuloste;
    private JTextArea pelaajanTiedot;
    

    public Ruudukko() {
        super.setBackground(Color.white);
        super.setBounds(840, 0, 460, 870);
        super.setLayout(new GridLayout(2,1));
        this.tuloste = new JTextArea();
        this.pelaajanTiedot = new JTextArea();
        super.add(tuloste);
        super.add(pelaajanTiedot);
        tuloste.setEnabled(false);
        pelaajanTiedot.setEnabled(false);
    }

    public void kirjoitin(String teksti) {
        tuloste.setText(teksti);
    }
    public void pelaajanTiedot(String tiedot){
        pelaajanTiedot.setText(tiedot);
    }
}
