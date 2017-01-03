/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextField;
import luolatappelu.peli.Peli;

/**
 *
 * @author ville
 */
public class Ruudukko extends JPanel {

    private Peli peli;

    public Ruudukko(Peli peli) {
        super.setBackground(Color.WHITE);
        super.setBounds(840, 0, 460, 870);
        this.peli = peli;
    }

    public JPanel toPanel() {
        GridLayout asettelu = new GridLayout(1, 2);
        JPanel paneeli = new JPanel(asettelu);
        JTextField ylin = new JTextField("asd");
        JTextField alin = new JTextField("dsa");
        ylin.setEnabled(false);
        alin.setEnabled(false);
        return paneeli;
    }
}
