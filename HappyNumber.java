import java.util.*;

public class HappyNumber {
    public static void main(String[] args) {


        System.out.println(isHappySet(1));
    }

    //Set
    public static boolean isHappySet(int n) {
        Set<Integer> inLoop=new HashSet <>();

        while(inLoop.add(n)){
            int ans=0;
            while(n>0){
                int temp=n%10;
                ans+=temp*temp;
                n=n/10;
            }
            if(ans==1){
                return true;
            }else {
                n=ans;
            }

        }
        return false;
    }

    //HashMap
    public static boolean isHappyHashMap(int n){
        HashMap<Integer,Integer> hashMap=new HashMap <>();
        int flag=0, ans=0;
        while(ans!=1){
            ans=0;
            while(n>0){
                int temp=n%10;
                ans+=temp*temp;
                n=n/10;
            }
            n=ans;
            if(hashMap.containsKey(ans)){
                flag=1;
                break;
            }else{
                hashMap.put(ans,1);
            }


        }
        if(flag==0){
            return true;
        }else{
            return false;
        }

    }


}
