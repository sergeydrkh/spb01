package task9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Task9 {
    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task9\\files\\t9.txt"));
        List<List<Integer>> nums = new ArrayList<>();

        while (fileReader.ready())
            nums.add(Arrays.stream(fileReader.readLine().trim().split("\t")).mapToInt(Integer::parseInt).boxed().toList());

        int count = 0;
        for (List<Integer> curr : nums) {
            Map<Integer, Integer> repeat = new HashMap<>();
            curr.forEach(val -> {
                if (repeat.containsKey(val)) repeat.put(val, repeat.get(val) + 1);
                else repeat.put(val, 1);
            });

            if (repeat.values().stream().filter(v -> v == 2).count() != 1)
                continue;

            int sumNotRepeat = repeat.entrySet().stream().filter(e -> e.getValue() != 2).map(Map.Entry::getKey).mapToInt(v -> v).sum() / 4;
            int sumOfRepeat = repeat.entrySet().stream().filter(e -> e.getValue() == 2).map(Map.Entry::getKey).mapToInt(v -> v).sum() * 2;


            if (sumNotRepeat >= sumOfRepeat) {
                System.out.println(sumOfRepeat + " " + sumNotRepeat);
                count++;
            }
        }

        System.out.println(count);
    }
}
