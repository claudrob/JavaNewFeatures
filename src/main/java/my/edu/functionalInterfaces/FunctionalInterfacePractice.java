package my.edu.functionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionalInterfacePractice {

    public static void main(String[] args) {
//        () -> void_or_return_something
        System.out.println("Testing ...");

        Stream.of("Code", "Learn", "Hub")
                //.forEach(System.out::println);
                .forEach(s -> System.out.println(s));

        Consumer<String> printer = System.out::println;
        Stream.of("Code", "Learn" , "Hub").forEach(printer);

        Consumer<String> printAgainWithStars = s -> System.out.println(s+"*");
        Stream.of("E", "L", "J")
                .forEach(printer.andThen(printAgainWithStars));

        Stream.of("Hello", "World!", "Code!", "LEARN!", "hub").
                filter(
                        Predicate.isEqual("Hello")
                                .or(
                                        Predicate.not(s -> ((String) s).contains("!"))
                                )
                                .negate()

                )
                .forEach(System.out::println);

        testLambda();


    }

    public static void testLambda(){
        Runnable runnable = () -> System.out.println("Hello Lambda!");
        Thread thread = new Thread(runnable);
        thread.start();

        int[] x = new int[5];
    }

}
;