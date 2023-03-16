package task27;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Task27 {
    public static final String F_T = "C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task27\\files\\27T_6638.txt";
    public static final String F_A = "C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task27\\files\\27A_6638.txt";
    public static final String F_B = "C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task27\\files\\27B_6638.txt";

    // max package - 100

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(F_B));

        int size = Integer.parseInt(fileReader.readLine().trim());
        int[][] antennas = new int[size][2];
        for (int i = 0; i < size; i++) {
            int[] initData = Arrays.stream(fileReader.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            antennas[i] = new int[]{initData[0], (int) Math.ceil(((double) initData[1]) / 100)};
        }

        int[] prefix = new int[size];
        prefix[0] = antennas[0][1];
        for (int i = 1; i < size; i++)
            prefix[i] = antennas[i][1] + prefix[i - 1];

        long sum = 0;
        for (int i = 1; i < size; i++) {
            sum += (long) (antennas[i][0] - antennas[0][0]) * antennas[i][1];
        }

        Map<Long, List<Integer>> costs = new TreeMap<>();

        long minSum = Integer.MAX_VALUE;
        for (int i = 1; i < size; i++) {
            long d = antennas[i][0] - antennas[i - 1][0];
            sum = sum + (d * (prefix[i - 1])) - (d * (prefix[prefix.length - 1] - prefix[i - 1]));

            if (costs.containsKey(sum))
                costs.put(sum, Stream.concat(costs.get(sum).stream(), List.of(antennas[i][0]).stream()).toList());
            else costs.put(sum, List.of(antennas[i][0]));

            minSum = Math.min(minSum, sum);
        }

        System.out.println(costs.values().iterator().next());
    }
}
