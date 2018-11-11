import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindTheDifference {

    public static void main(String[] args) {
        String s="abcd";
        String t="abe";
        char c=findTheDifferenceBit(s,t);
        System.out.println(c);


    }


//It is easy to think and implement in HashMap, however, it is slowly.
    public static char findTheDifferenceHashMap(String s, String t) {
        char ans=' ';
        HashMap<Character,Integer> hashMap=new HashMap <>();
        if(s.length()>t.length()) {
            String temp=s;
             s=t;
             t=temp;
        }
        Set<Character> ss=new HashSet <>();
        char[] original=s.toCharArray();
        char[] remote=t.toCharArray();
        for(char c:original){
            hashMap.put(c,hashMap.getOrDefault(c,1)+1);

        }
        for(char c:remote){
            if(!hashMap.containsKey(c)){
                ans= c;
            }
            else{
                hashMap.put(c,hashMap.get(c)-1);
            }
        }
        for(char c:hashMap.keySet()){
            if(hashMap.get(c)!=1){
                ans= c;
            }
        }
        return ans;


    }

// bit, this is a practical method if you want to find difference in two string.
    public static char findTheDifferenceBit(String s, String t) {

//        int n = t.length();
//        char c = t.charAt(n - 1);
//        System.out.println(c);
//        for (int i = 0; i < n - 1; ++i) {
//            c ^= s.charAt(i);
//            System.out.println("the first step of c: "+c);
//            c ^= t.charAt(i);
//            System.out.println("the second step of c: "+c);
//        }


        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
        }



        return c;
    }


    //use Array
    public static char findTheDifferenceArray(String s, String t) {
        int[] set = new int[26];

        for (char c : s.toCharArray()) {
            set[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            set[c - 'a']--;
            if (set[c - 'a'] < 0)
                return c;
        }
        //dummy return; should never reach
        return 'a';
    }

}
