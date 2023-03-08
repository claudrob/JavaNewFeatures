package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> studentPredicate = (student -> student.getGradeLevel() >= 3);
        Predicate<Student> studentGpaPredicate = (student -> student.getGpa() >= 3.9);

        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents()
                .stream()
                .peek(student -> {
                    System.out.println("Stream: " + student);
                })

                .filter(studentPredicate)
                .peek(student -> {
                    System.out.println("after 1st filter: " + student);
                })
                .filter(studentGpaPredicate)
                .peek(student -> {
                    System.out.println("after 2nd filter: " + student);
                })
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println(studentMap);
    }

}
