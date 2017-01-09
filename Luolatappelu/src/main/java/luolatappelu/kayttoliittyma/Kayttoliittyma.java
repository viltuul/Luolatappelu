package luolatappelu.kayttoliittyma;

import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import luolatappelu.peli.Peli;

/**
 * Kayttoliittyma on luokka, joka yhdistää graafisen ilmentymän pelille sekä
 * pelin kontrollit
 */
public class Kayttoliittyma implements Runnable {

    private Scanner lukija;
    private Peli peli;
    private Piirtoalusta alusta;
    private Ruudukko ruudukko;
    private JFrame peliIkkuna;
    private final JTextArea tuloste;

    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
        this.alusta = new Piirtoalusta(peli);
        this.tuloste = new JTextArea();
        this.ruudukko = new Ruudukko(peli);
    }

    /**
     * Metodi käynnistää pelin ja kokoaa ikkunan jossa pelaaminen tapahtuu.
     */
    @Override
    public void run() {
        peli.uusiTaso();
        peliIkkuna = new JFrame("Luolatappelu");
        peliIkkuna.setPreferredSize(new Dimension(1300, 870));
        peliIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();
        peliIkkuna.pack();
        peliIkkuna.setVisible(true);

    }

    /**
     * Metodissa luodaan ikkunan komponentit ja kiinnitetään siihen
     * Nappaimistonkuuntelija.
     */
    public void luoKomponentit() {
        peliIkkuna.add(ruudukko);
        ruudukko.setFocusable(false);
        peliIkkuna.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(peliIkkuna, peli);
        peliIkkuna.addKeyListener(nk);

    }

    /**
     * peliOhi metodi lopettaa pelin ja sulkee ikkunan.
     */
    public void peliOhi() {
        JOptionPane.showMessageDialog(null, "Kuolit, käynnistä peli uudestaan aloittaaksesi");
        peliIkkuna.dispose();
    }
}
