package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public class Ervenyesites {
    private String  megnevezes;
    private Integer osszeg;

    public Ervenyesites(String megnevezes, Integer osszeg) {
        this.megnevezes = megnevezes;
        this.osszeg     = osszeg;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public Integer getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(Integer osszeg) {
        this.osszeg = osszeg;
    }
}
