import Lesson_4.entities.Bank;
import Lesson_4.entities.Currency;

import java.util.ArrayList;
import java.util.List;

public class Debug {

    public static void main(String[] args) {
        Bank bank = new Bank("Bank");

        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("USD").setNominal(2.00));
        currencies.add(new Currency("USD").setNominal(2.00));
        currencies.add(new Currency("USD").setNominal(2.50));
        currencies.add(new Currency("EUR").setNominal(2.0));
        currencies.add(new Currency("EUR").setNominal(2.0));
        currencies.add(new Currency("EUR").setNominal(2.0));
        currencies.add(new Currency("EUR").setNominal(0.3));


        System.out.println("Count of UAH: " + bank.changeFromUah("USD", bank.changeToUah(currencies)));

    }

}
