/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testiluokat;

import luolatappelu.peli.Huone;
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

    public HuoneTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
    @Test
    public void testaaLuodunHuoneenKoko() {
        Huone huone = new Huone(10, 10);
        assertEquals(huone.getKorkeus(), 10);
        assertEquals(huone.getLeveys(), 10);
    }
}
