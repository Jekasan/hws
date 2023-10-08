package hw9;

import java.util.ArrayList;
import java.util.List;

public class hw9 {
    public static void main(String[] args) {

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4);
        arr2.add(3);
        arr2.add(14);
        arr2.add(16);
        arr2.add(18);

        System.out.println(minAndMax(1, 10));
        System.out.println(sumMoreThen5(arr2));
        add(3, arr2);
        System.out.println(arr2);
        addAndRewrite(6, arr2);
        System.out.println(arr2);

        List<Person> arr3 = new ArrayList<>();
        arr3.add(new Person("Andrey", 28));
        System.out.println(arr3);

        System.out.println(personAgeMore(arr3, 30));

        System.out.println("Young:" + young(arr3));

    }

    public static List<Integer> minAndMax(int min, int max) {
        List<Integer> arr = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            arr.add(i);
        }
        return arr;
    }

    public static int sumMoreThen5(List<Integer> arr2) {
        int summ = 0;
        for (Integer i : arr2) {
            if (i > 5) {
                summ += i;
            }

        }
        return summ;
    }

    public static void add(int add, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, add);
        }
    }

    public static void addAndRewrite(int add, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i) + add);
        }
    }

    public static List<String> personNames(List<Person> arr3) {
        List<String> names = new ArrayList<>();
        for (Person person : arr3) {
            names.add(person.getName());
        }

        return names;
    }

    public static List<Person> personAgeMore(List<Person> arr3, int age) {
        List<Person> more = new ArrayList<>();

        for (Person pers : arr3) {
            if (pers.getAge() >= age) {
                more.add(pers);
            }
        }

        return more;
    }

    public static Person young(List<Person> arr3) {
        if (arr3.size() != 0) {
            int n = 0;
            for (int i = 1; i < arr3.size(); i++) {
                if (arr3.get(n).getAge() > arr3.get(i).getAge()) {
                    n = i;
                }
            }
            return arr3.get(n);
        }
        return null;
    }
}

