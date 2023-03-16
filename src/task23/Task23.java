package task23;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task23 {
    public static void main(String[] args) {
        System.out.println(calc(333, 0).stream().filter(val -> val < 0).count());
    }

    public static Set<Integer> calc(int from, int depth) {
        if (depth == 13) return Set.of(from);
        return Stream.concat(
                calc(from - 3, depth + 1).stream(),
                calc(from * (-3), depth + 1).stream()
        ).collect(Collectors.toSet());
    }
}
