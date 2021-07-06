import Lesson_4.entities.CashHolder;
import Lesson_4.entities.Currency;

public class Debug {

    public static void main(String[] args) {
//        Bank bank = new Bank("Bank");
//
//        List<Currency> currencies = new ArrayList<>();
//        currencies.add(new Currency("USD").setNominal(2.00));
//        currencies.add(new Currency("USD").setNominal(2.00));
//        currencies.add(new Currency("USD").setNominal(2.50));
//        currencies.add(new Currency("EUR").setNominal(2.0));
//        currencies.add(new Currency("EUR").setNominal(2.0));
//        currencies.add(new Currency("EUR").setNominal(2.0));
//        currencies.add(new Currency("EUR").setNominal(0.3));
//
//
//        System.out.println("Count of UAH: " + bank.changeFromUah("USD", bank.changeToUah(currencies)));

        CashHolder holder = new CashHolder("Just cashHolder");

        holder.putMoneyToCashHolder(new Currency("UAH"), 2.5);

        System.out.println(holder.getMoneyFromCashHolder("UAH", 2.50));

    }

}
