package my.edu.data.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsVsStreams {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Jim");
        names.add("Jenny");
//        System.out.println("Names:" + names);
//        names.remove(0);
//        System.out.println("Names:" + names);
        for(String name: names){
            System.out.println("name = " + name);
        }
        System.out.println("Test 2");
        for(String name: names){
            System.out.println("name = " + name);
        }

        System.out.println("Streams 1");
        Stream<String> nameString = names.stream();
        nameString.forEach(System.out::println);
        System.out.println("Streams 2");
        nameString.forEach(System.out::println);


    }

}
