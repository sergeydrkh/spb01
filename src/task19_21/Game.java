package task19_21;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 10000; i >= 13; i--) {
            if (game(i, 0, 4)) {
                System.out.println(i);
                count++;
            }
        }

        System.out.println("\n\nC: " + count);

//        System.out.println("min: " + Collections.min(vals));
//        System.out.println("max: " + Collections.max(vals));
    }

    private static boolean game(int heap, int currentPlayer, int winner) {
        if (heap <= 12) {
            System.out.print(currentPlayer + " ");
            return currentPlayer % 2 == winner % 2;
        }

        if (currentPlayer >= winner) return false;

        final int nextPlayer = currentPlayer + 1;
        List<Boolean> results = getHeaps(heap).stream().map(newHeap -> game(newHeap, nextPlayer, winner)).toList();

        return nextPlayer % 2 == winner % 2 ?
                results.stream().anyMatch(v -> v) :
                results.stream().allMatch(v -> v);
    }

    private static List<Integer> getHeaps(int heap) {
        return List.of(heap - 12, heap / 3);
    }
}
