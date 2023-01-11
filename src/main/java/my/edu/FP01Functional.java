package my.edu;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "MircoServices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);
        printAllCourses(courses);
        printCoursesContainingWordSpring(courses);
        printCoursesWithFourLetters(courses);
        printSquaresOfEvenNumbersInListFunctional(numbers);
        printCubeOfOddNumbersInListFunctional(numbers);
        printNumberOfCharsForCourses(courses);
    }

//    private static boolean isEven(int number){
//        return number%2 == 0;
//    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("All Numbers: ");
       numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("Even Numbers with Functional approach: ");
        numbers.stream()
//                .filter(FP01Functional::isEven)
                .filter(number -> number%2 == 0)
                .forEach((System.out::println));
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("Squares of Even Numbers with Functional approach: ");
        numbers.stream()
                .filter(number -> number%2 == 0)
                .map(number -> number * number)
                .forEach((System.out::println));
    }
    private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("Cubes of Odd Numbers with Functional approach: ");
        numbers.stream()
                .filter(number -> number%2 != 0)
                .map(number -> number * number * number)
                .forEach((System.out::println));
    }

    private static void printOddNumbersInListFunctional(List <Integer> numbers){
        System.out.println("*** Print Odd numbers; ***");
        numbers.stream()
                .filter(number -> number%2 != 0)
                .forEach(System.out::println);

    }

    private static void printAllCourses(List<String> courses){
        System.out.println("\n*** Print All Courses ***");
        courses.stream()
                .forEach(System.out::println);
    }

    public static void printCoursesContainingWordSpring(List<String> courses){
        System.out.println("\n*** Print Courses containing Spring ***");
        courses.stream()
                .filter( course -> course.contains("Spring"))
                .forEach(System.out::println);

    }

    public static void printCoursesWithFourLetters(List<String> courses){
        System.out.println("\n*** Print Courses containing 4 letters ***");
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

    }

    public static void printNumberOfCharsForCourses(List<String> courses){
        System.out.println("\n*** Print Courses Number Of Chars ***");
        courses.stream()
                .map(course -> course + ": " + course.length())
//                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

    }

    private static void print(int number){
        System.out.println(number);
    }
}