import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] array=new int[]{2,2,1};
        System.out.println(singleNumberXor(array));


    }
    //hashmap
    public static int singleNumberHashMap(int[] nums) {
        int result=0;
        HashMap<Integer,Boolean> hashMap=new HashMap <>();
        for(int i:nums){
            if(hashMap.containsKey(i) ){
                hashMap.put(i,true);
            }
            else {
                hashMap.put(i,false);
            }
        }
       for(int i:hashMap.keySet()){
            if(!hashMap.get(i)){
                result=i;
            }
       }
       return result;

    }


    //
    public static int singleNumberSet(int [] nums){
        Set<Integer> set=new HashSet <>();
        for(int i:nums){
            if(!set.add(i)){
                set.remove(i);
            }
        }
        return set.iterator().next();
    }

    //
    public static int singleNumberXor(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }


}
