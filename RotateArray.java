package array;

import java.util.*;

public class RotateArray {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int []arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
        }
        //int n=scanner.nextInt();

        int ans=new RotateArray().maxPrice(arr);
        System.out.println(ans);
    }

    public void run(int []nums,int k) {
        int [] same=nums.clone();
        int len=nums.length;
        for(int i=0;i<len;i++){
            nums[(i+k)%len]=same[i];
        }

    }


    int majorityNumber(int []nums){

//first method
        HashMap<Integer,Integer> hashMap=new HashMap <Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        int max= Collections.max(hashMap.values());

        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            if(entry.getValue()==max){ return entry.getKey();}
        }

//second method
        Arrays.sort(nums);
        return nums[nums.length/2];




    }


    int [] twoSum(int[] nums, int target){
        int [] ans=new int[2];
        HashMap<Integer,Integer> hashMap=new HashMap <Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i+1);
        }

        for(int i=0;i<nums.length-1;i++){
            if(hashMap.containsKey(target-nums[i])){
                ans[0]=i+1;
                ans[1]=hashMap.get(target-nums[i]);
                return ans;
            }

        }
        return ans;
    }

    int maxPrice(int [] prices){
        //build an array for the difference of price, i stand for i buy and sell in i+1
        int len=prices.length;
        if(len==0) {return 0;}
        //if(len==2) {return prices[0]-prices[1] > 0 ?  prices[0]-prices[1] : 0;}

        int[] dif=new int[len-1];

        for(int i=0;i<len-1;i++) {
            dif[i] = prices[i + 1] - prices[i];
        }
        int sum=0;
        for(int i=0;i<len-1;i++){
            if(dif[i]>=0){ sum+=dif[i];}
        }

        return sum;

    }

    int greedySumPrice(int [] prices){
        int i=0,sum=0;
        while(i<prices.length) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) i++;
            int min = prices[i++];

            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) i++;
            sum += i < prices.length ? prices[i++] - min : 0;
        }
        return sum;

    }



}
