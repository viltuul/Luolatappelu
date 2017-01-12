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
    }

    /**
     * tapahtumienKirjoitin kertoo mitä pelissä kullakin vuorolla on käynyt.
     *
     * @return palauttaa tekstin.
     */
    public String tapahtumienKirjoitin() {
        this.tapahtuma = new StringBuilder();
        for (Olio olio : peli.getOliokanta().getViholliset()) {
            tapahtuma.append("\n");
        }
        return tapahtuma.toString();
    }
    public void lyontitapahtuma(Olio lyoja, Olio lyotava){
        
    }

    /**
     * Tietojen kirjoitin kirjoittaa pelaajan nykyiset elämät, parannuksen ja
     * osumatarkkuuden.
     *
     * @return palauttaa tekstin jossa yllämainitut tiedot.
     */
    public String tietojenKirjoitin() {
        StringBuilder tietojenTulostin = new StringBuilder();
        tietojenTulostin.append("Taso: " + peli.getVaikeustaso() + "\n");
        tietojenTulostin.append("Pelaajan elämät: " + peli.getPelaaja().getElamat() + "/" + peli.getPelaaja().getMaksimiElamat() + "\n");
        tietojenTulostin.append("Parannus: " + peli.getPelaaja().getParannus() + "\n");
        tietojenTulostin.append("Osumatarkkuus: " + peli.getPelaaja().getOsumatarkkuus() + "\n");
        return tietojenTulostin.toString();
    }

}
