package my.edu;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FunctionalInterfaces {

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

    }



}
