package Lesson_4.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank extends BaseEntity{
    public Bank(String loggerName) {
        super(loggerName);
    }

    private final static String BASE_CURRENCY = "UAH";

    private final Map<String, Double[]> currencyCourse = new HashMap<>(){{
        put("USD", new  Double[]{28.5, 27.5});
        put("EUR", new  Double[]{30.5, 31.5});
    }};

    public List<Currency> changeFromUah(String reqCur, List<Currency> uahs) {
        List<Currency> result = new ArrayList<>();

        if(currencyCourse.containsKey(reqCur)){
            List<Currency> uahList = uahs.stream()
                    .filter(currency -> currency.getName().equals(BASE_CURRENCY))
                    .collect(Collectors.toList());


            double course = currencyCourse.get(reqCur)[1];

            int tempNominal = 0;

            for (Currency uah: uahList
                 ) {
                tempNominal +=uah.getNominal();
                if(tempNominal == course) {
                    result.add(new Currency(reqCur).setNominal(1));
                }
            }

        }


        return result;
    }


}

