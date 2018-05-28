package generatortransakcjispring.generatortransakcji.logic;


import generatortransakcjispring.generatortransakcji.model.Params;


public class ParserParams {



    public Params createParamsFromData(String customersId,
                                       String dateRange,
                                       String itemsCount,
                                       String itemsQuantity,
                                       String eventsCount){
        Params params=new Params();
        if(!customersId.isEmpty()){
            params.setCustomerID(customersId);
        }
        if(!dateRange.isEmpty()){
            params.setDateRange(dateRange);
        }
        if(!itemsCount.isEmpty()){
            params.setItemsCount(itemsCount);
        }
        if(!itemsQuantity.isEmpty()){
            params.setItemsQuantity(itemsQuantity);
        }
        if(!eventsCount.isEmpty()){
            params.setEventsCount(eventsCount);
        }
        return params;
    }
}
