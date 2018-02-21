package string;

import java.util.Scanner;

public class BinarySubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        int n=new  BinarySubstring().count(m);
        System.out.println(n);
    }

    public int count(String sentence){
        char[] chars=sentence.toCharArray();
        int len=chars.length;
        int cur=1,zero=0,one=0,count=0;
        if(chars[0]=='1') {one=one+1;}
        else   {zero=zero+1;}
        while(cur<len){
            if(chars[cur]=='0'){
                if(chars[cur-1]=='1') {zero=0;}

                zero++;
                cur++;

            }
            else{
                if(chars[cur-1]=='0') {one=0;}
                one++;
                cur++;
            }
            if(zero==one){
                count++;
                if(chars[cur-1]=='1'){
                    zero=0;
                }else{
                    one=0;
                }

            }
            else if(zero>one && one!=0 ){
                count++;
            }
            else if(zero<one && zero!=0){
                count++;
            }
        }

        return count;
    }

    public int changeToInt(String s){
        int [] group=new int[s.length()];
        int t=0;
        group[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                group[++t]=1;
            }else{
                group[t]++;
            }
        }
        int count=0;
        for(int i=1;i<=t;i++){
            count+=Math.min(group[i-1],group[i]);

        }
        return count;
    }

    public int countSub(String s){
        int ans=0,pre=0,cur=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                ans+=Math.min(pre,cur);
                pre=cur;
                cur=1;
            }else{
                cur++;
            }
        }
        return ans+Math.min(pre,cur);
    }

}
