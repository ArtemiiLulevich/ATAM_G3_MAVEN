package Lesson_2;

import Lesson_3.UserStatus;
import models.Currency;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application_2 {

    private final static Logger LOGGER = LogManager.getLogger("Second Application");

    public static void main(String[] args) {

        User admin = new User(
                "Admin",
                "password",
                "System Admin")
                .setStatus(UserStatus.VERY_BAD)
                .setCurrency(new ArrayList<Currency>(){
                    {
                        add(new Currency("UAH"));
                        add(new Currency("USD"));
                        add(new Currency("EUR"));
                    }
                });

        User user = new User(
                "User",
                "password",
                "System user")
                .setStatus(UserStatus.GOOD)
                .setCurrency(new ArrayList<Currency>(){
            {
                add(new Currency("PZL"));
                add(new Currency("TEN"));
                add(new Currency("GRP"));
            }
        });

//        Printer.printUserData(admin);
//        System.out.println("==============================");
//        Printer.printUserData(user);

//        Order order = new Order(124, "asdasrqrw435", new Date());

//        List<Parent> users = new ArrayList<>();
//        users.add(admin);
//        users.add(user);
//        users.add(new Currency("UAH"));


//        users.forEach(Printer::printData);
//        System.out.println("Admin have "
//                + admin.getCurrency().size()
//                + " count of currency");
//        admin.getCurrency().forEach(System.out::println);
//        System.out.println(admin.getCurrency().getName());

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(admin);


        LOGGER.info(UserStatus.GOOD.getName());

//        System.out.println(UserStatus.GOOD.getName());

//        users.stream()
//                .filter(user1 -> user1.getStatus() == UserStatus.GOOD)
//                .forEach(user1 -> System.out.println(user1.getUsername()));


//        List<CanMakePayment> paymentUsers = new ArrayList<>();
//        paymentUsers.add(admin);
//        paymentUsers.add(user);
//
//        paymentUsers.forEach(entity -> {
//
//            entity.makeTransaction(new Currency("USD"), 20);
//            entity.showCurrency();
//        });

    }

}
