/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.hahmot.Seina;

/**
 *
 * @author ville
 */
public class Luolasto {

    private Random arpoja;
    private int leveys;
    private int korkeus;
    private ArrayList<Seina> seinat;

    public Luolasto() {
        this.arpoja = new Random();
        this.seinat = new ArrayList();
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public ArrayList<Seina> getSeinat() {
        return seinat;
    }

    public void uusiLuola() {
        seinat.clear();
        int arpa = arpoja.nextInt(2);
        if (arpa == 0) {
            luola1();
        } else if (arpa == 1) {
            luola2();
        } else if (arpa == 2) {

        } else if (arpa == 3) {

        }
    }

    private void luola1() {
        this.leveys = 20;
        this.korkeus = 20;
        rakennaReunat();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 15; j++) {
                Seina seina1 = new Seina(i * 8 + 4, korkeus - j);
                Seina seina2 = new Seina(i * 8 + 8, j);
                seinat.add(seina1);
                seinat.add(seina2);
            }
        }
    }

    private void luola2() {
        this.leveys = 10;
        this.korkeus = 20;
        rakennaReunat();
    }

    private void rakennaReunat() {
        for (int i = 0; i < leveys + 1; i++) {
            Seina seinaYla = new Seina(i, 0);
            seinat.add(seinaYla);
            Seina seinaAla = new Seina(i, korkeus);
            seinat.add(seinaAla);
        }
        for (int j = 0; j < korkeus; j++) {
            Seina seinaVas = new Seina(0, j);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(leveys, j);
            seinat.add(seinaOik);
        }

    }

}
