package my.edu.data.streams;

import my.edu.data.Student;
import my.edu.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReducedExample {

    public static Optional<Integer> performMultiplication(List<Integer> integerList){
       return integerList.stream()
                .reduce( (a,b) -> a*b);
    }

    public static Optional<Student> getHighestGPAStudent(){
        return StudentDatabase.getAllStudents().stream()
                .reduce((s1, s2) -> {
                        if(s1.getGpa() > s2.getGpa()){
                            return s1;
                        }else{
                            return s2;
                        }
                });
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println(performMultiplication(integers).isPresent());
        System.out.println(performMultiplication(integers).get());

        Optional<Student> studentOptional = getHighestGPAStudent();
        if(studentOptional.isPresent()){
            System.out.println(studentOptional.get());
        }

    }
}
