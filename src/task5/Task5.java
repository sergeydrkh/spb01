package task5;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Task5 {
    public static void main(String[] args) {
        Set<Integer> answers = new TreeSet<>();
        for (int i = 1; i < 1000; i++) {
            String bin = Integer.toBinaryString(i);
            bin = 1 + bin.replaceAll("1", "2").replaceAll("0", "1").replaceAll("2", "0");

            long oneCount = bin.chars().filter(ch -> ch == '1').count();
            bin += oneCount % 2 == 0 ? 1 : 0;

            int result = Integer.parseInt(bin, 2);
            if (result > 180) answers.add(i);
        }

        System.out.println(Collections.min(answers));
    }
}
