package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {

    public static List<Student> filterStudents(){
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("female"))
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

//        System.out.println("Filter Female Students: " + filterStudents());
        filterStudents().forEach(System.out::println);

    }

}
