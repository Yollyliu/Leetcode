import java.util.LinkedList;

public class ReverseOnlyLetter {
    public static void main(String[] args) {
        String a="a-bC-dEf-ghIj";
        String ans=reverseOnlyLetters(a);
        System.out.println(ans);

    }
//    public static String reverseOnlyLetters(String S) {
//        LinkedList<String> list=new LinkedList <>();
//        String ans="";
//        String[] words=S.split("-");
//        for(String i:words){
//            list.add(i);
//        }
//        for(int i=list.size()-1;i>=0;i--){
//            String temp=list.get(i);
//            for(int j=temp.length()-1;j>=0;j--){
//                ans+=temp.charAt(j);
//            }
//            if(i>0){
//                ans+="-";
//            }
//
//        }
//        return ans;
//
//    }
//

    public static String reverseOnlyLetters(String S) {
        LinkedList<Character> ls = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (isLetter(S.charAt(i))) ls.add(S.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (isLetter(S.charAt(i))) {
                result.append(ls.removeLast());
            } else {
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }


    public static String reverseOnlyLettersTwoPointer(String S) {
        if(S == null || S.length() <= 1){
            return S;
        }
        int len = S.length();
        int i = 0, j = len - 1;
        char [] res = S.toCharArray();
        while(i < j) {
            if(isCharacter(res[i]) && isCharacter(res[j])){
                char temp = res[i];
                res[i] = res[j];
                res[j] = temp;
                i++;
                j--;
            } else if(isCharacter(res[i])){
                j--;
            } else if(isCharacter(res[j])){
                i++;
            } else {
                i++;
                j--;
            }
        }
        return String.valueOf(res);
    }
    // 当然，可以直接调用API，Character.isLetter(char c) 进行判断
    public static boolean isCharacter(char c){
        if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')){
            return true;
        }
        return false;
    }

    public static String reverseOnlyLettersThird(String S) {
        if(S == null || S.length() <= 1){
            return S;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c))
                sb.append(c);
        }
        sb.reverse();
        for (int i = 0; i < S.length(); ++i) {
            if (!Character.isLetter(S.charAt(i)))
                sb.insert(i, S.charAt(i));
        }
        return sb.toString();
    }
}
