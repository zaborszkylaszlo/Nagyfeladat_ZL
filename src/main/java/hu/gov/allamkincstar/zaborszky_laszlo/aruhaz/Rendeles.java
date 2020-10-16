package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public class Rendeles {
    private Integer darabszam;
    private Termek  termek = new Termek();

    public Rendeles(Integer darabszam, Termek termek) {
        this.darabszam = darabszam;
        this.termek    = termek;
    }

    public Integer getDarabszam() {
        return darabszam;
    }

    public void setDarabszam(Integer darabszam) {
        this.darabszam = darabszam;
    }

    public Termek getTermek() {
        return termek;
    }

    public Integer getOsszesen() {
        return this.getDarabszam() * this.termek.getEgysegar();
    }

}
