package array;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DispearNum {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int []arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
        }
        List<Integer> list=new LinkedList<Integer>();

        list=new DispearNum().abs(arr);
        for(int i:list) {
            System.out.print(i+ " ");
        }
    }

    public List<Integer> hash(int []nums){
        List<Integer> list=new LinkedList<Integer>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            nums[(nums[i]-1)%nums.length]+=nums.length;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums.length){
                list.add(i+1);
            }
        }
        return list;
    }

    public List<Integer> abs(int []nums){
        List<Integer> list=new LinkedList<Integer>();
        int ans=0;
        for(int i=0;i<nums.length;i++) {
            int value = Math.abs(nums[i]) - 1;
            if(nums[value]>0){
                nums[value]=-nums[value];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }


}
