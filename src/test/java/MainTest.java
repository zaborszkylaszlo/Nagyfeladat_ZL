import hu.gov.allamkincstar.zaborszky_laszlo.aruhaz.Aru;
import hu.gov.allamkincstar.zaborszky_laszlo.aruhaz.KettoHarom;
import hu.gov.allamkincstar.zaborszky_laszlo.aruhaz.MegaPack;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class MainTest {
    @Test
    public void tesztAru() {
        KettoHarom kettoHarom_1  = new KettoHarom();
        MegaPack megaPack_1      = new MegaPack();

        Aru teliszalami   = new Aru("téliszalámi", "té", kettoHarom_1.getMegnevezes(), 2000);
        Aru gumikacsa     = new Aru("gumikacsa", "gu", kettoHarom_1.getMegnevezes(), 3000);
        Aru uborka        = new Aru("uborka", "ub", megaPack_1.getMegnevezes(), 2800);
        Aru gesztenye     = new Aru("gesztenye", "ge", megaPack_1.getMegnevezes(), 1000);

        Assert.assertThat(teliszalami.getMegnevezes().equals("téliszalámi"), is(true));
        Assert.assertThat(gumikacsa.getMegnevezes().equals("gumikacsa"), is(true));
        Assert.assertThat(uborka.getMegnevezes().equals("uborka"), is(true));
        Assert.assertThat(gesztenye.getMegnevezes().equals("gesztenye"), is(true));

    }


}
