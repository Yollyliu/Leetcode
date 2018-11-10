import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String n="nagaram";
        System.out.println(validAnagram(s,n));

    }
    

    public static boolean validAnagram(String s,String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
