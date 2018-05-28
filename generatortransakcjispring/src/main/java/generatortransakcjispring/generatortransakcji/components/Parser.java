package generatortransakcjispring.generatortransakcji.components;

import generatortransakcjispring.generatortransakcji.logic.GetItemsFromApi;
import generatortransakcjispring.generatortransakcji.logic.RandomData;
import generatortransakcjispring.generatortransakcji.model.DataTransaction;
import generatortransakcjispring.generatortransakcji.model.Params;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<DataTransaction> ListDataTransaction;
    private BigDecimal sumPrice;
    private GetItemsFromApi getItemsFromApi;
    public DataTransaction dataTransaction;
    RandomData generate;

    public Parser(){
        generate=new RandomData();
        getItemsFromApi=new GetItemsFromApi();
    }

    public List<DataTransaction> parseParamsAndGetListDataTransaction(Params params) {
        ListDataTransaction=new ArrayList();
        String[] tCustomerID = params.getCustomerID().split(":");
        String[] tDataRange = params.getDateRange().replace("\"","").split(":");
        String[] tItemCount = params.getItemsCount().split(":");
        int ItemCount;
        String[] tItemQuantity = params.getItemsQuantity().split(":");
        int count = Integer.parseInt(params.getEventsCount());
        for (int i = 1; i <= count; i++) {
            sumPrice=BigDecimal.valueOf(0);
            ItemCount = generate.randomGenerate(Integer.parseInt(tItemCount[1]), Integer.parseInt(tItemCount[0]));
            dataTransaction=new DataTransaction(
                    generate.generatedata(tDataRange[0]+":"+tDataRange[1]+":"+tDataRange[2],tDataRange[3]+":"+tDataRange[4]+":"+tDataRange[5]),
                    generate.randomGenerate(Integer.parseInt(tCustomerID[1]), Integer.parseInt(tCustomerID[0])),
                    getItemsFromApi.getItems(ItemCount, Integer.parseInt(tItemQuantity[1]), Integer.parseInt(tItemQuantity[0])),
                    sumPrice
            );
            ListDataTransaction.add(dataTransaction);
        }
        return ListDataTransaction;
    }

}
