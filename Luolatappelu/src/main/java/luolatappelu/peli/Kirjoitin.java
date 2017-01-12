package luolatappelu.peli;

import luolatappelu.objektit.Olio;

/**
 * Kirjoitin on luokka joka kirjoittaa pelin tapahtumat tekstiksi.
 *
 * @author ville
 */
public class Kirjoitin {

    private StringBuilder tapahtuma;
    private StringBuilder tiedot;
    private Peli peli;

    /**
     * Konstruktorissa tuodaan vain peliluokka attribuutiksi luokalle.
     *
     * @param peli
     */
    public Kirjoitin(Peli peli) {
        this.peli = peli;
        this.tapahtuma = new StringBuilder();
    }

    /**
     * tapahtumienKirjoitin kertoo mitä pelissä kullakin vuorolla on käynyt.
     *
     * @return palauttaa tekstin.
     */
    public String getTapahtuma() {
        return tapahtuma.toString();
    }

    public void lyontitapahtuma(Olio lyoja, Olio lyotava, boolean osuiko) {
        if (osuiko) {
            tapahtuma.append(lyoja.getNimi() + " osui olioon " + lyotava.getNimi() + "\n");
        } else {
            tapahtuma.append(lyoja.getNimi() + " ei osunut olioon " + lyotava.getNimi() + "\n");
        }
    }

    /**
     * Tietojen kirjoitin kirjoittaa pelaajan nykyiset elämät, parannuksen ja
     * osumatarkkuuden.
     *
     * @return palauttaa tekstin jossa yllämainitut tiedot.
     */
    public String tietojenKirjoitin() {
        StringBuilder tietojenTulostin = new StringBuilder();
        tietojenTulostin.append(peli.getPelaaja().getNimi() + "\n");
        tietojenTulostin.append("Taso: " + peli.getVaikeustaso() + "\n");
        tietojenTulostin.append("Pelaajan elämät: " + peli.getPelaaja().getElamat() + "/" + peli.getPelaaja().getMaksimiElamat() + "\n");
        tietojenTulostin.append("Parannus: " + peli.getPelaaja().getParannus() + "\n");
        tietojenTulostin.append("Osumatarkkuus: " + (int) (peli.getPelaaja().getOsumatarkkuus() * 100) + " % \n");
        return tietojenTulostin.toString();
    }

}
