package my.edu.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {
        static Predicate<Integer> predicate = (i) -> {return i % 2 == 0;};
        static Predicate<Integer> predicate2 = (i) -> i%2 == 0;
        static Predicate<Integer> predicate5 = (i) -> i%5 == 0;

        public static void predicateAnd(){
            System.out.println("Predicate and Result: " + predicate2.and(predicate5).test(10));
            System.out.println("Predicate and Result: " + predicate2.and(predicate5).test(9));

        }

    public static void predicateOr(){
        System.out.println("Predicate Or Result: " + predicate2.or(predicate5).test(10));
        System.out.println("Predicate Or Result: " + predicate2.or(predicate5).test(8));

    }

    public static void predicateNegate(){
        System.out.println("Predicate Negate Result: " + predicate2.or(predicate5).negate().test(10));
        System.out.println("Predicate Negate Result: " + predicate2.or(predicate5).negate().test(8));

    }

    public static void main(String[] args) {
        System.out.println(predicate.test(10));
        System.out.println(predicate.test(11));


        System.out.println(predicate2.test(4));
        predicateAnd();
        predicateOr();
        predicateNegate();
    }
}
