/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hahmot;

/**
 *
 * @author tuulio
 */
public class Olio {
    private String nimi;
    private int elamat;
    private double osumatarkkuus;
    private int voima;

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
    
    
    
    
}
