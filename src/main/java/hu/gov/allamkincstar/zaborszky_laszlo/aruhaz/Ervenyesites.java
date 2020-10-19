package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

//Ebben az osztályban dől el, hogy melyik áruból érvényesíthetjük a kedvezményt.
public class Ervenyesites {
    private String  megnevezes;
    private Integer osszeg;
    private Integer kulonbozet;

    public Ervenyesites(String megnevezes, Integer osszeg, Integer kulonbozet) {
        this.megnevezes = megnevezes;
        this.osszeg     = osszeg;
        this.kulonbozet = kulonbozet;
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

    public Integer getKulonbozet() {
        return kulonbozet;
    }

    public void setKulonbozet(Integer kulonbozet) {
        this.kulonbozet = kulonbozet;
    }
}
