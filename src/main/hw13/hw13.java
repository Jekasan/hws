package hw13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class hw13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String file = scanner.next();
        System.out.println("Введите последовательность символов: ");
        String text = scanner.next();

        char[] chars = text.toCharArray();
        System.out.println(Arrays.toString(chars));

        sumOfChars(file, chars);
    }

    public static void sumOfChars(String file, char chars[]) {
        int[] count = new int[chars.length];
        try (var raf = new RandomAccessFile(file, "r")) {
            String tmp;
            while ((tmp = raf.readLine()) != null) {
                String res = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
                String str = res.toLowerCase();

                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < str.length(); j++) {
                        if (chars[i] == str.charAt(j)) {
                            count[i]++;
                        }
                    }
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != 0) {
                    System.out.println(chars[i] + " - " + count[i] + " раз" + ((count[i] > 1 && chars[i] < 5) ? "а" : ""));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
