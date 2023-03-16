package task11;

public class Task11 {
    public static void main(String[] args) {
        int count = 10 + 1024 + 1024;
        // 256 ид -> 6Кбайт

        int i = 12;
        double bit = (((double) 6 / 256) * 1024 * 8 / i);

        System.out.println(bit);
    }
}
