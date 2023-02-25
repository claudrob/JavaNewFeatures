package my.edu.functionalInterfaces;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel() >= 3;
    static Predicate<Student> p2 = (s) -> s.getGpa() >= 3.9;

    public static void filterStudentByGradeLevel(){
        System.out.println("---- Grade Level -----");
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach((student -> {
            if(p1.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudentByGpa(){
        System.out.println("---- GPA -----");
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach((student -> {
            if(p2.test(student)){
                System.out.println(student);
            }
        }));
    }

    public static void filterStudents(){
        System.out.println("Filter Students:");
        List<Student> studentList = StudentDatabase.getAllStudents();
        studentList.forEach(student -> {
            if(p1.or(p2).negate().test(student)){
                System.out.println(student);
            }else{
                System.out.println(student);
            }
        });



    }


    public static void main(String[] args) {
        filterStudentByGradeLevel();
        filterStudentByGpa();
        filterStudents();
    }
}
