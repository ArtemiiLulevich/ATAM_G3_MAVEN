package Lesson_4;

import Lesson_4.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static Lesson_4.helper.FileHelper.readFile;
import static java.lang.Double.parseDouble;

public class MainClass {

    private final static Logger LOGGER = LogManager.getLogger("Program");


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);

        List<Item> itemsForSale = new ArrayList<>();

        LOGGER.info("Enter an item name");
        String itemName = scanner.nextLine();

        LOGGER.info("Enter item price");
        double price = scanner.nextDouble();



        itemsForSale.add(new Item(itemName,price));

        LOGGER.info("Enter seller name");
        String sellerName = scanner.nextLine();

        Seller seller = new Seller(sellerName, itemsForSale);


        LOGGER.info("Enter buyer name");
        String buyerName = scanner.nextLine();
        User buyer = new User(buyerName);


        LOGGER.info("Enter buyer currency");
        String buyerCurrency = scanner.nextLine();

        LOGGER.info("Enter buyer sum");
        double buyerSum = scanner.nextDouble();

        buyer.putMoneyToCashHolder(new Currency(buyerCurrency), buyerSum);

        LOGGER.info("Enter item to buy name");
        String itemForSelling = scanner.nextLine();

        LOGGER.info("Enter sum to buy");
        double sum = scanner.nextDouble();

        LOGGER.info("Currency to buy");
        String cur = scanner.nextLine();*/

        List<String> data = readFile("C:\\Users\\artem\\IdeaProjects\\" +
                "ATAM_G3_MAVEN\\src\\main\\resources\\data\\app-data.txt");

        List<Item> itemsForSelling = new ArrayList<>();
        Bank bank = new Bank(valueFromString(lineByName("Bank", data)));


        itemsForSelling.add(new Item(
                valueFromString(lineByName("Seller item", data)),
                doubleValue("Item price", data)
                )
        );


        Seller seller = new Seller(valueFromString(lineByName("Seller name", data)),
                itemsForSelling);
        User buyer = new User(valueFromString(lineByName("Buyer name", data)));

        buyer.putMoneyToCashHolder(new Currency(
                valueFromString(lineByName("Buyer currency", data))),
                doubleValue("Buyer money", data));

        buyer.changeCurrencyAndSaveIt("UAH", bank);


        List<Currency> buyerMoney = buyer.getMoneyFromCashHolder("UAH", doubleValue("Price", data));


        buyer.putItemInBag(
                seller.saleItem(valueFromString(lineByName("Buyer buys", data)), buyerMoney));

        buyer.getBag().showBagEntry();

//        scanner.close();
//        LOGGER.info(buyer.getCountMoneyFromCashHolder());

    }

    private static String valueFromString(String line) {
        try {
            return line.split(": ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.error(e);
            return line;
        }
    }


    private static String lineByName(String name, List<String> lines) {
        String result = lines.stream()
                                .filter(line -> line.startsWith(name))
                                .findFirst()
                                .orElse("");

        if (result.equals("")) {
            LOGGER.error("In list where are no such line {}. Empty string returns.", name);
        }
        return result;
    }

    private static Double doubleValue (String name, List<String> lines) {
        return parseDouble(
                valueFromString(lineByName(name, lines).equals("")
                ? " :  ": lineByName(name, lines)).equals(" ")
                ? "0.00": valueFromString(lineByName(name, lines)));
    }
}
