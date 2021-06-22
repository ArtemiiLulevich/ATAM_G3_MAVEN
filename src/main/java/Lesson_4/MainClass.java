package Lesson_4;

import Lesson_4.entities.CashHolder;
import Lesson_4.entities.Currency;
import Lesson_4.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    private final static Logger LOGGER = LogManager.getLogger(MainClass.class);


    public static void main(String[] args) {

        User seller = new User("Vasili")
                .setCashHolder(new CashHolder()
                        .putMoneyToCashHolder(new Currency("UAH"), 25.5)
                        .putMoneyToCashHolder(new Currency("USD"), 2.00)
                        .putMoneyToCashHolder(new Currency("EUR"), 2.00));
        User buyer = new User("Evgen")
                .setCashHolder(new CashHolder());


        List<Currency> sumOfMoney = new ArrayList<>(){{
           addAll(seller.getMoneyFromCashHolder("UAH", 15));
           addAll(seller.getMoneyFromCashHolder("USD", 1));
           addAll(seller.getMoneyFromCashHolder("EUR", 1));
        }};


        buyer.putMoneyToCashHolder(sumOfMoney);


        LOGGER.info(buyer.getMoneyFromCashHolder());

//        client.getMoneyFromCashHolder("EUR", 30.00)
//                .forEach(currency -> System.out.println(currency.getNominal()));
    }

}
