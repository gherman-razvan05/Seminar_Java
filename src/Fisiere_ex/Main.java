package Fisiere_ex;

import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("students.txt");

        ArrayList<Student> studentiASE=FileDemo.ReadFile(path);

        for(Student s : studentiASE) {
            System.out.println(s);
        }
    }
}
