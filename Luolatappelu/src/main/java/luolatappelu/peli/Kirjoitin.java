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
    private boolean voimistumisestaIlmoitettu;

    /**
     * Konstruktorissa tuodaan vain peliluokka attribuutiksi luokalle.
     *
     * @param peli Peli jota pelataan.
     */
    public Kirjoitin(Peli peli) {
        this.peli = peli;
        this.tapahtuma = new StringBuilder();
        this.voimistumisestaIlmoitettu = false;
    }

    /**
     * tapahtumienKirjoitin kertoo mitä pelissä kullakin vuorolla on käynyt.
     *
     * @return palauttaa tekstin.
     */
    public String getTapahtuma() {
        return tapahtuma.toString();
    }

    /**
     * Kirjoittaa ylös lyöntitapahtuman kutsuttaessa. Jos olio kuolee niin
     * metodi ilmoittaa myös siitä.
     *
     * @param lyoja Olio joka lyö.
     * @param lyotava Olio jota lyödään.
     * @param osuiko Totuusarvo joka kertoo osuiko lyönti.
     */
    public void lyontitapahtuma(Olio lyoja, Olio lyotava, boolean osuiko) {
        if (osuiko) {
            tapahtuma.append(lyoja.getNimi() + " osui olioon " + lyotava.getNimi() + "\n");
            if (lyotava.getElamat() == 0) {
                if (lyotava.toString().equals("P")) {
                    tapahtuma.append("Olio " + lyotava.getNimi() + " tuhoutui. \n");
                } else {
                    tapahtuma.append("Olio " + lyotava.getNimi() + " kuoli. \n");
                }
            }
        } else {
            tapahtuma.append(lyoja.getNimi() + " ei osunut olioon " + lyotava.getNimi() + "\n");
        }
    }

    /**
     * Metodi ilmoittaa vihollisten voimistumisesta.
     */
    public void ilmoitaVihollistenVoimistumisesta() {
        if (!voimistumisestaIlmoitettu) {
            tapahtuma.append("\n \n \n \n \n");
            tapahtuma.append("HUOMIO! \n \n");
            tapahtuma.append("Viholliset voimistuvat huomattavasti");
            tapahtuma.append("\n \n \n \n \n");
            voimistumisestaIlmoitettu = true;
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
