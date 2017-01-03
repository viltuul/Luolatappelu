/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import luolatappelu.peli.Peli;

/**
 *
 * @author ville
 */
public class Ruudukko extends JTextField {


    private Peli peli;

    public Ruudukko(Peli peli) {
        super("tässä tekstiä", 2);
        super.setBackground(Color.white);
        super.setBounds(840, 0, 460, 870);
        this.peli = peli;
    }

    @Override
    protected void paintComponent(Graphics grafiikka) {
        GridLayout asettelu = new GridLayout(1, 2);
        JPanel paneeli = new JPanel();
        paneeli.setLayout(asettelu);
        JTextField ylin = new JTextField(0+"asd");
        JTextField alin = new JTextField(0+"");
        ylin.setEnabled(false);
        alin.setEnabled(false);
    }
public void ylempi(){
    
}
public void alempi(JTextField teksti){
    
    
}
}
