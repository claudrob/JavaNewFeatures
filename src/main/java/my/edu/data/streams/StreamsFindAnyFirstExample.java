package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.Optional;

public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAnyStudent(){
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }
     public static Optional<Student> findFirstStudent(){
        return StudentDatabase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }



    public static void main(String[] args) {
        Optional<Student> studentOptional = findAnyStudent();
        if(studentOptional.isPresent()){
            System.out.println("Student: " + studentOptional.get());
        }else{
            System.out.println("No student was found!");
        }

        System.out.println("Find first ...");

        Optional<Student> findFirst = findFirstStudent();
        if(findFirst.isPresent()){
            System.out.println("Student: " + findFirst.get());
        }else{
            System.out.println("No student was found!");
        }
    }

}
