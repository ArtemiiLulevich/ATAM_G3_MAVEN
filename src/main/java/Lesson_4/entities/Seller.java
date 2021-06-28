package Lesson_4.entities;

import java.util.List;

public class Seller extends User{
    private CashHolder cashHolder;

    public Seller(String name, List<Item> items) {
        super(name);
        this.itemsForSale = items;
        this.cashHolder = new CashHolder("Seller cashHolder" + name);
        logger.debug("Seller {} created ", name);
        logger.info("Seller {} can sale items {}", name, this.itemsForSale);
    }

    private List<Item> itemsForSale;
    private final String curForSelling = "UAH";

    public List<Item> getItemsForSale() {
        return itemsForSale;
    }

    public Seller setItemsForSale(List<Item> itemsForSale) {
        this.itemsForSale = itemsForSale;
        return this;
    }

    @Override
    public Seller setCashHolder(CashHolder cashHolder) {
        this.cashHolder = cashHolder;
        return this;
    }


    public Item saleItem(String itemName, List<Currency> currencies) {
        double amount = 0.0;
        logger.info("Get {}", curForSelling);
        for(Currency currency: currencies) {
           if(currency.getName().equals(curForSelling)) {
               amount+=currency.getNominal();
           }
        }

        return saleItem(itemName, amount);
    }

    public Item saleItem(String name, Double amount) {
        for (Item item: this.itemsForSale){
            if(item.getName().equals(name)){
                logger.info("Goods {} in", name);
                if(item.getPrice() == amount){
                    logger.info("Sold!");
                    this.cashHolder.putMoneyToCashHolder(new Currency(curForSelling), amount);
                    return item;
                } else if (item.getPrice() < amount) {
                    logger.info("To much money to buy item. {}",
                            item.getPrice() - amount);
                    return null;
                } else {
                    logger.info("To low money. {}", amount - item.getPrice());
                    return null;
                }
            }
        }
        logger.info("I don't have this item.");
        return null;
    }

    public void showProfit() {
        logger.info("Sum is {}",
                this.cashHolder.getCashInCurrency(curForSelling).size());
    }

}
