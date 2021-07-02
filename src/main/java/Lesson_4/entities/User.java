package Lesson_4.entities;

import java.util.ArrayList;
import java.util.List;


// TODO: 24.06.2021 Need to add logger

public class User extends BaseEntity{

    private String name;
    private CashHolder cashHolder;
    private Bag bag;

    public User(String name) {
        super(name);
        this.name = name;
        this.cashHolder = new CashHolder( name + " User cashHolder");
        this.bag = new Bag(name + " User bag");
        logger.debug("{} {} created",this.getClass().getName(), name);
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setCashHolder(CashHolder cashHolder) {
        this.cashHolder = cashHolder;
        return this;
    }

    public Bag getBag() {
        return bag;
    }

    public User setBag(Bag bag) {
        this.bag = bag;
        return this;
    }

    public User putMoneyToCashHolder(Currency currency, Double sum){
        logger.info("Put money {}: {} to {}",
                currency.getName(), sum, this.cashHolder.getClass().getSimpleName());
        this.cashHolder.putMoneyToCashHolder(currency, sum);
        return this;
    }


    public User putMoneyToCashHolder(String name, List<Currency> money) {
        this.cashHolder.putMoneyToCashHolder(name, money);
        return this;
    }

    public User putMoneyToCashHolder(List<Currency> money) {
        this.cashHolder.putMoneyToCashHolder(money);
        return this;
    }

    public List<Currency> getMoneyFromCashHolder(String currency, double sum) {
        logger.info("Out money {}: {}", currency, sum);
        return this.cashHolder.getMoneyFromCashHolder(currency, sum);
    }

    public String getCountMoneyFromCashHolder() {
        return this.cashHolder.toString();
    }

    public User putItemInBag(Item item) {
        this.bag.putItem(item);
        return this;
    }


    public User putItemsInBag(List<Item> items) {
        this.bag.putItems(items);
        return this;
    }

    public List<String> getCurrencies() {
        return this.cashHolder.showCurrencies();
    }

    public User changeCurrencyAndSaveIt(String convertTo, List<Currency> cash, Bank bank) {
        List<Currency> newCash = new ArrayList<>();

        if (convertTo.equals("UAH")){
            newCash = bank.changeToUah(cash);
        } else {
            newCash = bank.changeFromUah(convertTo, cash);
        }

        this.cashHolder.putMoneyToCashHolder(newCash);

        return this;
    }

    public User changeCurrencyAndSaveIt(String convertTo, Bank bank) {
        return changeCurrencyAndSaveIt(convertTo, this.cashHolder.getAllMoney(), bank);
    }


}


















