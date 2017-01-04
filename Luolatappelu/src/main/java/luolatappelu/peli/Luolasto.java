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

    public void rakennaSeinat() {
        for (int i = 0; i < leveys + 1; i++) {
            Seina seinaYla = new Seina(i, 0);
            seinat.add(seinaYla);
            Seina seinaAla = new Seina(i, this.getKorkeus());
            seinat.add(seinaAla);
            Seina kok = new Seina(5, i);
            seinat.add(kok);
        }
        for (int j = 0; j < this.getKorkeus(); j++) {
            Seina seinaVas = new Seina(0, j);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(this.getLeveys(), j);
            seinat.add(seinaOik);
        }

    }
}
