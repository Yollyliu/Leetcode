// Say you have an array for which the ith element is the price of a given stock on day i.

//Q1: you are allowed to do as many operators as you want, but you should just keep in one item.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
//design an algorithm to find the maximum profit.



// Two ways for Q1 and seven for Q2.



package array;

import java.util.Arrays;
import java.util.Scanner;

public class MaxProfit {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }
        //int n=scanner.nextInt();

        int ans = new MaxProfit().oneActionProfitF(arr);
        System.out.println(ans);
    }
    int maxPrice(int[] prices) {
        //build an array for the difference of price, i stand for i buy and sell in i+1
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        //if(len==2) {return prices[0]-prices[1] > 0 ?  prices[0]-prices[1] : 0;}

        int[] dif = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            dif[i] = prices[i + 1] - prices[i];
        }
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            if (dif[i] >= 0) {
                sum += dif[i];
            }
        }

        return sum;

    }

    int greedySumPrice(int[] prices) {
        int i = 0, sum = 0;
        while (i < prices.length) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) i++;
            int min = prices[i++];

            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) i++;
            sum += i < prices.length ? prices[i++] - min : 0;
        }
        return sum;

    }


    int oneActionProfitF(int [] prices){
        int len=prices.length;
        if(len==0 || len==1 ){return 0;}
        int [] nums=new int [len-1];
        for(int i=0;i<len-1;i++){
            nums[i]=prices[i+1]-prices[i];   //first, build an array for the profit
        }
        int sum=0,prev=0,max=0;
        for(int i=0;i<len-1;i++){    //second, for everyday profit, create two recording

            if(nums[i]<0) { if(prev< sum) prev=sum;}
            //one is the one before add negative
            sum+=nums[i];
            if(sum<0) {sum=0;} //of course, it is important reset sum if is negative
            if(prev<sum){     //other is the one after adding negative and positive
                prev=sum;
            }
            //the one without adding negative and laters compare with the one
            // adding negative and laters, make the largest to prev.
            if(max<prev) {   //fina
                max=prev;           //final, make max always be the largest one.
            }



        }
        return max;
    }



    int oneActionProfitT(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]-nums[i]>max){
                    max=nums[j]-nums[i];
                }
            }
        }
        return max;

    }

    int oneActionProfitThird(int [] nums){
        int min=Integer.MAX_VALUE;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(min<nums[i]){
                min=nums[i];
            }
            else if(nums[i]-min>max){
                max=nums[i]-min;
            }
        }
        return max;
    }

    int oneActionProfitFourth(int []nums){
        int curSum=0,Sum=0;
        for(int i=1;i<nums.length;i++){
            curSum=Math.max(0, curSum+=nums[i]-nums[i-1]);
            Sum=Math.max(curSum,Sum);
        }
        return Sum;
    }

    public int oneActionProfitFive(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public int oneActionProfitSix(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++)
            max = Math.max(max, prices[i] - (min = Math.min(min, prices[i])));
        return max;
    }

    int min = Integer.MAX_VALUE;
    public int maxProfitSeven(int[] prices) {
        return Arrays.stream(prices).map(i -> i - (min = Math.min(min, i))).max().orElse(0);
    }


}
