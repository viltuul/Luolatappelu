/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.luolatappelu.hahmot;

/**
 *
 * @author tuulio
 */
public class Olio {

    private String nimi;
    private int elamat;
    private double osumatarkkuus;
    private int voima;
    private int x;
    private int y;

    public Olio(String nimi) {
        this.nimi = nimi;
        this.elamat = 10;
        this.osumatarkkuus = 0.5;
        this.voima = 1;
    }

    public int getElamat() {
        return elamat;
    }

    public String getNimi() {
        return nimi;
    }

    public double getOsumatarkkuus() {
        return osumatarkkuus;
    }

    public void setElamat(int elamat) {
        this.elamat = elamat;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.nimi;
    }
   

}
