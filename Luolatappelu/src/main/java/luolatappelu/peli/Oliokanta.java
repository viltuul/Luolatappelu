package luolatappelu.peli;

import java.util.ArrayList;
import luolatappelu.objektit.Olio;
import luolatappelu.objektit.Orkki;
import luolatappelu.objektit.Pelaaja;
import luolatappelu.objektit.Puuseina;
import luolatappelu.objektit.Seuraaja;
import luolatappelu.objektit.Tankki;

/**
 * Oliokanta sisältää kaikki tasoon luodut oliot.
 */
public class Oliokanta {

    private ArrayList<Orkki> orkit;
    private ArrayList<Seuraaja> seuraajat;
    private ArrayList<Tankki> tankit;
    private ArrayList<Olio> viholliset;
    private ArrayList<Puuseina> puuseinat;

    /**
     * Konstruktorissa luodaan jokaiselle vihollistyypille oma lista sekä yksi
     * lista joka sisältää kaikki viholliset.
     */
    public Oliokanta() {
        this.orkit = new ArrayList();
        this.seuraajat = new ArrayList();
        this.tankit = new ArrayList();
        this.puuseinat = new ArrayList();
        this.viholliset = new ArrayList();
    }

    public ArrayList<Olio> getViholliset() {
        return viholliset;
    }

    /**
     * Metodi luo uuden Orkkiolion ja lisää sen orkit sekä viholliset listaan.
     */
    public void uusiOrkki() {
        Orkki orkki = new Orkki();
        orkit.add(orkki);
        viholliset.add(orkki);
    }

    public ArrayList<Orkki> getOrkit() {
        return orkit;
    }

    /**
     * Metodi luo uuden Seuraajaolion ja lisää sen seuraajat sekä viholliset
     * listaan.
     *
     * @param pelaaja Seuraaja tarvitsee pelaajaolion tietoja, jotta se osaa
     * liikkua oikeaan suuntaan.
     */
    public void uusiSeuraaja(Pelaaja pelaaja) {
        Seuraaja seuraaja = new Seuraaja(pelaaja);
        seuraajat.add(seuraaja);
        viholliset.add(seuraaja);
    }

    public ArrayList<Seuraaja> getSeuraajat() {
        return seuraajat;
    }

    /**
     * Metodi luo uuden Tankkiolion ja liää sen tankit sekä viholliset listaan.
     */
    public void uusiTankki() {
        Tankki tankki = new Tankki();
        tankit.add(tankki);
        viholliset.add(tankki);
    }

    public ArrayList<Tankki> getTankit() {
        return tankit;
    }

    /**
     * Metodi luo uuden Puuseinaolion ja lisää sen puuseinat listaan.
     */
    public void uusiPuuseina() {
        Puuseina puuseina = new Puuseina();
        puuseinat.add(puuseina);
    }

    public ArrayList<Puuseina> getPuuseinat() {
        return puuseinat;
    }

    /**
     * Metodi siirtää kaikki kuolleet oliot pois peliruudulta.
     */
    public void poistaKuolleet() {
        for (Olio olio : viholliset) {
            if (!olio.isElossa()) {
                olio.setX(olio.hashCode() + 9999999);
            }
        }
    }

    /**
     * Metodi siirtää tuhoutuneet puuseinat pois peliruudulta.
     */
    public void poistaTuhoutunutPuuseina() {
        for (Puuseina puuseina : puuseinat) {
            if (!puuseina.isElossa()) {
                puuseina.setY(9999);
            }
        }
    }

    /**
     * getElossaOlevat metodi palauttaa listan vihollisista jotka ovat elossa.
     *
     * @return lista elossa olevista vihollisista.
     */
    public ArrayList<Olio> getElossaOlevat() {
        ArrayList<Olio> lista = new ArrayList();
        for (Olio olio : viholliset) {
            if (olio.isElossa()) {
                lista.add(olio);
            }
        }
        return lista;
    }
}
