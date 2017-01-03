package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import luolatappelu.peli.Peli;

public class Ruudukko extends JTextArea {

    private Peli peli;

    public Ruudukko(Peli peli) {
        super();
        super.setBackground(Color.white);
        super.setBounds(840, 0, 460, 870);
        this.peli = peli;
    }

    @Override
    protected void paintComponent(Graphics grafiikka) {

    }

    public void ylempi() {

    }

    public void alempi(JTextField teksti) {

    }
}
