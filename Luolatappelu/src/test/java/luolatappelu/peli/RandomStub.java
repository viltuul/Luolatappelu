
package luolatappelu.peli;

import luolatappelu.hahmot.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


class RandomStub extends Random {
List<Integer> lista;
    public RandomStub(Integer ... luvut) {
        lista = new ArrayList();
        lista.addAll(Arrays.asList(luvut));
    }
    @Override
    public int nextInt(int raja){
        return lista.remove(0);
    }
    
}
