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
