/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu.kayttoliittyma;

import java.util.ArrayList;
import java.util.Scanner;
import luolatappelu.luolatappelu.hahmot.Olio;
import luolatappelu.luolatappelu.hahmot.Orkki;
import luolatappelu.luolatappelu.hahmot.Suunta;

/**
 *
 * @author ville
 */
public class UI {

    private Scanner lukija;
    private Peli peli;
    private Paahahmo pelaaja;

    public UI(Scanner lukija) {
        this.lukija = lukija;
        this.peli = new Peli();
        this.pelaaja = peli.getPelaaja();

    }

    public void run() {
        ohje();
        alku();
        pelaaminen();
    }

    public void ohje() {
        System.out.println("Liiku komennoilla: a,s,d tai w");
        System.out.println("Lyö painamalla enter");
    }

    public void alku() {
        peli.pelaajanSijoitus();
        for (int i = 0; i < 5; i++) {
            peli.uusiOrkki();
        }
        peli.sijoitaOliot();
        peli.tulostaHuone();
    }

    public void pelaaminen() {
        while (true) {
            toimintoPelaajalla();
            liikutaOlioita();
            if (!peli.getPelaaja().isElossa()) {
                System.out.println("hävisit!");
                break;
            }
        }
    }

    public void toimintoPelaajalla() {
        String liiku = lukija.nextLine();
        System.out.println(peli.getPelaaja().getElamat());
        if (liiku.equals("a")) {
            peli.getPelaaja().liiku(Suunta.VASEN);
        }
        if (liiku.equals("s")) {
            peli.getPelaaja().liiku(Suunta.ALAS);
        }
        if (liiku.equals("d")) {
            peli.getPelaaja().liiku(Suunta.OIKEA);
        }
        if (liiku.equals("w")) {
            peli.getPelaaja().liiku(Suunta.YLOS);
        }
        if (liiku.equals("")) {
            peli.lyoNaapuria(peli.getPelaaja());
        }
        peli.tulostaHuone();
        System.out.println(peli.getNaapurit(peli.getPelaaja()));
    }

    public void liikutaOlioita() {
        peli.poistaKuolleet();
        for (Orkki orkki : peli.getOliot()) {
            ArrayList<Olio> lista = peli.getNaapurit(orkki);
            if (lista.contains(pelaaja)) {
                peli.lyoNaapuria(orkki);
            } else {
                orkki.liiku(orkki.arvoSuunta());
            }
            peli.eiMeneReunanYli(orkki);
        }
    }
}


