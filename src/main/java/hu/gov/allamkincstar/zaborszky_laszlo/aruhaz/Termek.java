package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public class Termek {
    private String  megnevezes; //A termék (áru) megnevezése.
    private String  kodja;      //A termék (áru) kódja (rövid neve). (Ne kelljen annyit gépelni...)
    private String  kedvezmeny; //A termékre (árura) vonatkozó kedvezménytípus megnevezése.
    private Integer egysegar;   //A termék (áru) egységára.

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public String getKodja() {
        return kodja;
    }

    public void setKodja(String kodja) {
        this.kodja = kodja;
    }

    public String getKedvezmeny() {
        return kedvezmeny;
    }

    public void setKedvezmeny(String kedvezmeny) {
        this.kedvezmeny = kedvezmeny;
    }

    public Integer getEgysegar() {
        return egysegar;
    }

    public void setEgysegar(Integer egysegar) {
        this.egysegar = egysegar;
    }
}
