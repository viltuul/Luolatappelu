package luolatappelu.kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import luolatappelu.Suunta;
import luolatappelu.peli.Peli;

public class Nappaimistonkuuntelija implements KeyListener {

    private Component komponentti;
    private Peli peli;

    public Nappaimistonkuuntelija(Component komponentti, Peli peli) {
        this.komponentti = komponentti;
        this.peli = peli;
    }

    @Override
    public void keyPressed(KeyEvent painallus) {
        if (painallus.getKeyCode() == KeyEvent.VK_UP) {
            peli.getPelaaja().toimi(Suunta.YLOS);
        } else if (painallus.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.getPelaaja().toimi(Suunta.ALAS);
        } else if (painallus.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.getPelaaja().toimi(Suunta.OIKEA);
        } else if (painallus.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.getPelaaja().toimi(Suunta.VASEN);
        }
        peli.paivita();
        komponentti.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
