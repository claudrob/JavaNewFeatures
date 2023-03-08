package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

//    public static List<String> printStudentActivities(){
//        List<String> studentAcvities = StudentDatabase.getAllStudents()
//                .stream()
//                .map(Student::getActivities)
//                .flatMap(List::stream)
//                .collect(Collectors.toList());
//
//        return studentAcvities;
//    }

    public static void main(String[] args) {
//        System.out.println(printStudentActivities());
    }

}
