package generatortransakcjispring.generatortransakcji.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import generatortransakcjispring.generatortransakcji.model.Element;
import generatortransakcjispring.generatortransakcji.model.Items;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GetItemsFromApi {
    private final String URL="https://csv-items-generator.herokuapp.com/items";

    private RandomData generate;
    private BigDecimal sumPrice;

    public GetItemsFromApi() {
        generate=new RandomData();
    }

    public List<Element> getItems(int itemCount, int maxValueQuantity, int minValueQuantity) {
        List<Element> elementList = new ArrayList<>();
        List<Items> itemsList = ItemsFromApi();
        sumPrice=BigDecimal.valueOf(0);
        for (int i = 0; i < itemCount; i++) {
            Element e = new Element(
                    itemsList.get(i % itemsList.size()).getName(),
                    generate.randomGenerate(maxValueQuantity, minValueQuantity),
                    BigDecimal.valueOf(itemsList.get(i % itemsList.size()).getPrice())
            );
            elementList.add(e);
            sumPrice.subtract(e.getPrice().multiply(BigDecimal.valueOf(e.getQuantity())));
        }
        return elementList;
    }

    public List<Items> ItemsFromApi() {
        List<Items> list=null;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(URL);
        request.addHeader("accept", "application/json");
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream stream = entity.getContent()) {
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(stream));
                    String strJson="";
                    String line;
                    while ((line = reader.readLine()) != null) {
                        strJson+=line;
                    }
                    list=new  ArrayList<>();
                    ObjectMapper mapper = new ObjectMapper();
                    String[] arrayStrJson=strJson
                            .replace("[","")
                            .replace("]","")
                            .replace("},{","};{")
                            .split(";");
                    for (String s:arrayStrJson
                         ) {
                        Items obj = mapper.readValue(s, Items.class);
                        list.add(obj);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
