package my.edu.functionalInterfaces;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void studentAndActivities(){
        BiConsumer<String,List<String>>  biConsumer = (studentName, activities) -> System.out.println(studentName + ": "  + activities);
        List<Student> list = StudentDatabase.getAllStudents();

        list.forEach((student -> biConsumer.accept(student.getName(), student.getActivities())));
    }


    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (a, b) -> {
          System.out.println("StringA: " + a + ", StringB: " + b);
        };

        biConsumer.accept("Java7", "Java8");

        BiConsumer<Integer, Integer> multiply = (a, b) -> {
          System.out.println("Multiply: " + (a * b));
        };

        BiConsumer<Integer, Integer> division = (a, b) -> {
            System.out.println("Division: " + (a / b));
        };

        multiply.andThen(division).accept(10, 5);
        studentAndActivities();
        BiConsumer<String, String> biConsumer2 = (a, b) -> System.out.println(a + " " + b);
        biConsumer2.accept("Hello", "Java");

        BiConsumer<Integer, Integer> multiply2 = (a, b) -> System.out.println("Multiply" + (a * b));
        BiConsumer<Integer, Integer> division2 = (a, b) -> System.out.println("Multiply" + (a * b));

        multiply2.andThen(division2).accept(20, 50);

    }
}
