package Collections_ex;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//  1. Create an ArrayList<String> of student names
//	Add at least 5 names
//	Print all names
//	Remove the 3rd name

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Andrei", "Radu", "Marius", "Maria", "Andreea");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);

//2. Sum of Integers
//	 Create a List<Integer>
//	 Add 10 numbers
//	 Calculate the sum and average

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 4, 5, 10, 20, 15, 30, 50, 100, 90);
        System.out.println(numbers);
        int sum = 0;
        for (Integer i : numbers)
            sum += i;
        System.out.println(sum);
        System.out.println((double) sum / numbers.size());

//3. Reverse a list:
//	Given a list of integers, reverse it manually
        Collections.reverse(numbers);
        System.out.println(numbers);

//4. Unique Words Counter
//	Given a sentence, split it into words
//	Store them in a Set<String>
//	Print unique words and their count

        String sentence = "Ana are mere si pere";
        System.out.println(sentence);
        String[] words = sentence.split(" ");
        Set<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println(unique);
        System.out.println(unique.size());

//5. Word Frequency Counter
//	Input: "apple banana apple orange banana apple"
//	Use a Map<String, Integer>
//	Count how many times each word appears
        String str="apple banana apple orange banana apple";
        Map<String,Integer> mp=new HashMap<>();
        String[] arr=str.split(" ");
        for(String s:arr)
        {
            if(mp.containsKey(s))
                mp.put(s,mp.get(s)+1);
            else
                mp.put(s,1);
        }
        System.out.println(mp);

//6. Phone Book
//	Create a Map<String, String> (name → phone)
//	Add entries
//	Search by name
//	Print all entries
        Map<String, String> phoneBook=new HashMap<>();
        phoneBook.put("Andrei","0712345789");
        phoneBook.put("Cristi","0789654321");
        phoneBook.put("George","0754678435");

        String numeCautat = "Andrei";
        if (phoneBook.containsKey(numeCautat))
            System.out.println("Numarul lui " + numeCautat+ " este: "+ phoneBook.get(numeCautat));
        else
            System.out.println("Contactul nu a fost gasit");

        System.out.println("AGENDA TELEFONICA");
        for(Map.Entry<String,String> entry: phoneBook.entrySet())
            System.out.println("Nume: "+entry.getKey()+" - Numar: "+entry.getValue());

//7. Students management system
//  -given the following class:
//  class Student {
//      String name;
//      int grade;
//}
//	Store students in a List<Student>
//	Print all students
//	Find the student with the highest grade

        List<Student> s=new ArrayList<>();
        s.add(new Student("George",8));
        s.add(new Student("Costel", 6));
        s.add(new Student("Razvan", 10));
        s.add(new Student("Raul",4));
        System.out.println(s);

        Student notaMaxima=s.get(0);
        for(Student i :s)
            if(i.compareTo(notaMaxima)>0)
                notaMaxima=i;
        System.out.println("Studentul cu cea mai mare nota este: "+notaMaxima.getName()+ " - nota "+notaMaxima.getGrade());

//    8.Sort students by:
//       Name (alphabetically)
//       Grade (descending)

        s.sort(Comparator.comparing(Student::getName));
        System.out.println(s);

        s.sort(Comparator.comparing(Student::getGrade).reversed());
        System.out.println(s);

//9.Remove Duplicates from Objects
//Given a list of students (with duplicates), remove duplicates

        System.out.println("HASHSET");
        Set<Student> s2=new HashSet<>();
        s2.add(new Student("George",8));
        s2.add(new Student("Costel", 6));
        s2.add(new Student("Razvan", 10));
        s2.add(new Student("Razvan",10));
        s2.add(new Student("George", 8));
        s2.add(new Student("Tudor",3));
        System.out.println(s2);
    }

}
