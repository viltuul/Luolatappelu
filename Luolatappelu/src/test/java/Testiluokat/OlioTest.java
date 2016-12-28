/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testiluokat;

import luolatappelu.hahmot.Olio;
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
public class OlioTest {
    
    public OlioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
@Test
public void kuoleekoOlioKunElamatLoppuvat(){
    Olio olio = new Olio("testi");
    olio.setElamat(0);
    assertFalse(olio.isElossa());
}
}
