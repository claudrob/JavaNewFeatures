package my.edu;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfacesSummary {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, String> stringFunction = x -> x + " ";

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);

        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

        Supplier<Integer> randomIntegerSupplier = () -> 2;

        Supplier<Integer> randomIntegerSupplier2 = () -> {
            Random random = new Random();
            return random.nextInt(1000);

        };

        System.out.println(randomIntegerSupplier.get());
        System.out.println(randomIntegerSupplier2.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println("unaryOperator = " + unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number < 10 && str.length() > 5;
        };
        System.out.println(biPredicate.test(5, "My name is Claud!"));


        BiFunction<Integer, String, Boolean> biFunction = (number, str) -> {
            return number < 10 && str.length() > 5;
        };

        System.out.println(biFunction.apply(5, "This is a test"));

        BiConsumer<String, String> biConsumer = (s1, s2) -> {
            System.out.println(s1);
            System.out.println(s2);
        };
        biConsumer.accept("John",  "Wick");

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(15, 20));

        //IntBinaryOperator
        //IntConsumer
    }


}
