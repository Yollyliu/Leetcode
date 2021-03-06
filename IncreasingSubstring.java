// Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

// We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

// Example 1:
// Input: [4,2,3]
// Output: True
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// Example 2:
// Input: [4,2,1]
// Output: False
// Explanation: You can't get a non-decreasing array by modify at most one element.

//Tips: before you do that, you should analysis all the conditions, if you ingore any part of possible condition, you will 
//pitch up for a long time.









package array;

import java.util.Scanner;

public class IncreasingSubstring {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();

        int []arr=new int[m];
        for(int i=0;i<m;i++){

                arr[i] = scanner.nextInt();

        }

        boolean ans=new IncreasingSubstring().sortMethod(arr);
        System.out.println(ans);
    }

    public int run(int []nums){
        if(nums.length==0) {return 0;}
        int max=1,ans=1, pre=ans;
        int curr=1;
        while(curr<nums.length) {
            {
                if (nums[curr] > nums[curr - 1]) {
                    ans++;
                    curr++;
                    pre = ans;
                } else {

                    ans = 1;
                    curr++;
                }
            }
                if (pre >= max) {
                    max = pre;
                }



        }

        if(max==0) {return 1;}

        return max;
    }

    public boolean nonDecreading(int [] nums) {
        if ((nums.length == 1) || (nums.length == 2)) {
            return true;
        }

         else {
            int mark[]={-1,-1};
            int cur = 0;
            int balance = -1, pos = -1;
            while (cur < nums.length - 1) {
                if (nums[cur] > nums[cur + 1]) {
                    balance++;
                    if(balance==1) {return false;}
                    else {
                        mark[balance++] = cur;
                    }

                }
                cur++;
            }

            if (balance == -1) {
                return true;
            } else {
                if ((mark[0] == 0)||(mark[0]==nums.length-1)||(mark[0]==nums.length-2)) {
                    return true;
                }
                if (!(!(nums[mark[0] +2] - nums[mark[0]] < 0)||!(nums[mark[0]+1]-nums[mark[0]-1]<0))) {
                    return false;
                }
            }
        }
            //if(balance>=0)  {ans=true;}
            return true;
        }


       public  boolean  sortMethod(int []nums){
          int count=0;
          for(int i=1;i>nums.length&&count<=1;i++){
              if(nums[i-1]>nums[i]){
                  if((i-2<0)||nums[i]>=nums[i-2]) {nums[i-1]=nums[i];}
                  else  {nums[i]=nums[i-1];}
              }
          }
          return count<=1;
       }


}


