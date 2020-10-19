package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

//Az osztály az adott kedvezmény meghatározásához szükséges. Absztrakt osztály, mert a konkrét számítási mód itt még nem ismert.
public abstract class Kedvezmeny {
    private String  megnevezes; //A kedvezmény megnevezése.
    private Integer darabszam;  //A kedvezmény kiszámításához szükséges tudni, hogy hány db termékről van szó.

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public Integer getDarabszam() {
        return darabszam;
    }

    public void setDarabszam(Integer darabszam) {
        this.darabszam = darabszam;
    }

    /*
    A megnevezesnek megfelelő kedvezmény összegének a kiszámítása: hány forint a kedvezmény?
    A termék összárából ezt kivonva megkapjuk a kedvezményes árat, ez fog beszámítani az új összárba.
    */
    public abstract Integer getKedvezmenyosszege();
}
