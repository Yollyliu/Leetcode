// Given an array of integers nums, write a method that returns the "pivot" index of this array.

// We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

// If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

// Example 1:
// Input: 
// nums = [1, 7, 3, 6, 5, 6]
// Output: 3
// Explanation: 
// The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
// Also, 3 is the first index where this occurs.
// Example 2:
// Input: 
// nums = [1, 2, 3]
// Output: -1
// Explanation: 
// There is no index that satisfies the conditions in the problem statement.


//Tips: the first way come in mind is that, sum the left[length] and right[length], and loop to search if left[i]=right[i].

//However, we don't need to get right[length], as for sum=left-num[i]-right;however, right=left. So, we can decrease a loop time.























package array;

import java.util.Scanner;

public class PivotIndex {
    public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            int m=scanner.nextInt();
            int []arr=new int[m];
            for(int i=0;i<m;i++){
                arr[i]=scanner.nextInt();
            }

            int ans=new PivotIndex().run(arr);
        System.out.println(ans);
        }

    public int run(int []nums){
        int sum=0,ans=-1,left=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(i!=0) {
                left+=nums[i-1];
            }
            if(sum-left-nums[i]==left){
                return i;
            }
        }
        return ans;





//        int len=nums.length;
//        if(len==0)  return -1;
//        int [] lefts=new int [len];
//        int [] rights= new int [len];
//        lefts[0]=nums[0];
//        rights[len-1]=nums[len-1];
//
//        for(int i=1;i<nums.length;i++){
//            lefts[i]=nums[i]+lefts[i-1];
//
//        }
//
//        for(int i=nums.length-2;i>=0;i--){
//            rights[i]=rights[i+1]+nums[i];
//        }
//
//        if(lefts[0]==rights[0]){
//            return 0;
//        }
//
//        for(int i=0;i<len-2;i++){
//            if(lefts[i]==rights[i+2]){
//                return i+1;
//            }
//        }
//
//        if(lefts[len-1]==rights[len-1]){
//            return len-1;
//        }
//
//        return -1;


    }

}
