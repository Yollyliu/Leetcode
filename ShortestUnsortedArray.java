package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ShortestUnsortedArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }


        int ans = new ShortestUnsortedArray().sorted(arr);
        System.out.println(ans);
    }


    public int run(int []nums){

        if(nums.length==0||nums.length==1) {return 0;}
        int left=-1;
        int right=nums.length;
        int ans=0;
        for(int i=nums.length-1;i>0;i--){

            if(nums[i]<nums[i-1]){
                right=i;
                break;
            }
        }
        for(int i=0;i<nums.length-1;i++){

            if(nums[i]>nums[i+1]){
                left=i;
                break;
            }
        }
        if(left==-1 && right==nums.length) {return 0;}
        else {

            int max = nums[left], min = nums[right];

            for (int i = left; i < right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }

            for (int i = left - 1; i >= 0; i--) {
                if (nums[i] > min) {
                    ans++;
                }
            }

            for (int i = right + 1; i < nums.length; i++) {
                if (nums[i] < max) {
                    ans++;
                }
            }


            ans = ans + right - left + 1;
            return ans;
        }

    }

    public int sorted(int []nums){
        int [] clone=nums.clone();   //clone array;
        Arrays.sort(clone);           //sorted array;
        int left=nums.length,right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=clone[i]){
                left=Math.min(left,i);
                right=Math.max(right,i);
            }
        }
        return (right-left> 0 ? right-left+1: 0);
    }

    
}
