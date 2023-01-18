package my.edu;

import java.util.stream.LongStream;

public class FP05Parallelizing {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
//        System.out.println(LongStream.range(0, 1000000000).sum());
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
