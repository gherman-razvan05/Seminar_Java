package Collections_ex;

import java.text.CollationElementIterator;
import java.util.*;

public class Main {
    static void main(String[] args) {

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
    }
}
