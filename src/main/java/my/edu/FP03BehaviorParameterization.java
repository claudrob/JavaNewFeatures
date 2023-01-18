package my.edu;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

    public static void main(String [] args){
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        numbers.stream()
                .filter(x -> x%2 == 0)
                .map(x -> x * x)
                .forEach(System.out::println);

        BinaryOperator<Integer> accumulator = Integer::sum;
        BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sum = numbers.stream().reduce(0, accumulator);
        System.out.println("sum = " + sum);

        System.out.println("Even numbers:");
        Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers, evenPredicate);


        System.out.println("Even numbers:");
        Predicate<Integer> oddPredicate = x -> x % 2 == 0;

        filterAndPrint(numbers, oddPredicate);
        System.out.println("Numbers devided by 3:");

        filterAndPrint(numbers, x -> x%3 == 0);

        Function<Integer, Integer> integerIntegerFunction = x -> x * x;
        List<Integer> squaredNumbers = getSquaredIntegers(numbers, integerIntegerFunction);
        System.out.println("squaredNumbers = " + squaredNumbers);
    }

    private static List<Integer> getSquaredIntegers(List<Integer> numbers, Function<Integer, Integer> integerIntegerFunction) {
        List <Integer> squaredNumbers = numbers.stream()
                .map(integerIntegerFunction)
                .collect(Collectors.toList());
        return squaredNumbers;
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> oddPredicate) {
        numbers.stream()
                .filter(oddPredicate)
                .forEach(System.out::println);
    }


}
