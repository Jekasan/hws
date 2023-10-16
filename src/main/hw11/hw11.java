package hw11;

import java.util.Arrays;

public class hw11 {
    public static void main(String[] args) {

        Integer[] numbers = new Integer[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        Tree<Object> tree = new Tree<>();

        tree.loadList(numbers);
        tree.print(tree, "4");
        System.out.println();
        System.out.println(tree.find(0));
    }
}
