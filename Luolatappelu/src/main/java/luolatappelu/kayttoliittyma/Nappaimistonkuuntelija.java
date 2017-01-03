/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import luolatappelu.hahmot.Pelaaja;
import luolatappelu.hahmot.Suunta;
import luolatappelu.peli.Peli;

/**
 *
 * @author Ville
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Component komponentti;
    private Peli peli;

    public Nappaimistonkuuntelija(Component komponentti, Peli peli) {
        this.komponentti = komponentti;
        this.peli = peli;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            peli.getPelaaja().liiku(Suunta.YLOS);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.getPelaaja().liiku(Suunta.ALAS);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.getPelaaja().liiku(Suunta.OIKEA);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.getPelaaja().liiku(Suunta.VASEN);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            peli.lyoNaapuria(peli.getPelaaja());
        }
        peli.liikutaOlioita();
        peli.poistaKuolleet();
        komponentti.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
