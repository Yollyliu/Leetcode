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
