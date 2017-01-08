package luolatappelu.kayttoliittyma;

import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import luolatappelu.hahmot.Pelaaja;
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
    private JFrame frame;

    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
        this.alusta = new Piirtoalusta(peli);
        this.ruudukko = new Ruudukko(peli);
    }

    /**
     * Metodi käynnistää pelin ja kokoaa ikkunan jossa pelaaminen tapahtuu.
     */
    @Override
    public void run() {
        peli.uusiTaso();
        frame = new JFrame("Luolatappelu");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1300, 870));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodissa luodaan ikkunan komponentit ja kiinnitetään siihen
     * Nappaimistonkuuntelija.
     */
    public void luoKomponentit() {
//        container.add(ruudukko);
        frame.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(frame, peli);
        frame.addKeyListener(nk);
    }

    /**
     * peliOhi metodi lopettaa pelin ja sulkee ikkunan.
     */
    public void peliOhi() {
        JOptionPane.showMessageDialog(null, "Kuolit, käynnistä peli uudestaan aloittaaksesi");
    }
}
