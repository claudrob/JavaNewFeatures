package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

public class StreamMapReduceExample {

    private static int noOfNoteBooks(){
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .filter(student -> student.getGender().equals("female"))
                .map(Student::getNoteBooks)
//                .reduce(0, (a,b) -> a + b);
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println("Number of notebooks: " + noOfNoteBooks());

    }
}
