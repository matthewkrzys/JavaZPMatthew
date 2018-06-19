import model.CommandData;
import model.Element;
import model.ElementFile;
import model.JSONData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;


public class TestProjectTwoTwo {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void CommandData() {
        CommandData c = new CommandData();
        c.setCustomerID("12");
        String date = LocalTime.now().toString();
        c.setDateRange(date);
        c.setEventsCount("50");
        c.setOutDir("/output");
        c.setItemsCount("3:12");
        c.setItemsQuantity("4:5");
        c.setItemsFile("items.csv");
        Assert.assertTrue(!c.toString().isEmpty());
        Assert.assertTrue(c.getOutDir().equals("/output"));
        Assert.assertTrue(!c.getEventsCount().equals(""));
        Assert.assertTrue(c.getItemsFile().equals("items.csv") && c.getItemsQuantity().equals("4:5") && c.getItemsCount().equals("3:12"));
        Assert.assertTrue(c.getCustomerID().equals("12") && c.getDateRange().equals(date));
    }

    @Test
    public void Element() {
        Element e = new Element(
                "Name",
                6,
                5.0
        );
        Assert.assertTrue(!e.toString().isEmpty());
        Assert.assertTrue(e.price == 5.0);
    }

    @Test
    public void ElementFile() {
        ElementFile e = new ElementFile(
                "Name",
                5.0
        );
        Assert.assertTrue(e.name.equals("Name"));
    }

    @Test
    public void JSONData() {
        JSONData j = new JSONData(
                LocalTime.now().toString(),
                12,
                null,
                BigDecimal.valueOf(20.3)
        );
        Assert.assertTrue(!j.toString().isEmpty());
        Assert.assertTrue(j.customer_id == 12);
    }

    @Test
    public void ElementFileTest() {
        ElementFile elementFile = new ElementFile(
                "Beer",
                2.0
        );
        Assert.assertTrue(elementFile.name.equals("Beer") && elementFile.price == 2.0);
    }

}
