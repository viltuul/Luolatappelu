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
 * pelin kontrollit.
 */
public class Kayttoliittyma implements Runnable {

    private Scanner lukija;
    private Peli peli;
    private Piirtoalusta alusta;
    private Ruudukko ruudukko;
    private JFrame peliIkkuna;

    /**
     * Konstruktorissa luodaan Piirtoalusta sekä Ruudukko luokat.
     *
     */
    public Kayttoliittyma() {

        this.peli = new Peli(this);
        this.alusta = new Piirtoalusta(peli);
        this.ruudukko = new Ruudukko();
    }

    /**
     * Metodi luo sekä käynnistää pelin ja kokoaa ikkunan jossa pelaaminen
     * tapahtuu.
     */
    @Override
    public void run() {
        peli.uusiTaso();
        this.peliIkkuna = new JFrame("Luolatappelu");
        peliIkkuna.setPreferredSize(new Dimension(1300, 870));
        peliIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentitPeliin();
        peliIkkuna.pack();
        peliIkkuna.setVisible(true);
    }

    /**
     * Metodissa luodaan ikkunan komponentit ja kiinnitetään siihen
     * Nappaimistonkuuntelija.
     */
    public void luoKomponentitPeliin() {
        peliIkkuna.add(ruudukko);
        ruudukko.setFocusable(false);
        peliIkkuna.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(peliIkkuna, peli);
        peliIkkuna.addKeyListener(nk);
    }

    /**
     * peliOhi metodi lopettaa pelin ja avaa aloitusikkunan.
     */
    public void peliOhi() {
        JOptionPane.showMessageDialog(null, "Kuolit, peli alkaa alusta uudestaan");
        peliIkkuna.dispose();
        peli.nollaaKaikki();
        run();
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

}
