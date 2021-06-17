package Lesson_4;

import Lesson_4.entities.CashHolder;
import Lesson_4.entities.Currency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private final static Logger LOGGER = LogManager.getLogger(MainClass.class);


    public static void main(String[] args) {
        CashHolder holder = new CashHolder();

        holder.putCashToCashHolder(new Currency("UAH"), 25.5);

        LOGGER.info(holder.getMoneyFromCashHolder(
                "UAH",
                20.00).size());

    }

}
