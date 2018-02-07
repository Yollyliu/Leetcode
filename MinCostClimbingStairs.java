// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

// Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

// Example 1:
// Input: cost = [10, 15, 20]
// Output: 15
// Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
// Example 2:
// Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
// Output: 6
// Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

//Tops: You should learn more algorithm when you get a question and have no idea.




package array;

import java.util.Scanner;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int []arr=new int[m];
        for(int i=0;i<m;i++){
            arr[i]=scanner.nextInt();
        }

        int ans=new MinCostClimbingStairs().run(arr);
        System.out.println(ans);
    }

    public int run(int [] cost) {

        int []dp=new int[cost.length+1];
        for(int i=2;i<=cost.length;i++){
            dp[i]=Math.min(cost[i-1]+dp[i-1],cost[i-2]+dp[i-2]);
        }
        return dp[cost.length];





//       int len= cost.length;
//       int ans1=0;
//       int curpos=len;
//
//        while(curpos>=2){
//            if(cost[curpos-1]>=cost[curpos-2]){
//                ans1+=cost[curpos-2];
//                curpos-=2;
//            }else{
//                if(curpos-3==0) {
//                    if ((cost[curpos - 1] + cost[curpos - 3]) < cost[curpos - 2]){
//                        ans1+=cost[curpos - 1] + cost[curpos - 3];
//                        curpos-=3;
//                    }else {
//                        ans1+=cost[curpos-2];
//                        curpos-=2;
//
//                    }
//
//                }else {
//                    ans1 += cost[curpos - 1];
//                    curpos -= 1;
//                }
//            }
//
//        }
//
//
//
//
//        int pos = -1;
//        int ans2 = 0;
//        int length = cost.length;
//        if(length==3){
//            if(cost[0]+cost[2]>cost[1]){
//                return cost[1];
//            }else{
//                return cost[0]+cost[2];
//            }
//        }
//
//
//        while (pos < length - 2) {
//            if (cost[pos + 1] >= cost[pos + 2]) {
//
//                    ans2 += cost[pos + 2];
//                    pos += 2;
//
//            } else {
//                if(pos+4==length){
//                    if((cost[pos+1]+cost[pos+3])<cost[pos+2]){
//                         ans2+=cost[pos+1]+cost[pos+3];
//                         pos+=3;
//                    }else {
//                         ans2+=cost[2];
//                         pos+=2;
//                    }
//
//                }else {
//                    ans2 += cost[pos + 1];
//                    pos += 1;
//                }
//
//            }
//
//        }
//
//
//
//
//        return ans1 > ans2 ? ans2 : ans1;
//

        //return ans2;
    }
}
