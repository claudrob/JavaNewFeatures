package my.edu.data.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> limit(List <Integer> integers){
        return integers.stream()
//                .limit(3)
                .skip(3)
                .reduce((x,y) -> x+ y);
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(6, 7, 8, 9, 10);

        Optional<Integer> result = limit(integerList);
        if(result.isPresent()){
            System.out.println("Result: " + result.get());
        }else{
            System.out.println("Empty!");
        }
    }

}
