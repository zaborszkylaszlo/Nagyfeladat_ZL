import hu.gov.allamkincstar.zaborszky_laszlo.aruhaz.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class MainTest {
    KettoHarom kettoHarom_1  = new KettoHarom();
    MegaPack megaPack_1      = new MegaPack();

    Aru teliszalami   = new Aru("téliszalámi", "té", kettoHarom_1.getMegnevezes(), 2000);
    Aru gumikacsa     = new Aru("gumikacsa", "gu", kettoHarom_1.getMegnevezes(), 3000);
    Aru uborka        = new Aru("uborka", "ub", megaPack_1.getMegnevezes(), 2800);
    Aru gesztenye     = new Aru("gesztenye", "ge", megaPack_1.getMegnevezes(), 1000);

    public Kosar kosar       = new Kosar();

    @Test
    public void tesztVasarlas() {
        Assert.assertThat(teliszalami.getMegnevezes().equals("téliszalámi"), is(true));
        Assert.assertThat(gumikacsa.getMegnevezes().equals("gumikacsa"), is(true));
        Assert.assertThat(uborka.getMegnevezes().equals("uborka"), is(true));
        Assert.assertThat(gesztenye.getMegnevezes().equals("gesztenye"), is(true));

        Rendeles ujtetel_1 = new Rendeles(10, gumikacsa);
        kosar.KosarbaTesz(ujtetel_1);

        Rendeles ujtetel_2 = new Rendeles(11, teliszalami);
        kosar.KosarbaTesz(ujtetel_2);

        Rendeles ujtetel_3 = new Rendeles(3, gumikacsa);
        kosar.KosarbaTesz(ujtetel_3);

        Rendeles ujtetel_4 = new Rendeles(33, gesztenye);
        kosar.KosarbaTesz(ujtetel_4);

        Rendeles ujtetel_5 = new Rendeles(5, teliszalami);
        kosar.KosarbaTesz(ujtetel_5);

        Rendeles ujtetel_6 = new Rendeles(2, uborka);
        kosar.KosarbaTesz(ujtetel_6);

        Assert.assertThat(kosar.getAdottTermek(0).getDarabszam().equals(ujtetel_1.getDarabszam()), is(true));
        Assert.assertThat(kosar.getAdottTermek(1).getDarabszam().equals(ujtetel_2.getDarabszam()), is(true));
        Assert.assertThat(kosar.getAdottTermek(2).getDarabszam().equals(ujtetel_3.getDarabszam()), is(true));
        Assert.assertThat(kosar.getAdottTermek(3).getDarabszam().equals(ujtetel_4.getDarabszam()), is(true));
        Assert.assertThat(kosar.getAdottTermek(4).getDarabszam().equals(ujtetel_5.getDarabszam()), is(true));
        Assert.assertThat(kosar.getAdottTermek(5).getDarabszam().equals(ujtetel_6.getDarabszam()), is(true));

    }






}
