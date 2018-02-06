// We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.

// The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].

// The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].

// Return true if and only if the number of global inversions is equal to the number of local inversions.

// Example 1:

// Input: A = [1,0,2]
// Output: true
// Explanation: There is 1 global inversion, and 1 local inversion.
// Example 2:

// Input: A = [1,2,0]
// Output: false
// Explanation: There are 2 global inversions, and 1 local inversion.
// Note:

// A will be a permutation of [0, 1, ..., A.length - 1].
// A will have length in range [1, 5000].
// The time limit for this problem has been reduced.

//Method 1:
//Tips: the only condition local=global is that for every pair, the first> second, and elements in front pair smaller than any 
//elements in following pairs. so we can get: max(max,A[i])<A[i+2]. For example A[1,0,3,2], A[i]< A[i+2], max(max,A[1])<A[i+2].


//Method 2:
//Tips: it says the permutation of[0,1,......,A.length-1], than in order to make local = global, x have three position:
//First, it is in A[x], as there is no local or global.
//Second, x is in A[x-1], only and only if A[x] must be x-1, then local = global =1.   x=1......A.length-1.
//So, we can get that Math.abs(A[x]-x)>1, it will be false.


//Sometimes, it is very hard to compute the right condition, so we should ask ourselves, "can i compute the wrong condition?"




















package Week69;

import java.util.Scanner;

public class globalLocalInversions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] A;
        int size=0;
        while(scanner.next()!=""){
            size++;

        }
        scanner.nextLine();
        A=new int[size];
        for(int i=0;i<size;i++){
            A[i]=scanner.nextInt();
        }

        new globalLocalInversions().run(A);
    }
     public boolean run(int [] A){

        int cmax=0;
        for(int i=0;i<A.length-2;i++){
//             cmax=Math.max(cmax,A[i]);
//             if(cmax>A[i+2]) {return false;
          //   }
            if(A[i]>A[i+2]){
                return false;
            }

        }
         System.out.println("it is true");
        return true;


//         for(int i=0;i<A.length-1;i++){
//             for(int j=i+1;j<A.length;j++){
//                 if(A[i]>A[j]){
//                     nglobal++;
//                 }
//             }
//             if(A[i]>A[i+1]){
//                 nlocal++;
//             }
//         }


//        if(nglobal==nlocal){
//            return true;
//        }
//        return false;

    }
}
