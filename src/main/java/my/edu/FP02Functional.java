package my.edu;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "MircoServices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");


        int sum = addListFunctional(numbers);
        System.out.println("sum = " + sum);

        List<Integer> doubledNumbers = squaredList(numbers);
        System.out.println("doubledNumbers = " + doubledNumbers);

        List<Integer> filteredNumbers = filterOutEvenNumbers(numbers);
        System.out.println("filteredNumbers = " + filteredNumbers);

        List<Integer> lengthCourseTitles = courseTitleLength(courses);
        System.out.println("lengthCourseTitles = " + lengthCourseTitles);
    }

    private static List<Integer> courseTitleLength(List<String> courses) {
        return courses.stream().map(course -> course.length()).collect(Collectors.toList());
    }

    private static List<Integer> filterOutEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    private static int sum(int aggregate, int nextNumber){
        System.out.println("aggregate = " + aggregate + "; nextNumber = " + nextNumber);
        return aggregate + nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {

        return numbers.stream()
//                .reduce(0, FP02Functional::sum);
//                .reduce(0,(x,y) -> x + y);
                .reduce(0, Integer::sum);
    }

/*
numbers.stream().reduce(0, (x,y) -> x + (y * y))

    $13 ==> 835

    jshell>

    jshell> numbers.stream().reduce(0, (x,y) -> x + (y * y * y))
    $14 ==> 10109

    jshell> numbers.stream().filter(number -> number%2 != 0).reduce(0, (x,y) -> x + y)
$17 ==> 37
*/

}