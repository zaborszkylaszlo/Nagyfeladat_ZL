package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

public enum Igenem {
    IGEN("I"),
    NEM("N");

    private final String megnevezes;

    Igenem(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public String getMegnevezes() {
        return megnevezes;
    }
}
