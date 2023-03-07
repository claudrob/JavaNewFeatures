package my.edu.data.methodreference;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    static Consumer<Student> c1 = System.out::println;

    static Consumer<Student> c2 = Student::printListOfActivities;

    public static void main(String[] args) {

        StudentDatabase.getAllStudents().forEach(c1);

//        StudentDatabase.getAllStudents().forEach(System.out::println);
        StudentDatabase.getAllStudents().forEach(c2);
    }

}
