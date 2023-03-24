package my.edu.data.streams;

import my.edu.data.StudentDatabase;

public class StreamsMatchExample {

    public static boolean allMatch(){
        return StudentDatabase.getAllStudents()
                .stream()
                .allMatch(student -> student.getGpa()>=3.5);
    }


    public static boolean anyMatch(){
        return StudentDatabase.getAllStudents()
                .stream()
                .anyMatch(student -> student.getGpa()>=4.0);
    }

    public static boolean noneMatch(){
        return StudentDatabase.getAllStudents()
                .stream()
                .noneMatch(student -> student.getGpa()>=4.1);
    }

    public static void main(String[] args) {
        System.out.println("Result of All Match: " + allMatch());
        System.out.println("Result of ANY Match: " + anyMatch());
        System.out.println("Result of NONE Match: " + noneMatch());
    }

}
