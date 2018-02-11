package array;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MoveZeroes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }

        new MoveZeroes().fourthMoveZeroes(arr);

        // System.out.print(ans);
    }

    public void run(int[] nums) {

        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] == 0) {
                int count = cur;
                while (count < nums.length - 1 && nums[count] == 0) {
                    count++;
                }
//               int i=count-cur;
//               while((nums.length-count>0)&&i>0){
                nums[cur] = nums[count];
                nums[count] = 0;
                cur++;

                //             }
            } else {
                cur++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }


    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    void secondMoveZeroes(int[] nums) {
        int current = 0;

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0)
                nums[current++] = nums[i];

        for (int i = current; i < nums.length; ++i)
            nums[i] = 0;
    }

    void thirdMoveZeroes(int[] nums) {
        int n = nums.length;

        // Count the zeroes
        int numZeroes = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                numZeroes++;
            }
        }

        // Make all the non-zero elements retain their original order.
        List <Integer> ans = new LinkedList <>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                ans.add(nums[i]);
            }
        }

        // Move all zeroes to the end
        while (numZeroes > 0) {
            ans.add(0);
            numZeroes--;
        }

        // Combine the result
        for (int i = 0; i < n; i++) {     //linkedlist index is same as array.
            nums[i] = ans.get(i);
        }
    }

    void fourthMoveZeroes(int[] arr) {
        for (int nonzeroposition = 0, cur = 0; cur < arr.length; cur++) {
            if (arr[cur] != 0) {
                arr[nonzeroposition++] = arr[cur];
                arr[cur] = 0;
            }
        }
        for (int i: arr)
            System.out.print(i+" ");
    }
}






