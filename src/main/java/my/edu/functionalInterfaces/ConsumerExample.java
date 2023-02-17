package my.edu.functionalInterfaces;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {

        static Consumer<Student> c3 = (student) -> System.out.println(student);
        static Consumer<Student> c4 = (student) -> System.out.print(student.getName());
        static Consumer<Student> c5 = (student) -> System.out.println(student.getActivities());


    public static void printName(){
        List<Student> studentList =  StudentDatabase.getAllStudents();
        studentList.forEach(c3);
    }

    public static void printNameAndActivities(){
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(c4.andThen(c5));

    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition");
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() > 3.9){
                c3.andThen(c4).accept(student);
            }
        });

    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("Java 8!");
        Consumer<String> c2 = (s) -> System.out.println(s);
        c2.accept("This is the end!");
        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();

    }
}
