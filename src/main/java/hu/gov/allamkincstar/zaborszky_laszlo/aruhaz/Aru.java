package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

//Minden áru őse a Termek. Itt konkrét árut adhatunk meg.
public class Aru extends Termek {
    public Aru(String megnevezes, String kodja, String kedvezmeny, Integer egysegar) {
        super.setMegnevezes(megnevezes);
        super.setKodja(kodja);
        super.setKedvezmeny(kedvezmeny);
        super.setEgysegar(egysegar);
    }
}
