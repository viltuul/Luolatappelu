package luolatappelu.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import static java.lang.System.out;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import luolatappelu.peli.Peli;

/**
 * Ruudukko luokassa luodaan tekstiruudukko grafiikoiden viereen.
 */
public class Ruudukko extends JLabel {

    private Peli peli;
    private JTextArea tuloste;

    public Ruudukko(Peli peli) {
        super.setBackground(Color.white);
        super.setBounds(840, 0, 460, 870);
        super.setLayout(new GridLayout(1,3));
        this.peli = peli;
        this.tuloste = new JTextArea();
        tuloste.setEnabled(false);
        kirjoitin();
}
    public void kirjoitin(){
        StringBuilder sb = new StringBuilder();
        sb.append("asdfga");
        super.setText(sb.toString());
        
    }
}
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.PrintStream;
//import javax.swing.*;
//
//@SuppressWarnings("serial")
//public class TextAreaOutputStreamTest extends JPanel {
//
//   private JTextArea textArea = new JTextArea(15, 30);
//   private TextAreaOutputStream taOutputStream = new TextAreaOutputStream(
//         textArea, "Test");
//
//   public TextAreaOutputStreamTest() {
//      setLayout(new BorderLayout());
//      add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
//            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
//      System.setOut(new PrintStream(taOutputStream));
//
//      int timerDelay = 1000;
//      new Timer(timerDelay , new ActionListener() {
//         int count = 0;
//         @Override
//         public void actionPerformed(ActionEvent arg0) {
//
//            // though this outputs via System.out.println, it actually displays
//            // in the JTextArea:
//            System.out.println("Count is now: " + count + " seconds");
//            count++;
//         }
//      }).start();
//   }
//
//   private static void createAndShowGui() {
//      JFrame frame = new JFrame("Test");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.getContentPane().add(new TextAreaOutputStreamTest());
//      frame.pack();
//      frame.setLocationRelativeTo(null);
//      frame.setVisible(true);
//   }
//}
