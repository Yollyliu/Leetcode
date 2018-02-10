package array;

import java.util.Scanner;

public class PlaceFlower {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }

        int n=scanner.nextInt();

        boolean ans = new PlaceFlower().run(arr,n);
        System.out.println(ans);
    }

    public boolean run(int[] nums, int n) {
        int len=nums.length;
        int cur=0;
        int count=0;
        if(n==0) {return true;}
        if(len==0) {return false;}
        if(len==1 && nums[0]==0 && n ==1 ) {return true;}
        while(cur<len){
            if(nums[cur]==0){
                count++;
            }else{
//                if((count>=3)&& !(cur==len-1 && (count + 1== len))){
//                    n=n-(count-1)/2;
//                }
//
//                if((count==2 && cur==2)|| (cur==len-1 && (count + 1== len))){
//                    n=n-count/2;
//                }
//                count=0;

                if((count>=3)&& (cur!=count )){
                    n=n-(count-1)/2;
                }

                if(cur==count){
                    n=n-(count+1)/2;
                }
                count=0;



            }
            cur++;
        }
        if(count>0) {
            if((cur==len) && (count!=len)){
                n=n-count/2;

            } else if(count==len){
                n=n-(count+1)/2;
            }

            else {n=n-(count-1)/2;}
        }

        return n<=0;

    }
}
