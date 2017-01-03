package luolatappelu.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.peli.Peli;

public class Kayttoliittyma implements Runnable {

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

    @Override
    public void run() {
        alku();
        frame = new JFrame("Luolatappelu");
        frame.setLayout(null);
        frame.setPreferredSize(new Dimension(1300, 870));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit();
        frame.pack();
        frame.setVisible(true);

    }

    public void luoKomponentit() {
//        container.add(ruudukko);
        frame.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(frame, peli);
        frame.addKeyListener(nk);
    }

    public void alku() {
        peli.sijoitaPelaaja();
        peli.sijoitaViholliset();
        peli.rakennaSeinat();
    }
}
