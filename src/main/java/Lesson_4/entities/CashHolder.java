package Lesson_4.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CashHolder extends BaseEntity{

    public CashHolder(String loggerName) {
        super(loggerName);
    }

    private Map<String, List<Currency>> cash = new HashMap<>();

    public List<String> showCurrencies() {
        return this.cash.keySet().stream().toList();
    }

    public List<Currency> getAllMoney() {
        List<Currency> result = new ArrayList<>();

        this.cash.forEach((key, val) -> result.addAll(val));

        return result;
    }


    public List<Currency> getCashInCurrency(String currency) {
        return this.cash.get(currency) != null
                ? this.cash.get(currency) : new ArrayList<>();
    }

    public CashHolder putMoneyToCashHolder(String currencyName, List<Currency> money) {
        this.cash.put(currencyName, money);
        return this;
    }

    public CashHolder putMoneyToCashHolder(List<Currency> money) {
        if (!money.isEmpty()){
            money.stream()
                    .map(Currency::getName)
                    .distinct()
                    .forEach(name -> {
                        List<Currency> temp = money.stream()
                                .filter(currency -> currency
                                        .getName()
                                        .equals(name))
                                .collect(Collectors.toList());
                        this.cash.put(name, temp);
                    });
        }
        return this;
    }

    public CashHolder putMoneyToCashHolder(Currency currency, Double sum){
        int intSum = sum.intValue();
        double doubleSum = sum % 1.00;
        List<Double> range = new ArrayList<>();
        for (int i = 0; i < intSum; i++){
            range.add(1.00);
        }
        if (doubleSum != 0.0){
            range.add(doubleSum);
        }
        String name = currency.getName();
        List<Currency> temp = new ArrayList<>();
        for (Double nominal: range) {
            Currency tempCur = currency.clone();
            tempCur.setNominal(nominal);
            temp.add(tempCur);
        }
        this.cash.put(name, temp);
        logger.info("Cash {}: {} available", currency.getName(), sum);
        return this;
    }


    public List<Currency> getMoneyFromCashHolder(String currencyName, double sumOfMoney){
        List<Currency> result = this.cash.get(currencyName);

        if(result != null && !result.isEmpty()){
            double currentSumOfCurrencyInCashHolder = 0;

            for(Currency currency: result){
                currentSumOfCurrencyInCashHolder += currency.getNominal();
            }

            if(currentSumOfCurrencyInCashHolder < sumOfMoney){
                logger.info("Available sum {} low than {}. Return all cash",
                        currentSumOfCurrencyInCashHolder,
                        sumOfMoney);
                return result;
            } else {
                int intSum = (int) sumOfMoney;
                double doubleSum = sumOfMoney % 1.00;
                List<Double> range = new ArrayList<>();
                for (int i = 0; i < intSum; i++){
                    range.add(1.00);
                }
                if (doubleSum != 0.0){
                    range.add(doubleSum);
                }
                List<Currency> returnedCurrency = new ArrayList<>();
                double returnedSum = 0;
                for (int i = 0; i < range.size(); i++) {
                    if (returnedSum < sumOfMoney) {
                        Currency currency = result.get(i);
                        Currency tempCur = currency.clone();
                        tempCur.setNominal(range.get(i));
                        returnedCurrency.add(tempCur);
                        if (range.get(i) != 1) {
                            currency.setNominal(currency.getNominal() - range.get(i));
                        } else {
                            result.remove(currency);
                        }
                        returnedSum += range.get(i);
                    } else {
                        break;
                    }
                }

                double balance = 0;
                for (Currency rest:
                     result) {
                    balance += rest.getNominal();
                }
                logger.info("Requested sum {}: {} returned. Balance: {}",
                        currencyName, sumOfMoney, balance);
                return returnedCurrency;
            }
        } else {
            return new ArrayList<>();
        }
    }


    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{\n\"Sum in holder\": \n");
        this.cash.forEach((k, v) -> builder.append("\"").
                append(k).
                append(": ").
                append(v.size()).
                append(",\n"));
        builder.append("}");
        return builder.toString();
    }


}
