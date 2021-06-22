package Lesson_4.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Seller extends User{

    private final Logger logger = LogManager.getLogger("Seller" + this.getName());


    public Seller(String name, List<Item> items) {
        super(name);
        this.itemsForSale = items;
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

    public Item sellItem(String name, List<Currency> currencies) {
        double amount = 0.0;

        for(Currency currency: currencies) {
           if(currency.getName().equals(curForSelling)) {
               amount+=currency.getNominal();
           }
        }

        return saleItem(name, amount);
    }

    public Item saleItem(String name, Double amount) {
        for (Item item: this.itemsForSale){
            if(item.getName().equals(name)){
                logger.info("Goods {} in", name);
                if(item.getPrice() == amount){
                    logger.info("Sold!");
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

}
