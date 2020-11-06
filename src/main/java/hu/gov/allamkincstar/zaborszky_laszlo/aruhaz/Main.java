package hu.gov.allamkincstar.zaborszky_laszlo.aruhaz;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //A szükséges adatok bekérése a billentyűzetről:
        Scanner    eldont        = new Scanner(System.in);
        Scanner    valaszt       = new Scanner(System.in);

        //A vásárlás folytatására:
        Boolean    folytat       = Boolean.FALSE;

        //Hibás válasz javítására:
        Boolean    javitsd       = Boolean.FALSE;

        //A vásárlás folytatására feltett kérdésre adott "igen" válasz. (A "nem" bármi más lehet.):
        Igenem     igen          = Igenem.IGEN;

        //A lehetséges kedvezmények:
        KettoHarom kettoHarom_1  = new KettoHarom();
        MegaPack   megaPack_1    = new MegaPack();

        //Az összes létező termék felsorolása:
        Aru        teliszalami   = new Aru("téliszalámi", "té", kettoHarom_1.getMegnevezes(), 2000);
        Aru        gumikacsa     = new Aru("gumikacsa", "gu", kettoHarom_1.getMegnevezes(), 3000);
        Aru        uborka        = new Aru("uborka", "ub", megaPack_1.getMegnevezes(), 2800);
        Aru        gesztenye     = new Aru("gesztenye", "ge", megaPack_1.getMegnevezes(), 1000);

        //Az "aru" bármelyik (a fentiekben felsorolt) termék lehet, hiszen minden termék őse a Termek:
        Termek     aru           = new Termek();

        //Ebbe rakom a vásárolt árut. Itt termék-ismétlődések előfordulhatnak:
        Kosar      kosar          = new Kosar();

        //Itt véglegesítjük a kosar tartalmát: az ismétlődő termékeket egyesítjük:
        Kosar      penztar        = new Kosar();

        int        ciklusvaltozo;

        Integer    mennyiseg      = 0;

        //Mi van a kosárban? Minden áru csak egyszer szerepel benne. A "Set" demonstrálásra vettem fel ezt az objektumot:
        Set<String> kosarban      = new HashSet<String>();

        System.out.println("Árukészlet neve, kódja, kedvezmény neve, egységár: \n" +
                teliszalami.getMegnevezes() + " " + teliszalami.getKodja() + " " + teliszalami.getKedvezmeny() + " " + teliszalami.getEgysegar() + "\n" +
                gumikacsa.getMegnevezes()   + " " + gumikacsa.getKodja()   + " " + gumikacsa.getKedvezmeny()   + " " + gumikacsa.getEgysegar()   + "\n" +
                uborka.getMegnevezes()      + " " + uborka.getKodja()      + " " + uborka.getKedvezmeny()      + " " + uborka.getEgysegar()      + "\n" +
                gesztenye.getMegnevezes()   + " " + gesztenye.getKodja()   + " " + gesztenye.getKedvezmeny()   + " " + gesztenye.getEgysegar()   + "\n");

        do {
            System.out.println("Írja be a kiválasztott áru kódját!");
            String kod = valaszt.nextLine();

            //Ha újabb árut veszünk fel, akkor az ellenőrzését ide be kell rakni:
            if (!(kod.toUpperCase().equals(teliszalami.getKodja().toUpperCase())) &&
                !(kod.toUpperCase().equals(gumikacsa.getKodja().toUpperCase()))   &&
                !(kod.toUpperCase().equals(uborka.getKodja().toUpperCase()))      &&
                !(kod.toUpperCase().equals(gesztenye.getKodja().toUpperCase()))) {
                System.out.println("Nem létező áru kódját adta meg.");
                folytat = Boolean.TRUE;
                continue;
            }
            else {
                //Ha újabb árut vesszünk fel, akkor annak is létre kell hozni egy "if (kod.toUpperCase().equals..." sort:
                if (kod.toUpperCase().equals(teliszalami.getKodja().toUpperCase())) {
                    aru = teliszalami;
                }
                if (kod.toUpperCase().equals(gumikacsa.getKodja().toUpperCase())) {
                    aru = gumikacsa;
                }
                if (kod.toUpperCase().equals(uborka.getKodja().toUpperCase())) {
                    aru = uborka;
                }
                if (kod.toUpperCase().equals(gesztenye.getKodja().toUpperCase())) {
                    aru = gesztenye;
                }
            }
            do {
                javitsd = Boolean.FALSE;
                try {
                    System.out.println("Írja be a kiválasztott áru mennyiségét!");
                    Scanner darabszam = new Scanner(System.in);
                    Integer db = darabszam.nextInt();
                    mennyiseg  = db;
                    if (mennyiseg <= 0) {
                        System.out.println("0-nál nagyobb számot adjon meg!");
                        javitsd = Boolean.TRUE;
                    }
                }
                catch (InputMismatchException kivetel) {
                    System.out.println("Nem adott meg mennyiséget!");
                    mennyiseg = 0;
                    javitsd   = Boolean.TRUE;
                }
            }
            while (javitsd == Boolean.TRUE);

            Rendeles ujtetel = new Rendeles(mennyiseg, aru);

            kosar.KosarbaTesz(ujtetel);

            System.out.println("A vásárlás folytatása: I = igen, bármi más = nem.");
            String valasz = eldont.nextLine();

            if (valasz.toUpperCase().equals(igen.getMegnevezes().toUpperCase())) {
                folytat = Boolean.TRUE;
            }
            else {
                folytat = Boolean.FALSE;
            }
        }
        while (folytat == Boolean.TRUE);

        System.out.println("A kosár tartalma. Ez termék-ismétlődéseket tartalmazhat: ");
        for (Rendeles lista : kosar.getKosar()) {
            KettoHarom kettoHarom_2   = new KettoHarom(lista.getDarabszam(), lista.getTermek().getEgysegar());
            MegaPack   megaPack_2     = new MegaPack((lista.getDarabszam()));
            Integer    kedvezmenyesar = 0;
            Integer    kulonbozet     = 0;
            if (lista.getTermek().getKedvezmeny() == kettoHarom_2.getMegnevezes()) {
                kedvezmenyesar = lista.getOsszesen() - kettoHarom_2.getKedvezmenyosszege();
                kulonbozet     = lista.getOsszesen() - kedvezmenyesar;
            }
            else {
                if (lista.getTermek().getKedvezmeny() == megaPack_2.getMegnevezes()) {
                    kedvezmenyesar = lista.getOsszesen() - megaPack_2.getKedvezmenyosszege();
                    kulonbozet     = lista.getOsszesen() - kedvezmenyesar;
                }
            }

            System.out.println("Neve: " + lista.getTermek().getMegnevezes() +
                    ". Mennyiség: " + lista.getDarabszam() +
                    ". Egységár: " + lista.getTermek().getEgysegar() +
                    ". Összesen ár: " + lista.getOsszesen() +
                    ". Kedvezmény neve: " + lista.getTermek().getKedvezmeny() +
                    ". Lehetséges kedvezményes ár: " + kedvezmenyesar +
                    ". Különbözet: " + kulonbozet);
        }

        //Példa a Set-re, INNEN:
        for (Rendeles lista : kosar.getKosar()) {
            kosarban.add(lista.getTermek().getMegnevezes());
        }

        System.out.println("A kosárban található áru(k) a következő(k). A számlán minden áru már csak egyszer fog szerepelni.");
        for (String mit : kosarban) {
            System.out.println(mit);
        }
        //Példa a Set-re, IDÁIG.

        /*
        Az alábbi rész azt demonstrálja, hogy a pénztárnál vagyunk:
        a szalagon fenn van minden áru, amelyeknek most állapítjuk meg a végleges mennyiségét.
        A vásárlás más-más időpillanataiban kosárba rakott termékeket termékfajtánként csoportosítjuk,
        majd összeszámoljuk. Hiszen a kosárra vonatkozó kedvezményt is csak így tudjuk megállapítani:
        */

        Boolean feluliras = Boolean.FALSE;

        for (Rendeles lezaras : kosar.getKosar()) {
            if (penztar.getKosarUres() == true) {
                penztar.KosarbaTesz(lezaras);
            }
            else {
                feluliras     = Boolean.FALSE;
                ciklusvaltozo = 0; //Az első index mindig a 0.
                //Ciklus a pénztár pillanatnyi állapotára, amelyet folyamatosan tölt fel a külső ciklus:
                for (Rendeles felulir : penztar.getKosar()) {
                    /*Szerepelt-e már az a termék a pénztárnál, amit most vettünk ki a kosárból?
                      Ha igen, akkor ennek mennyiségét hozzá kell adni a pénztárnál korábban már ellenőrzött ugyanilyen termék mennyiségéhez.*/
                    if (felulir.getTermek().getMegnevezes() == lezaras.getTermek().getMegnevezes()) {
                        feluliras = Boolean.TRUE;
                        break;
                    }
                    ciklusvaltozo = ciklusvaltozo + 1;
                }

                if (feluliras == Boolean.TRUE) {
                    Integer db1;
                    Integer db2;

                    //Le kell kérdeznünk a felülirandó rendelést. Ezt a "ciklusvaltozo" indexű elemnél találjuk:
                    Rendeles atmeneti = penztar.getAdottTermek(ciklusvaltozo);

                    db1               = atmeneti.getDarabszam();
                    db2               = lezaras.getDarabszam();

                    //Az új mennyiség meghatározása:
                    lezaras.setDarabszam(db1 + db2);

                    /*A pénztárnál törölnünk kell az eredeti rendelést, mert a pénztárhoz új rendelést teszünk:
                      a már ellenőrzött és a most talált azonos termék együttes darabszámát.
                      Mivel a termék a mennyiséggel együtt alkotja a rendelést, nem lehet a mennyiséggel felülírni
                      a korábbi rendelést, ezért kell azt törölni.*/
                    penztar.TermeketTorol(ciklusvaltozo);

                    //A pénztárhoz felvesszük a javított mennyiségű terméket, azaz az új rendelést:
                    penztar.KosarbaTesz(lezaras);
                }
                else {
                    penztar.KosarbaTesz(lezaras);
                }
            }
        }

        Ervenyesites ervenyesites = new Ervenyesites("semmi", 0, 0); //Az érvényesíthető kedvezmény.
        Ervenyesites vegosszeg    = new Ervenyesites("Összesen", 0, 0);

        System.out.println("A pénztárnál az alábbi tételek szerepelnek: ");
        for (Rendeles lista : penztar.getKosar()) {
            KettoHarom kettoharom     = new KettoHarom(lista.getDarabszam(), lista.getTermek().getEgysegar());
            MegaPack   megapack       = new MegaPack(lista.getDarabszam());
            Integer    kedvezmenyesar = 0;
            Integer    kulonbozet     = 0;
            if (lista.getTermek().getKedvezmeny() == kettoharom.getMegnevezes()) {
                kedvezmenyesar = lista.getOsszesen() - kettoharom.getKedvezmenyosszege();
                kulonbozet     = lista.getOsszesen() - kedvezmenyesar;
            }
            else {
                if (lista.getTermek().getKedvezmeny() == megapack.getMegnevezes()) {
                    kedvezmenyesar = lista.getOsszesen() - megapack.getKedvezmenyosszege();
                    kulonbozet     = lista.getOsszesen() - kedvezmenyesar;
                }
            }
            if (kulonbozet > ervenyesites.getOsszeg()) { //kedvezmenyesar > ervenyesites.getOsszeg()
                ervenyesites.setMegnevezes(lista.getTermek().getMegnevezes());
                ervenyesites.setOsszeg(kedvezmenyesar);
                ervenyesites.setKulonbozet(kulonbozet);
            }
            vegosszeg.setOsszeg(vegosszeg.getOsszeg() + lista.getOsszesen());

            System.out.println("Neve: " + lista.getTermek().getMegnevezes() +
                    ". Mennyiség: " + lista.getDarabszam() +
                    ". Egységár: " + lista.getTermek().getEgysegar() +
                    ". Összesen ár: " + lista.getOsszesen() +
                    ". Kedvezmény neve: " + lista.getTermek().getKedvezmeny() +
                    ". Lehetséges kedvezményes ár: " + kedvezmenyesar +
                    ". Különbözet: " + kulonbozet);
        }

        Integer kedvVegosszeg    = vegosszeg.getOsszeg() - ervenyesites.getKulonbozet(); //ervenyesites.getOsszeg();

        System.out.println("A számla tartalma: \n" +
                "Összesen: " + vegosszeg.getOsszeg() + " Ft \n" +
                "Érvényesíthető kedvezmény összege " + ervenyesites.getKulonbozet() + " Ft (Melyik termékből: " + ervenyesites.getMegnevezes() + ") \n" +
                "Fizetendő: " + kedvVegosszeg + " Ft");
    }
}
