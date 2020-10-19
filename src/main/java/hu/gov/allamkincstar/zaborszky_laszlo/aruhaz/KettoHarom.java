package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

//"Kettőt fizet hármat kap!" - kedvezmény.
public class KettoHarom extends Kedvezmeny {
    private       Integer egysegar;           //Ennél a kedvezménytípusnál az egységárból számítjuk a kedvezmény mértékét.
    private final String  megnevezes = "2=3"; //A kedvezménytípus neve.

    public KettoHarom(Integer darabszam, Integer egysegar) {
        super.setMegnevezes(megnevezes);
        super.setDarabszam(darabszam);
        this.egysegar = egysegar;
    }

    public KettoHarom() {
        super.setMegnevezes(megnevezes);
    }

    public Integer getKedvezmenyosszege() {
        return super.getDarabszam() / 3 * this.egysegar;
    }
}
