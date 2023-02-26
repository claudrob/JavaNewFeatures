package my.edu.functionalInterfaces;

import java.util.Locale;
import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> function = (name) -> name.toUpperCase();
    static Function<String, String> addSomeString = (str) -> str.toLowerCase().concat("Default");

    public static void main(String[] args) {
        System.out.println("Result is : " +  function.apply("java9"));
        System.out.println("Restult is : " + addSomeString.apply("claud"));
        System.out.println("Result of andThen is: " + function.andThen(addSomeString).apply("JavaSpring"));

        System.out.println("Result of andThen is: " + function.compose(addSomeString).apply("JavaSpring"));
    }
}
