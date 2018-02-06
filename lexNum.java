package Week69;

import java.util.*;

public class lexNum {
    public static void main(String[] args) {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        new lexNum().lexicalOrder(num);
    }

    public List <Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList <Integer>();
        int cur=1;
        for(int i=1;i<=n;i++){
            list.add(cur);
            if(cur*10 <= n){
                cur*=10;
            }else if((cur%10!=9)&&(cur+1<= n)){
                cur++;
            }else {
                while((cur/10)%10==9){
                    cur/=10;
                }
                cur = cur/10 +1;
            }
        }


        while((cur/10)%10!=9){
            cur/=10;
        }
        cur=cur/10+1;

//        List <String> liststr = new ArrayList <String>();
//        List <Integer> list = new ArrayList <Integer>();
//        for (int i = 0; i < n; i++) {
//            String s = String.valueOf(i+1);
//            liststr.add(s);
//        }
//        String temp="";
//        for(int i=0;i<n-1;i++) {
//            //String min = liststr.get(i);
//            for (int j = i + 1; j < n; j++) {
//                int dif = 0;
//                dif = liststr.get(i).compareTo(liststr.get(j));
//                if (dif > 0) {
//                    temp = liststr.get(j);
//                    liststr.set(j, liststr.get(i));
//                    liststr.set(i, temp);
//                    //min=liststr.get(i);
//                    //min = liststr.get(j);
//                }
//
//
//            }
//        }
//        for(int i=0;i<n;i++){
//            list.add(i,Integer.parseInt(liststr.get(i)));
////            try {
////                list.add(i,Integer.parseInt(temp));
////            } catch (NumberFormatException e) {
////                System.out.println("something is wrong");
////                //Will Throw exception!
////                //do something! anything to handle the exception.
////            }
//
//        }
////        try {
////            list.add(Integer.parseInt(liststr.get(liststr.size())));
////        }catch (NumberFormatException e){
////            System.out.println("something is wrong");
////        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
//
       return list;
    }
}


