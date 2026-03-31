package Fisiere_ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileDemo {

    public static ArrayList<Student> ReadFile(Path path) {
        ArrayList<Student> listaFisier=new ArrayList<>();
        try {
            System.out.println("\nReading file:");
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] date=line.split(",");
                if(date.length==3)
                {
                    String name =date[0].trim();
                    Integer age=Integer.parseInt(date[1].trim());
                    Specializare specializare=Specializare.valueOf(date[2].trim());

                    listaFisier.add(new Student(name,age,specializare));
                }
            }
        }
        catch (IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
        return listaFisier;
    }
}
