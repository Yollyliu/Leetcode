// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

// Example:

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]



//Tips: It seems a easy question without the reques of O(n) and no extra space.
// However, the keypoint is that: the number in  n length of array must from 1 to n. So i position must same with some
//position j, that nums[i]==nums[j].
//As a result, if we do some operator to nums[nums[i]], then we get some different scope of values in all the array except 
//the ones with position i+1.  
// As what we have changed is nums[nums[i]-1], suppose the position of finial nums in different scope j, as it shows,
//as a result, we can conclude: j= nums[i]-1,  => nums[i]=j+1; As the nums[i] is missing.


// we can use many methods to change the scope of values, for exmaple, let it become negative, or larger than n, and so on.
















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
