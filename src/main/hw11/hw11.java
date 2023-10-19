package hw11;

import java.util.Arrays;

public class hw11 {
    public static void main(String[] args) {

        Integer[] numbers = new Integer[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        Tree<Integer> tree = new Tree<Integer>();
        System.out.println(Arrays.toString(numbers));
        tree.loadList(numbers);
        tree.print(tree, "");
        System.out.println();
        System.out.println(tree.find(2));
    }
}
