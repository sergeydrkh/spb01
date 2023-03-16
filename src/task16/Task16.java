package task16;

import java.util.HashMap;
import java.util.Map;

public class Task16 {
    public static final Map<Long, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        cache.put(1L, 1L);

        System.out.println(f(516) / f(513));
    }

    public static long f(long n) {
        if (cache.containsKey(n)) return cache.get(n);
        cache.put(n, f(n - 1) * ((2 * n) - 3));
        return cache.get(n);
    }
}
