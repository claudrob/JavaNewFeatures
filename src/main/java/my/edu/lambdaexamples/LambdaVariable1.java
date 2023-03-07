package my.edu.lambdaexamples;

import java.util.function.Consumer;

public class LambdaVariable1 {
    public static void main(String[] args) {
        int i = 0;

        Consumer<Integer> c1 = (i1) -> {

            int i3 = 2;
            System.out.println("value is: " + i1);
        };
        c1.accept(5);
    }
}
