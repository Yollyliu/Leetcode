import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(worldPatternHashMap("abba", "dog cat cat dog"));

    }

    public static boolean worldPatternHashMap(String pattern, String str) {
        Map <Character, String> map = new HashMap <>();
        String[] sts = str.split(" ");
        if (sts.length != pattern.length()) return false;
        int i = 0;
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                if (!map.get(c).equals(sts[i++])) {
                    return false;
                }
            } else if (map.containsValue(sts[i])) {
                return false;
            } else {
                map.put(c, sts[i++]);
            }

        }
        return true;
    }

    public boolean wordPatternList(String pattern, String str) {
        String[] ss = str.split(" ");
        char[] cc = pattern.toCharArray();
        if (cc.length != ss.length) {
            return false;
        }
        List <String> l1 = new ArrayList <>();
        List <Character> l2 = new ArrayList <>();
        for (int i = 0; i < ss.length; i++) {
            if (l2.indexOf(cc[i]) != l1.indexOf(ss[i])) {
                return false;
            }
            l1.add(ss[i]);
            l2.add(cc[i]);
        }
        return true;
    }


}

