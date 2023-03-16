package task14;

public class Task14 {
    public static void main(String[] args) {
        String m_first = "753x2", m_second = "2x173";

        for (int x = 0; x < 13; x++) {
            int first = Integer.parseInt(m_first.replaceAll("x", String.valueOf(x)), 13);
            int second = Integer.parseInt(m_second.replaceAll("x", String.valueOf(x)), 13);

            if ((first + second) % 12 == 0) {
                System.out.println((first + second) / 12);
                return;
            }

        }
    }
}
