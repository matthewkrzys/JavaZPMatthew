package uj.jwzp.w2.e3;

import uj.jwzp.w2.e3.external.DiscountsConfig;
import uj.jwzp.w2.e3.external.PersistenceLayer;

import java.math.BigDecimal;

public class SellingService {

    private final PersistenceLayer persistenceLayer;
    final CustomerMoneyService moneyService;

    public SellingService(PersistenceLayer persistenceLayer) {
        this.persistenceLayer = persistenceLayer;
        this.persistenceLayer.loadDiscountConfiguration();
        this.moneyService = new CustomerMoneyService(this.persistenceLayer);
    }

    public boolean sell(Item item, int quantity, Customer customer) {
        BigDecimal money = moneyService.getMoney(customer);
        BigDecimal price = getMultiply(quantity,item,customer);
        if (DiscountsConfig.isWeekendPromotion() && price.compareTo(BigDecimal.valueOf(5)) > 0) {
//            price = price.subtract(BigDecimal.valueOf(3));
        }
        boolean sold = moneyService.pay(customer, price);
        if (sold) {
            return persistenceLayer.saveTransaction(customer, item, quantity);
        } else {
            return sold;
        }
    }
    private BigDecimal getPriceItem(Item item){
        return item.getPrice();
    }
    private BigDecimal getSubtract(Item item,Customer customer){
        return getPriceItem(item).subtract(DiscountsConfig.getDiscountForItem(item, customer));
    }
    private BigDecimal getMultiply(int quantity,Item item,Customer customer){
        return getSubtract(item, customer).multiply(BigDecimal.valueOf(quantity));
    }

}
