package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public class MegaPack extends Kedvezmeny {
    private final String megnevezes = "megapack"; //A kedvezménytípus neve.

    public MegaPack(Integer darabszam) {
        super.setMegnevezes(megnevezes);
        super.setDarabszam(darabszam);
    }

    public MegaPack() {
        super.setMegnevezes(megnevezes);
    }

    public Integer getKedvezmenyosszege() {
        return super.getDarabszam() / 12 * 6000;
    }

}
