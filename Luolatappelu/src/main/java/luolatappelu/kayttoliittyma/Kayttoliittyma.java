/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.kayttoliittyma;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Suunta;
import luolatappelu.peli.Peli;

/**
 *
 * @author ville
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private Peli peli;
    private Pelaaja pelaaja;
    private Piirtoalusta alusta;
    private Ruudukko ruudukko;
    private JFrame frame;

    public Kayttoliittyma(Scanner lukija, Peli peli) {
        this.lukija = lukija;
        this.peli = peli;
        this.pelaaja = peli.getPelaaja();
        this.alusta = new Piirtoalusta(peli);
        this.ruudukko = new Ruudukko(peli);
    }

    public void run() {
        alku();
        frame = new JFrame("Luolatappelu");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1300, 870));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void luoKomponentit(Container container) {
        container.add(alusta);
        container.add(ruudukko);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(frame, peli);
        frame.addKeyListener(nk);
    }

    public void alku() {
        peli.sijoitaPelaaja();
        peli.sijoitaViholliset();
        peli.rakennaSeinat();
    }

    public JFrame getFrame() {
        return frame;
    }

}
