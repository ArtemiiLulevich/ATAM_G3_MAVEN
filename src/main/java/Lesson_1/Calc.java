package Lesson_1;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private final List<String> testCalc = new ArrayList<>();

    public int sum(int a, int b){
        return a + b;
    }

    public double sum(double a, double b){
        return a + b;
    }

    public long sum(long a, long b){
        return a + b;
    }


    public String multiple(int a, int b){
        return a * b + "";
    }
    public String multiple(double a, double b){
        return a * b + "";
    }
    public String multiple(long a, long b){
        return a * b + "";
    }

    public static void arrayChange(List<String> listForChange) throws IndexOutOfBoundsException{
        listForChange.add("Change!");
    }
}
