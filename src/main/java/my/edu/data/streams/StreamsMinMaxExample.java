package my.edu.data.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {


    public static Optional<Integer> findMaxValue(List<Integer> integerList){
        return integerList.stream()
                .reduce( (x,y) -> x > y ? x : y);
    }

    public static Optional<Integer> findMinValue(List<Integer> integerList){
        return integerList.stream()
                .reduce( (x,y) -> x < y ? x : y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6,7,8,9,10);
        List<Integer> emptyList = new ArrayList<>();

        Optional<Integer>optionalInteger = findMaxValue(integerList);
        if(optionalInteger.isPresent())
            System.out.println("Max Value: "+ optionalInteger.get());

        Optional<Integer>optionalInteger2 = findMaxValue(emptyList);
        if(optionalInteger2.isPresent())
            System.out.println("Max Value: "+ optionalInteger2.get());
        else
            System.out.println("Empty list");


        Optional<Integer> optionalMin = findMinValue(emptyList);
        if(optionalMin.isPresent()){
            System.out.println("Min Value; " + optionalMin.get());
        }else{
            System.out.println("Empty!");

        }


    }

}
