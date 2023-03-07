package my.edu.data.methodreference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    static Function<String, String> toUpperCaseLambda = (s) -> s.toUpperCase();

    static Function<String, String> getToUpperMethodReference  = String::toUpperCase;



    public static void main(String[] args) {

        System.out.println(toUpperCaseLambda.apply("java8"));
        System.out.println(getToUpperMethodReference.apply("claud robinson"));
    }
}
