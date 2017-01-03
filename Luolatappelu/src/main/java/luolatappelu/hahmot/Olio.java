/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luolatappelu.hahmot;

/**
 *
 * @author tuulio
 */
public class Olio {

    private String nimi;
    private int elamat;
    private int x;
    private int y;
    private boolean elossa;
    private Suunta viimeinenSuunta;

    public Olio(String nimi) {
        this.nimi = nimi;
        this.elamat = 1;
        this.elossa = true;
        this.x = 0;
        this.y = 0;
    }

    public String getNimi() {
        return nimi;
    }

    public int getElamat() {
        return elamat;
    }

    public boolean isElossa() {
        if (elamat <= 0) {
            elossa = false;
        }
        return elossa;
    }

    public void vahennaElamaa() {
        this.elamat--;
    }

    public void setElamat(int elama) {
        this.elamat = elama;
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
    
    public void liiku(Suunta suunta) {
        this.viimeinenSuunta = suunta;
        if (suunta.equals(suunta.ALAS)) {
            y++;
        } else if (suunta.equals(suunta.YLOS)) {
            y--;
        } else if (suunta.equals(suunta.VASEN)) {
            x--;
        } else if (suunta.equals(suunta.OIKEA)) {
            x++;
        }
    }

    public void liikuTakaisin() {
        if (viimeinenSuunta.equals(Suunta.ALAS)) {
            y--;
        } else if (viimeinenSuunta.equals(Suunta.YLOS)) {
            y++;
        } else if (viimeinenSuunta.equals(Suunta.VASEN)) {
            x++;
        } else if (viimeinenSuunta.equals(Suunta.OIKEA)) {
            x--;
        }
    }

    public boolean lyo(Olio lyotava) {
        if (lyotava == null) {
            return false;
        } else {
            lyotava.vahennaElamaa();
            System.out.println(this.getNimi() + " osui olioon " + lyotava.getNimi());
            return true;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.elamat;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Olio other = (Olio) obj;
        if (this.elamat != other.elamat) {
            return false;
        }
        return true;
    }
}
