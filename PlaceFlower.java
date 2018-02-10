// Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

// Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: True
// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False


//Tips: before coding, we should consider all the conditions, when we get the count of zero, there has three conditions.
//1. n=count/2.  it happens when 0 is at the head or and the end of an array, for example:  0 0 0 0 1 1 0 0 0 0
//2. n=count+1/2 it happens when there is all 0 in array, for example 0 0 0 0 0 0 
//3. n=count-1/2 it happles when 0 betweens 1. 

//After you consider all the conditions, it is easy to finish the code.














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
