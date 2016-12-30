/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.kayttoliittyma;

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

    private Pelaaja pelaaja;
    private Peli peli;

    public Nappaimistonkuuntelija(Pelaaja pelaaja, Peli peli) {
        this.pelaaja = pelaaja;
        this.peli = peli;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.liiku(Suunta.YLOS);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.liiku(Suunta.ALAS);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.liiku(Suunta.OIKEA);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.liiku(Suunta.VASEN);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            peli.lyoNaapuria(peli.getPelaaja());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
