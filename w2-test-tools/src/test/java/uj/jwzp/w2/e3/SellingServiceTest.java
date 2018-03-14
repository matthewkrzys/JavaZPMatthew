package uj.jwzp.w2.e3;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import uj.jwzp.w2.e3.external.DiscountsConfig;
import uj.jwzp.w2.e3.external.PersistenceLayer;

import java.math.BigDecimal;

@RunWith(PowerMockRunner.class)
public class SellingServiceTest {

    @Mock
    private PersistenceLayer persistenceLayer;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void notSell() {
        //given
        SellingService uut = new SellingService(persistenceLayer);
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Item i = new Item("i", new BigDecimal(3));
        Customer c = new Customer(1, "DasCustomer", "Kraków, Łojasiewicza");

        //when
        boolean sold = uut.sell(i, 7, c);

        //then
        Assert.assertFalse(sold);
        Assert.assertEquals(BigDecimal.valueOf(10), uut.moneyService.getMoney(c));
    }

    @Test
    public void sell() {
        //given
        SellingService uut = new SellingService(persistenceLayer);
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Item i = new Item("i", new BigDecimal(3));
        Customer c = new Customer(1, "DasCustomer", "Kraków, Łojasiewicza");

        //when
        boolean sold = uut.sell(i, 1, c);

        //then
        Assert.assertFalse(sold);
        Assert.assertEquals(BigDecimal.valueOf(7), uut.moneyService.getMoney(c));
    }

    @Test
//    @PrepareForTest(DiscountsConfig.class)
    public void sellALot() {
        //given
        SellingService uut = new SellingService(persistenceLayer);
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Item i = new Item("i", new BigDecimal(3));
        Customer c = new Customer(1, "DasCustomer", "Kraków, Łojasiewicza");
        uut.moneyService.addMoney(c, new BigDecimal(990));

        //when
        boolean sold = uut.sell(i, 10, c);

        //then
        Assert.assertFalse(sold);
        Assert.assertEquals(BigDecimal.valueOf(970), uut.moneyService.getMoney(c));
    }

    @Test
    public void customerTest(){
        Customer c = new Customer(2,"Adam","Krzywa 7");
        int numberId=2;
        String name="Adam";
        Assert.assertEquals(numberId,c.getId());
        Assert.assertEquals(name,c.getName());
    }
    @Test
    public void itemTest(){
        Item i=new Item("Makaron",BigDecimal.valueOf(10));
        String name="Makaron";
        Assert.assertEquals(name,i.getName());
    }

    @Test
    public void getMoneyTest(){
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Customer c = new Customer(1, "DasCustomer", "Kraków, Łojasiewicza");
        CustomerMoneyService customerMoneyService=new CustomerMoneyService(persistenceLayer);
        Assert.assertEquals(BigDecimal.valueOf(10),customerMoneyService.getMoney(c));
    }

    @Test
    public void payTest(){
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Customer c = new Customer(1, "Cosiek", "Kraków, Łojasiewicza");
        CustomerMoneyService customerMoneyService=new CustomerMoneyService(persistenceLayer);
        boolean var=customerMoneyService.pay(c,BigDecimal.valueOf(10));
        Assert.assertTrue(var);
    }

    @Test
    public void addMoneyTest(){
        Mockito.when(persistenceLayer.saveCustomer(Mockito.any())).thenReturn(Boolean.TRUE);
        Customer c = new Customer(1, "Ktosiek", "Kraków, Ruczaj");
        CustomerMoneyService customerMoneyService=new CustomerMoneyService(persistenceLayer);
        customerMoneyService.addMoney(c,BigDecimal.valueOf(10));
        Assert.assertEquals(BigDecimal.valueOf(20),customerMoneyService.getMoney(c));
    }


}
