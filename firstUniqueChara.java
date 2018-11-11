import java.util.HashMap;

public class firstUniqueChara {


    public static void main(String[] args) {

        String s="ss";
        System.out.println(firstUniqCharHashMap(s));
    }
//HashMap
    public static int firstUniqCharHashMap(String s) {
        HashMap<Character,Integer> hashMap=new HashMap <>();
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(hashMap.containsKey(chars[i])){
                hashMap.put(chars[i],Integer.MAX_VALUE);
            }else {
                hashMap.put(chars[i], i);
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i:hashMap.values()){
            if(i<ans){
                ans=i;
            }
        }
        if(ans==Integer.MAX_VALUE) {
            return -1;
        }
        return ans;


    }



//Array
    public int firstUniqCharArray(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

// String index
    public int firstUniqChar(String s) {
        int result = s.length();
        for (char c = 'a'; c <= 'z'; c++) {
            int i = s.indexOf(c);
            if (i != -1 && i == s.lastIndexOf(c)) {
                result = Math.min(result, i);
            }
        }
        return result == s.length() ? -1 : result;
    }

}
