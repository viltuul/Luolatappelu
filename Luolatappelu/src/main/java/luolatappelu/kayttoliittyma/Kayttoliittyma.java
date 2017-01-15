package luolatappelu.kayttoliittyma;

import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
     * Konstruktorissa luodaan Peli, Piirtoalusta sekä Ruudukko luokat.
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
        kirjoitaNimiIkkuna();
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
     * Metodi kysyy käyttäjältä nimeä, jonka jälkeen asettaa sen pelaajan
     * nimeksi.
     */
    public void kirjoitaNimiIkkuna() {
        String nimi = JOptionPane.showInputDialog(peliIkkuna, "Kirjoita nimesi");
        if (nimi != null) {
            if (!nimi.isEmpty()) {
                peli.getPelaaja().setNimi(nimi);
            }
        } else {
            peli.getPelaaja().setNimi("Pelaaja");
        }
    }

    /**
     * Kun taso päästään läpi niin pelaaja kehittyy ja näytölle ponnahtaa
     * huomautusikkuna jossa pyydetään pelaajaa valitsemaan haluamansa
     * kehityskohde.
     */
    public void kehitysIkkuna() {
        Object[] vaihtoehdot = {"Elämiä", "Parantuvuutta", "Osumistarkkuutta"};
        int vaihtoehtoNro = JOptionPane.showOptionDialog(peliIkkuna,
                "Valitse yksi",
                "Kehityit",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                vaihtoehdot,
                vaihtoehdot[0]);

        if (vaihtoehtoNro == 2) {
            peli.getPelaaja().kehitaOsumistarkkuutta();
        } else if (vaihtoehtoNro == 1) {
            peli.getPelaaja().kasvataParannusta();
        } else {
            peli.getPelaaja().kasvataMaksimia();
        }
    }

    /**
     * peliOhi metodi lopettaa pelin ja aloittaa sen alusta.
     */
    public void peliOhi() {
        JOptionPane.showMessageDialog(null, "Kuolit, peli alkaa alusta uudestaan");
        peliIkkuna.dispose();
        peli.nollaaKaikki();
        run();
    }

    /**
     * Metodi ilmoittaa pelin olevan läpipelattu ja sammuttaa pelin.
     */
    public void peliLapi() {
        JOptionPane.showMessageDialog(null, "Pääsit pelin läpi, mene nyt ulos leikkimään!");
        peliIkkuna.dispose();
    }

    public Ruudukko getRuudukko() {
        return ruudukko;
    }

}
