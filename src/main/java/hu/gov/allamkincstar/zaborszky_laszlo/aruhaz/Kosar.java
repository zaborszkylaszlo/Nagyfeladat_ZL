package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

import java.util.ArrayList;
import java.util.List;

//A kosár osztálya, ide rakjuk a megvásárolni kívánt árut, annyi darabot, amennyire szükségünk van.
public class Kosar {
    private List<Rendeles> kosar = new ArrayList<>(); //A kosárba a rendelések kerülnek. A rendelés: termék és a darabszáma.
    private String         termeknev;                 //A kosárból is megtudhatjuk a belerakott rendelésen keresztül a termék neve.
    private Integer        darabszam;                 //A kosárból is megtudhatjuk a belerakott rendelésen keresztül a termék darabszámát.
    private int            index;                     //A kosárba éppen belerakott tétel indexe (tömbváltozója).

    public void KosarbaTesz(Rendeles mit) {
        this.termeknev = mit.getTermek().getMegnevezes();
        this.darabszam = mit.getDarabszam();
        this.kosar.add(mit);
        this.index     = this.kosar.indexOf(mit); //Ezt értelemszerűen csak az "add" utasítást követően kapjuk meg.
    }

    public List<Rendeles> getKosar() {
        return kosar;
    }

    public String getTermeknev() {
        return termeknev;
    }

    public Integer getDarabszam() {
        return darabszam;
    }

    public int getIndex() {
        return index;
    }

    //Üres-e a kosarunk?
    public boolean getKosarUres() {
        return this.kosar.isEmpty();
    }

    //Az adott indexű helyen lévő termék (pontosabban: rendelés, hiszen a darabszáma is ideértendő) lekérdezése:
    public Rendeles getAdottTermek(int index) {
        return this.kosar.get(index);
    }

    //Az adott indexű termék (pontosabban: rendelés, hiszen a darabszáma is ideértendő) törlése a kosárból:
    public void TermeketTorol(int index) {
        this.kosar.remove(index);
    }
}
