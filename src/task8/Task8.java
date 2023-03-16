package task8;

import java.util.Arrays;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
        int count =0;
        for (int i = (int) Math.pow(10,3); i < Math.pow(10,6); i++) {
            String temp = Integer.toString(i, 7);

            if (temp.length() != 5) continue;

            if (temp.chars().filter(ch->ch=='6').count() != 1) continue;

            List<Integer> nums = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).boxed().toList();
            if (nums.stream().filter(num -> num % 2 == 0).mapToInt(v->v).sum() < nums.stream().filter(num -> num % 2 != 0).mapToInt(v->v).sum())
                count++;
        }

        System.out.println(count);
    }
}
