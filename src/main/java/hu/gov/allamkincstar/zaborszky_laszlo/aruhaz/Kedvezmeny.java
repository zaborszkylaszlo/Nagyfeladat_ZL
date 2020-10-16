package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

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
    Ezt kell majd az összárból levonni.
    */
    public abstract Integer getKedvezmenyosszege();
}
