import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class groupSpecialEquivalentString {
    public static void main(String[] args) {

    }
    public int numSpecialEquivGroupsCounting(String[] A) {
        Set<String> seen = new HashSet();
        for (String S: A) {
            int[] count = new int[52];
            for (int i = 0; i < S.length(); ++i)
                count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
