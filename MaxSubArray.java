package array;

import java.util.Scanner;

public class MaxSubArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        //int n=scanner.nextInt();

        int ans = new MaxSubArray().maxSubT(arr);
        System.out.println(ans);
    }
    int run(int[] nums) {
        int len=nums.length;
        if(len==0 ){return 0;}
        if(len==1) {return nums[0];}
        int sum=0,prev=0,max=nums[0];
        if(nums[0]>0) sum=nums[0];
        else sum=0;
        for(int i=1;i<len;i++){
            if(nums[i] <0 ) {if(prev< sum) prev=sum;}
            if(max<nums[i]) {max=nums[i];}

            sum+=nums[i];
            if(sum<0) {sum=0;}
            if(prev<sum){
                prev=sum;
            }
        }
        if(max<0) return max;

        return prev;
    }


//DP

    public int maxSubAF(int []nums){
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<n;i++){
            dp[i]= dp[i-1] < 0 ? nums[i]: dp[i-1]+nums[i];
            max=Math.max(dp[i],max);

        }
        return max;
    }




//
    public int maxSubAS(int []nums){
        int cur=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            cur=Math.max(cur+nums[i],nums[i]);
            max=Math.max(cur,max);
        }
        return max;
    }



//
     public int maxSubT(int []nums){
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0;i<nums.length;i++) {
            if (sum < 0) {
                sum = nums[i];
            } else
                sum += nums[i];

            if (sum > max) {
                max = sum;
            }
        }
        return max;
     }
}
