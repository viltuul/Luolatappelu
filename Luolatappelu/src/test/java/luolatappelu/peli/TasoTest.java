/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import luolatappelu.kayttoliittyma.Kayttoliittyma;
import luolatappelu.objektit.Olio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class TasoTest {

    private Taso taso;
    private Peli peli;

    public TasoTest() {
        this.peli = new Peli(new Kayttoliittyma());
        this.taso = new Taso(peli);
    }

    public void tasoLapiKunVihollisetKuolleet() {
        taso.uusiTaso(1);
        for (Olio olio : taso.getOliokanta().getViholliset()) {
            olio.setElamat(0);
        }
        assertTrue(taso.isTasoLapi());
    }

    public void sijoittaaVihollisetTasonRajojenSisapuolelle() {
        taso.uusiTaso(1);
        for (int i = 0; i < 100; i++) {
            taso.sijoitaViholliset();
            for (int j = 0; j < peli.getOliokanta().getViholliset().size(); j++) {
                assertTrue(peli.getOliokanta().getViholliset().get(j).getX() < 20);
                assertTrue(peli.getOliokanta().getViholliset().get(j).getY() < 20);
            }
        }
    }
}
