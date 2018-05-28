package generatortransakcjispring.generatortransakcji.services;

import generatortransakcjispring.generatortransakcji.components.Parser;
import generatortransakcjispring.generatortransakcji.logic.ParserParams;
import generatortransakcjispring.generatortransakcji.model.DataTransaction;
import generatortransakcjispring.generatortransakcji.model.Params;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TransactionService {


    private ParserParams parserParams;
    private Parser parser;

    public TransactionService() {
        this.parserParams = new ParserParams();
        this.parser=new Parser();
    }


    public List<DataTransaction> createParamsData(String customersId,
                                                  String dateRange,
                                                  String itemsCount,
                                                  String itemsQuantity,
                                                  String eventsCount) {
        Params params = parserParams.createParamsFromData(customersId,
                                                            dateRange,
                                                            itemsCount,
                                                            itemsQuantity,
                                                            eventsCount);
        return parser.parseParamsAndGetListDataTransaction(params);
    }
}
