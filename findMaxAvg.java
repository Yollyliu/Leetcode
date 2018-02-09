package array;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class findMaxAvg {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }

        double ans = new findMaxAvg().plus(arr);
        System.out.println(ans);
    }

    public double run(int[] nums, int k) {
        if((nums.length==0)||k==0) return 0;
        Queue <Integer> que = new LinkedList <Integer>();
        int sum = 0,prev=0;
        int cur=k;
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);
            sum += nums[i];
        }
        int max=sum;
        if(nums.length==k){return (double) sum/k;}

        while (cur < nums.length) {
            prev=sum;
            int last=que.poll();
            sum-=last;
            sum+=nums[cur];
            que.add(nums[cur]);
            cur++;

            if(max<sum) { max=sum;}

        }
        return (double) max/k;
    }


//    public int MaxnumProduct(int [] nums){
//
//
//    }






    public int plus(int[] nums) {         //wrong


        int max1 =Integer.MIN_VALUE, max2 = max1, max3 = max2;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (nums[i] > max2) {
                int temp = max3;
                max3 = max2;
                max2 = temp;
            }
            if (nums[i] > max1) {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }

            if(nums[i]<min2){
                min2=nums[i];
            }
            if(nums[i]<min1){
                int temp=min1;
                min1=min2;
                min2=temp;
            }



        }
      return max1*max2*max3 < max1*min2*min1 ? max1*min2*min1 :max1*max2*max3;

    }





//        int abs1=0,abs2=0,abs3=0,abs4=0,max1=0,max2=0,max3=0;  // abs1 is the largest, abs4 is the smallest.
//        for(int i=0;i<nums.length;i++){
//           if(Math.abs(nums[i])>abs4) {abs4=nums[i];}
//           if(Math.abs(nums[i])>abs3) {int temp=abs4; abs4=abs3; abs3=temp;}
//           if(Math.abs(nums[i])>abs2) {int temp=abs3; abs3=abs2; abs2=temp;}
//           if(Math.abs(nums[i])>abs1) {int temp=abs2; abs2=abs1; abs1=temp;}
//
//            if(Math.abs(nums[i])>max3) {max3=nums[i];}
//            if(Math.abs(nums[i])>max2) {int temp=max3; max3=max2; max2=temp;}
//            if(Math.abs(nums[i])>abs2) {int temp=max2; max1=max2; max2=temp;}
//        }
//        if(max1==0) {return 0;}
//        if((max1==abs1)&&(max2==abs2)&&(max3==abs3)) { return max1*abs2*abs3;}
//        if((max1!=abs1) && abs2*abs3<0) {return abs1*abs2*abs3;}
//        if((max1!=abs1) && )




}
