import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,2,1};
        int[] nums2=new int[]{2,2};
        int[] result= intersectionMap(nums1,nums2);
        for(int i:result) {
            System.out.print(i+ " ") ;
        }

    }
    public static int[] intersectionMap(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums1.length; i++){
            map.put(nums1[i],0);
        }

        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])){
                hs.add(nums2[i]);
            }
        }
        int[] out = new int[hs.size()];
        ArrayList<Integer> list = new ArrayList<Integer>(hs);
        for(int i=0;i<list.size();i++) {
            out[i]=list.get(i);
        }
        return out;

    }


    public static int[] intersectionSet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }



}
