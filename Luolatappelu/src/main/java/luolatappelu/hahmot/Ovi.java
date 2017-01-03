package luolatappelu.hahmot;

import java.util.Random;

public class Ovi extends Olio {

    public Ovi() {
        super("Ovi");
        Random random = new Random();
        super.setX(new Random().nextInt(10) + 5);
        super.setY(1);
    }

}
