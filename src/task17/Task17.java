package task17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task17 {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task17\\files\\17_6605.txt"));
        List<Integer> numbers = new ArrayList<>();
        while (fileReader.ready()) numbers.add(Integer.parseInt(fileReader.readLine()));

        long maxSquareEndsWithFive = (long) Math.pow(numbers.stream().filter(num -> num % 10 == 5).mapToInt(v -> v).max().getAsInt(), 2);

        System.out.println(numbers.size());

        long count = 0, max = 0;
        for (int i = 1; i < numbers.size(); i++) {
            int first = numbers.get(i - 1), second = numbers.get(i);

            if (toI(String.valueOf(first).endsWith("5")) + toI(String.valueOf(second).endsWith("5")) != 1) continue;

            long sq = (long) Math.abs(Math.pow(first, 2) - Math.pow(second, 2));

            if (sq <= maxSquareEndsWithFive) {
                count++;
                max = Math.max(max, sq);
            }
        }

        System.out.println("count: " + count);
        System.out.println("max: " + max);
    }

    public static int toI(boolean b) {
        return Boolean.compare(b, false);
    }
}
