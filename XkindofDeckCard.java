import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XkindofDeckCard {
    public static void main(String[] args) {

    }
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        int gcd = map.get(deck[0]);
        for (int key : map.keySet()) {
            gcd = getGreatestCommonDivisor(map.get(key), gcd);
        }
        return gcd != 1;
    }

    private static int getGreatestCommonDivisor(int m, int n) {
        return n == 0? m : getGreatestCommonDivisor(n, m % n);
    }

    public static boolean hasGroupsSizeXBruteforce(int[] deck) {
        Map<Integer, Long> counts =
                Arrays.stream(deck)
                        .boxed()
                        .collect(
                                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return IntStream
                .rangeClosed(2, counts.values().stream().mapToInt(x->(int)(long)x).boxed().min(Integer::min).get())
                .anyMatch(z->counts.values().stream().allMatch(n->n% z ==0));
    }
}
