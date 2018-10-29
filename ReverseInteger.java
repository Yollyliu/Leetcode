package com.company;

public class ReverseInteger {

    public static void main(String[] args) {

        int n=1534236469;
        System.out.println(reverse(n));
    }

    public static int reverse(int x){

        int ans=0,y=x;


        while(y!=0){
            int n=y%10;
            y=y/10;
            if((ans>Integer.MAX_VALUE/10) || (ans==Integer.MAX_VALUE/10 && n>7)){
                return 0;
            }
            if(ans<Integer.MIN_VALUE/10 || (ans==Integer.MIN_VALUE/10 && n<-8)){
                return 0;
            }
            ans=ans*10+n;


        }


        return ans;


//        String s=String.valueOf(n);
//        String news="";
//        if(n<0){
//            s=s.substring(1);
//        }
//        for(int i=s.length()-1;i>=0;i--){
//            news+=s.charAt(i);
//        }
//        if(news.charAt(0)=='0'){
//            news=news.substring(1);
//        }
//        int ans=Integer.valueOf(news);
//        if (n < 0) {
//            ans=0-ans;
//        }
//        return ans;

    }
}
