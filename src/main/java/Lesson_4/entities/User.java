package Lesson_4.entities;

import java.util.List;

public class User {

    private String name;
    private CashHolder cashHolder;
    private Bag bag;

    public User(String name) {
        this.name = name;
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
        return this.cashHolder.getMoneyFromCashHolder(currency, sum);
    }

    public String getMoneyFromCashHolder() {
        return this.cashHolder.toString();
    }



}
