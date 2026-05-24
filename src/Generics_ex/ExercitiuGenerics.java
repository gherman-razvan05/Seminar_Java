package Generics_ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercitiuGenerics {
    public static void main(String[] args) {

        Container<String> nume = new Container<>("Java");
        nume.setValue("Generics");
        System.out.println(nume.getValue());

        printTwice("Salut");
        printTwice(2026);

        System.out.println(max(15, 42));
        System.out.println(max("Mere", "Pere"));

        List<String> programare = Arrays.asList("Java", "C++", "Python");
        System.out.println(countElements(programare));

        List<Integer> sursa = Arrays.asList(1, 2, 3);
        List<Number> destinatie = new ArrayList<>();
        destinatie.add(0.5);

        copy(sursa, destinatie);
        System.out.println(destinatie);
    }

    static class Container<T> {
        private T value;

        public Container(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static <T> void printTwice(T value) {
        System.out.println(value + " " + value);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        }
        return b;
    }

    public static int countElements(List<?> list) {
        return list.size();
    }

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T item : src) {
            dest.add(item);
        }
    }
}
