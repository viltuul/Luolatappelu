    package luolatappelu.kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import luolatappelu.objektit.Suunta;
import luolatappelu.objektit.Pelaaja;
import luolatappelu.peli.Peli;

/**
 * Nappaimistonkuuntelija on luokka joka tunnistaa pelaajan painamat komennot,
 * kutsuu Peli luokkaa paivittamaan pelin tilanteen sekä päivittää myös
 * grafiikat.
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Component komponentti;
    private Peli peli;
    private Pelaaja pelaaja;

    /**
     * Konstruktorissa tuodaan komponentti sekä peli ja kiinnitetään ne luokan
     * attribuutteihin.
     *
     * @param komponentti JFrame ikkuna jossa peli on.
     * @param peli peli jota pelataan.
     */
    public Nappaimistonkuuntelija(Component komponentti, Peli peli) {
        this.komponentti = komponentti;
        this.peli = peli;
        this.pelaaja = peli.getPelaaja();
    }

    /**
     * Käyttäjä painaa nappulaa jonka jälkeen Pelaajaolio ja kaikki muut
     * liikkuvat oliot liikkuu ja kuvaruutu piirretään uusiksi.
     *
     * @param painallus Käyttämän tekemä toiminto
     */
    @Override
    public void keyPressed(KeyEvent painallus) {
        if (painallus.getKeyCode() == KeyEvent.VK_UP) {
            pelaaja.toimi(Suunta.YLOS);
        } else if (painallus.getKeyCode() == KeyEvent.VK_DOWN) {
            pelaaja.toimi(Suunta.ALAS);
        } else if (painallus.getKeyCode() == KeyEvent.VK_RIGHT) {
            pelaaja.toimi(Suunta.OIKEA);
        } else if (painallus.getKeyCode() == KeyEvent.VK_LEFT) {
            pelaaja.toimi(Suunta.VASEN);
        } else if (peli.getTaso().getOvi().getX() == pelaaja.getX()
                && peli.getTaso().getOvi().getY() == pelaaja.getY() || pelaaja.getNimi().equalsIgnoreCase("SuperPelaaja")) {
            if (painallus.getKeyCode() == KeyEvent.VK_SPACE) {
                peli.uusiTaso();
            }
        }
        komponentti.repaint();
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
