package luolatappelu.objektit;

/**
 *
 * @author ville
 */
public class Puuseina extends Olio {

    public Puuseina() {
        super("Puuseinä");
        super.setElamat(2);
    }

    @Override
    public String toString() {
        return "P";
    }
    @Override
    public boolean lyo(Olio lyotava){
        return false;
    }
    @Override
    public void liikuTakaisin(){
        
    }

}
