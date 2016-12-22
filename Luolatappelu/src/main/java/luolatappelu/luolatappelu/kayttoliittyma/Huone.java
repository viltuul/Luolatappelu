/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu.kayttoliittyma;

/**
 *
 * @author tuulio
 */
public class Huone {
    private int leveys;
    private int korkeus;
    private String piirros;

    public Huone(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public void huoneenPiirros(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<korkeus;i++){
            for (int j = 0;j<leveys;j++){
                sb.append("-");
            }
            sb.append("\n");
        }
        this.piirros = sb.toString();
    }
    

    @Override
    public String toString() {
        return piirros;
    }
    
    
}
