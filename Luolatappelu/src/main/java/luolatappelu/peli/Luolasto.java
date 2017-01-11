package luolatappelu.peli;

import java.util.ArrayList;
import java.util.Random;
import luolatappelu.objektit.Seina;

/**
 * Luolasto on luokka jossa generoidaan Tasojen seinien sijainnit ja tason koon.
 */
public class Luolasto {

    private Random arpoja;
    private int leveys;
    private int korkeus;
    private ArrayList<Seina> seinat;

    /**
     * Konstruktorissa luodaan satunnaismuuttuja, lista seinäolioille sekä
     * asetetaan luolastolle leveys ja korkeus.
     */
    public Luolasto() {
        this.arpoja = new Random();
        this.seinat = new ArrayList();
        this.leveys = 20;
        this.korkeus = 20;
    }

    /**
     * Konstruktori on tehty lähinnä testejä varten. Muuten samanlainen kuin
     * aiempi, mutta tässä parametrina tuodaan satunnaismuuttuja.
     *
     * @param arpoja parametrinä esimerkiksi halutunlainen satunnaismuuttuja.
     */
    public Luolasto(Random arpoja) {
        this.arpoja = arpoja;
        this.seinat = new ArrayList();
        this.leveys = 20;
        this.korkeus = 20;
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

    /**
     * uusiLuola metodi arpoo tiettyjen luolatyyppien väliltä, minkä luola
     * luodaan.
     */
    public void uusiLuola() {
        seinat.clear();
        rakennaReunat();
        int arpa = arpoja.nextInt(5);
        if (arpa == 0) {
            luola0();
        } else if (arpa == 1) {
            luola1();
        } else if (arpa == 2) {
            luola2();
        } else if (arpa == 3) {
            luola3();
        } else if (arpa == 4) {
            luola4();
        }
    }

    private void luola0() {
        rakennaSeinamaPoikittain(3, 10, 7);
        rakennaSeinamaPoikittain(11, 10, 7);
        rakennaSeinamaPitkittain(10, 3, 15);
    }

    private void luola1() {
        rakennaSeinamaPoikittain(4, 5, 14);
        rakennaSeinamaPoikittain(4, 15, 14);
        rakennaSeinamaPitkittain(4, 6, 8);
        rakennaSeinamaPitkittain(17, 6, 9);

    }

    private void luola2() {
        rakennaSeinamaPitkittain(4, 1, 16);
        rakennaSeinamaPitkittain(12, 1, 16);
        rakennaSeinamaPitkittain(8, 4, 16);
        rakennaSeinamaPitkittain(16, 4, 16);
    }

    private void luola3() {
        rakennaSeinamaPitkittain(10, 1, 6);
        rakennaSeinamaPoikittain(1, 10, 16);
        rakennaSeinamaPitkittain(16, 11, 6);
        rakennaSeinamaPoikittain(1, 14, 5);
        rakennaSeinamaPitkittain(6, 14, 5);
    }

    private void luola4() {
        for (int i = 0; i < 6; i++) {
            rakennaSeinamaPitkittain(3 * i + 2, 3, 15);
        }
    }

    private void rakennaSeinamaPoikittain(int x, int y, int pituus) {
        for (int i = 0; i < pituus; i++) {
            Seina seina = new Seina(x + i, y);
            seinat.add(seina);
        }
    }

    private void rakennaSeinamaPitkittain(int x, int y, int pituus) {
        for (int i = 0; i < pituus; i++) {
            Seina seina = new Seina(x, y + i);
            seinat.add(seina);
        }
    }

    private void rakennaReunat() {
        for (int i = 0; i < leveys + 1; i++) {
            Seina seinaYla = new Seina(i, 0);
            seinat.add(seinaYla);
            Seina seinaAla = new Seina(i, korkeus);
            seinat.add(seinaAla);
        }
        for (int j = 1; j < korkeus; j++) {
            Seina seinaVas = new Seina(0, j);
            seinat.add(seinaVas);
            Seina seinaOik = new Seina(leveys, j);
            seinat.add(seinaOik);
        }
    }
}
