package task12;

import java.util.Arrays;

public class Task12 {
    public static void main(String[] args) {
        for (int m = 0; m < 100000; m++) {
            String line = ">" + "1".repeat(15) + "2".repeat(35) + "3".repeat(m);

            while (line.contains(">1") || line.contains(">2") || line.contains(">3")) {
                if (line.contains(">1")) line = line.replaceFirst(">1", "2>");
                else if (line.contains(">2")) line = line.replaceFirst(">2", "3>");
                else if (line.contains(">3")) line = line.replaceFirst(">3", "11>");
            }

            int sum = Arrays.stream(line.split("")).filter(ch -> ch.matches("[012345]")).mapToInt(Integer::parseInt).sum();
            if (delsCount(sum) == 3) {
                System.out.println(m);
                return;
            }
        }
    }

    public static int delsCount(int num) {
        int count = 0;
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) count++;
        }
        return count;
    }
}
