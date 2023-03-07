package my.edu.lambdaexamples;

import java.util.function.Consumer;

public class LambdaVariable2 {

        static int value = 4; // Local Variable

    public static void main(String[] args) {

//        int value = 4; // Local Variable

        Consumer<Integer> c1 = (i) -> {
        value++;
            System.out.println(value + i);
        };
        c1.accept(value);

    }

}
