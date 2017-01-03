/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.peli;

import luolatappelu.peli.Taso;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class HuoneTest {
private Taso huone;
    public HuoneTest() {
        this.huone = new Taso(20,20);
    }

    @Test
    public void testaaLuodunHuoneenKoko() {
        assertEquals(huone.getKorkeus(), 20);
        assertEquals(huone.getLeveys(), 20);
    }
}
