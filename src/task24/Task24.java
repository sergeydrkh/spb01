package task24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task24 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\serezk4\\Desktop\\ege\\spb01\\spb01\\src\\task24\\files\\24_6636.txt"));
        String line = bufferedReader.readLine().trim();

        line = line.replaceAll("[02468]", "c");
        line = line.replaceAll("[13579]", "n");

        int maxLen = 0, currLen = 0;
        for (int i = 1; i < line.length(); i += 2) {
            if (line.charAt(i) == 'n' && line.charAt(i - 1) == 'c') currLen++;
            else {
                maxLen = Math.max(currLen, maxLen);
                currLen = 1;
            }
        }

        System.out.println(maxLen);
    }
}
