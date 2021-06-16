package Lesson_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {


    private final static Logger LOGGER = LogManager.getLogger("First Application");
    int a = 7;
    static int b = 6;

    public static void main(String[] args) {
//        System.out.println("Hello world!");

        int h = 65;
        short s = 0;
        double d = 0.4562;
        float f = 0;
        long l = 0L;

        int[] my_array = {1, 2, 3, 4, 5};

        try {
            my_array[10] = 10;
        } catch (Exception e){
            LOGGER.error(e);
        } finally {
            LOGGER.info("Bla");
        }

//        Lesson_1.Calc calc = new Lesson_1.Calc();
//
//        if (calc.sum(d, h) > 70){
//            System.out.println("More");
//        } else if (calc.sum(d, h) == 70){
//            System.out.println("Equal");
//        } else {
//            System.out.println("Less");
//        }

        String[] strings = new String[]{"one", "two", "three", "four"};

//        for (int a = 0; a < strings.length; a++){
//            System.out.println(strings[a]);
//        }// forEach analog

//        for (String num: strings){
//            System.out.println(num);
//        }//forEach

        List<Integer> list_ints = new ArrayList<>();

        list_ints.add(1);
        list_ints.add(2);
        list_ints.add(7);
        list_ints.add(10);

        List<Integer> integers_1 = list_ints;

        integers_1.remove(1);



//        System.out.println(list_ints);
//        System.out.println(integers_1);

//        integers_1.forEach(System.out::println);

//        List<String> result = Arrays.stream(strings)
//                .filter(number -> number.contains("o"))
//                .map(number -> "> " + number)
//                .collect(Collectors.toList());
//
//
//        System.out.println(result);

        Map<Integer, String> numbers = new HashMap<>();// LIke dict in Python

        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");

//        System.out.println(numbers.get(6));

//        numbers.forEach((key, value) -> {
//            System.out.println(key + ". " + value);
//        });

        System.out.println(numbers.entrySet()
                .stream()
                .filter(entry -> entry.getValue().contains("o"))
                .map(entry -> " > " + entry.getValue())
                .findFirst()
                .orElse("not found"));
//                .forEach(System.out::println);






//        Calc.arrayChange(new ArrayList<>(){
//            {
//                add("Tests");
//                add("Tests");
//            }
//        });


//        System.out.println(calc.sum(
//                3434567865L,
//                5156));
//
//        System.out.println(calc.multiple(
//                234,
//                23));
//
//
//        h = Integer.parseInt("45");
//        System.out.println(h);
//
//        Lesson_1.Application application = new Lesson_1.Application();
//        application.a = 9;
//        System.out.println(application.a);
//
//        application.test(
//                h + "", // Good trick
//                "first ",
//                "method");

//        Lesson_1.Application application1 = new Lesson_1.Application();
//        System.out.println(application1.a);
    }

//    public void test(String name, String name1, String name2){
//        System.out.println(name + name1 + name2);
//    }
}
