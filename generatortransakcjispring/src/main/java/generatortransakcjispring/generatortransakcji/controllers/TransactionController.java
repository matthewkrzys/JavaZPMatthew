package generatortransakcjispring.generatortransakcji.controllers;

import generatortransakcjispring.generatortransakcji.model.DataTransaction;
import generatortransakcjispring.generatortransakcji.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transaction",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml", "application/yaml"},
            params = {"customersId", "dateRange", "itemsCount", "itemsQuantity", "eventsCount"})
    @ResponseBody
    public List<DataTransaction> getItems(@RequestParam("customersId") String customersId,
                                          @RequestParam("dateRange") String dateRange,
                                          @RequestParam("itemsCount") String itemsCount,
                                          @RequestParam("itemsQuantity") String itemsQuantity,
                                          @RequestParam("eventsCount") String eventsCount) {

        return transactionService.createParamsData(customersId,
                                                    dateRange,
                                                    itemsCount,
                                                    itemsQuantity,
                                                    eventsCount);
    }
}
/*
localhost:8080/transaction?customersId=1:2&dateRange="2018-03-08T00:00:00.000-0100":"2018-03-08T23:59:59.999-0100"&itemsCount=1:2&itemsQuantity=1:2&eventsCount=10
 */
