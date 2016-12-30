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
public class UI {

    private Scanner lukija;
    private Peli peli;
    private Pelaaja pelaaja;
    private Nappaimistonkuuntelija kuuntelija;
    private Piirtoalusta alusta;
    private JFrame frame;

    public UI(Scanner lukija) {
        this.lukija = lukija;
        this.peli = new Peli();
        this.pelaaja = peli.getPelaaja();
        this.alusta = new Piirtoalusta(peli);
    }

    public void run() {
        alku();
        frame = new JFrame("Matopeli");
        int leveys = (peli.getHuone().getLeveys() * 40+30);
        int korkeus = (peli.getHuone().getKorkeus()* 40+30);

        frame.setPreferredSize(new Dimension(leveys, korkeus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

//        pelaaminen();
    }

    public void luoKomponentit(Container container) {
        container.add(alusta);
        Nappaimistonkuuntelija nk = new Nappaimistonkuuntelija(frame, peli);
        frame.addKeyListener(nk);
    }

    public void alku() {
        peli.sijoitaPelaaja();
        for (int i = 0; i < 20; i++) {
            peli.uusiOrkki();
        }
        peli.sijoitaOrkit();
//        peli.tulostaHuone();
    }

    public void pelaaminen() {
        while (true) {
            System.out.println("Pelaajan vuoro, toimi");
            toimintoPelaajalla();
            System.out.println("Vihujen vuoro, paina enter");
            peli.liikutaOlioita();
            alusta.paivita();
            if (!peli.getPelaaja().isElossa()) {
                System.out.println("hävisit!");
                break;
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public Paivitettava getPaivitettava() {
        return alusta;
    }

    public void toimintoPelaajalla() {
        System.out.println(peli.getPelaaja().getElamat());
        frame.addKeyListener(kuuntelija);
        peli.poistaKuolleet();
//        peli.tulostaHuone();
    }

}
