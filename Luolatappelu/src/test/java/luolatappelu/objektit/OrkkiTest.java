/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.objektit;

import luolatappelu.objektit.Orkki;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tuulio
 */
public class OrkkiTest {

    private Orkki orkki;

    public OrkkiTest() {
        this.orkki = new Orkki();
    }

    @Test
    public void orkinLuomisenTestaus() {
        assertEquals(orkki.toString(), "Ö");
    }

    @Test
    public void liikkumisenTestaaminenAlas() {
        Random randomStub = new RandomStub(1, 1);
        Orkki stub = new Orkki(randomStub);
            stub.liiku();
            stub.liiku();
            assertEquals(stub.getY(), 2);
    }
        @Test
    public void liikkumisenTestaaminenYlos() {
        Random randomStub = new RandomStub(2,2);
        Orkki stub = new Orkki(randomStub);
            stub.liiku();
            stub.liiku();
            assertEquals(stub.getY(), -2);
    }
        @Test
    public void liikkumisenTestaaminenVasen() {
        Random randomStub = new RandomStub(3,3);
        Orkki stub = new Orkki(randomStub);
            stub.liiku();
            stub.liiku();
            assertEquals(stub.getX(), -2);
    }
        @Test
    public void liikkumisenTestaaminenOikea() {
        Random randomStub = new RandomStub(0,0);
        Orkki stub = new Orkki(randomStub);
            stub.liiku();
            stub.liiku();
            assertEquals(stub.getX(), 2);
    }

}
