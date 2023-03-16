package task2;

import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Boolean> vars = List.of(true, false);

        System.out.println("x y z w");
        vars.forEach(x -> vars.forEach(y -> vars.forEach(z -> vars.forEach(w -> {
            if (!(sled(sled(x, w) && sled(!y, z), (z == w) || (w && !y))))
                System.out.println(toI(List.of(x, y, z, w)));

        }))));
    }

    private static String toI(List<Boolean> bools) {
        return bools.stream().map(Task2::toI).map(v -> v + " ").collect(Collectors.joining()).trim();
    }

    private static int toI(boolean b) {
        return Boolean.compare(b, false);
    }

    private static boolean sled(boolean a, boolean b) {
        return !a || b;
    }
}
