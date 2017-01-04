/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class HuoneTest {

    private Taso huone;
    private Peli peli;

    public HuoneTest() {
        this.peli = new Peli();
        this.huone = new Taso(peli);
    }

    @Test
    public void testaaLuodunHuoneenKoko() {
        assertEquals(huone.getKorkeus(), 20);
        assertEquals(huone.getLeveys(), 20);
    }
}
