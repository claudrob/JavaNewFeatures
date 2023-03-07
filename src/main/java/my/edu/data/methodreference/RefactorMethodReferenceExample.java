package my.edu.data.methodreference;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> p1 = RefactorMethodReferenceExample::greaterThanGradeLevel;

    public static boolean greaterThanGradeLevel(Student s){
        return s.getGradeLevel() >= 1;
    }


    public static void main(String[] args) {
        System.out.println(p1.test(StudentDatabase.studentSupplier.get()));

    }
}
