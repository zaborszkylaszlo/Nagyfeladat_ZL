package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public class Aru extends Termek {
    public Aru(String megnevezes, String kodja, String kedvezmeny, Integer egysegar) {
        super.setMegnevezes(megnevezes);
        super.setKodja(kodja);
        super.setKedvezmeny(kedvezmeny);
        super.setEgysegar(egysegar);
    }
}
