package my.edu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {
    public static void main(String[] args) {
        try{

            Files.lines(Paths.get("file.txt"))
                    .map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);


            System.out.println("List of directories");
            Files.list(Paths.get("."))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);

        }catch(IOException exception){
            exception.printStackTrace();
        }

    }
}
