import com.external.PaymentsService;
import com.internal.DiscountCalculator;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile","/home/matthew/Desktop/javaZP/JavaZPMatthew/LoggersHell/src/main/resources/log4j2.xml");
        Logger logger = LoggerFactory.getLogger(MainClass.class);
        logger.debug("Start");
        BasicConfigurator.configure();
        DiscountCalculator discountCalculator = new DiscountCalculator();
        PaymentsService paymentsService = new PaymentsService();
        BigDecimal ticketPrice = parseToBigDecimal(args[0]);
        int customerAge = parseToInt(args[1]);
        long customerID = parseToLong(args[2]);
        long companyID = parseToLong(args[3]);

        BigDecimal discountValue = discountCalculator.calculateDiscount(ticketPrice, customerAge);

        boolean paymentMade = paymentsService.makePayment(customerID, companyID, ticketPrice.subtract(discountValue));
        if (paymentMade)
            System.out.println("Payment successfully");
        else
            System.out.println("Problem occured. Please, try again");

        logger.info("DONE!");
    }
    private static BigDecimal parseToBigDecimal(String s){
      return BigDecimal.valueOf(Double.parseDouble(s));
    }
    private static Long parseToLong(String s){
        return Long.parseLong(s);
    }
    private static Integer parseToInt(String s){
        return Integer.parseInt(s);
    }
}
