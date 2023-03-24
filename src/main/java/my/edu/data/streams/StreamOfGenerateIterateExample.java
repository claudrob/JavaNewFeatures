package my.edu.data.streams;

import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("adam", "dan", "july");
        stringStream.forEach(System.out::println);


    }

}
