package task25;

import java.util.stream.LongStream;

public class Task25 {
    public static void main(String[] args) {
        // mask -> 1?2139*4

        LongStream.range((long) Math.pow(10, 6), (long) Math.pow(10, 10)).filter(val -> {
            if (val % 3052 != 0) return false;
            String sVal = String.valueOf(val);
            return sVal.startsWith("1") && sVal.endsWith("4") && sVal.startsWith("2139", 2);
        }).forEach(val -> System.out.println(val + " " + (val / 3052)));
    }
}
