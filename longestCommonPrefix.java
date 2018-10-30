


public class longestCommonPrefix {

    public static void main(String[] args) {

        String[] str={"abc", "abd","ac"};
        System.out.println(Horizontal(str));
    }


    //horizontal
    public static String Horizontal(String[] strs){
        if(strs.length==0){
            return "";

        }else{
            String prixf=strs[0];
            for(int i=1;i<strs.length;i++){

                System.out.println(prixf);
                while(strs[i].indexOf(prixf)!=0){
                    System.out.println(strs[i].indexOf(prixf));
                    prixf=prixf.substring(0,prixf.length()-1);
                    if(prixf.isEmpty()){
                        return "";
                    }
                    System.out.println(prixf);
                }
            }
            return prixf;
        }

    }


    //vertical
    public static String vertical(String[] strs){
        if(strs==null || strs.length==0) return "";
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);

            for(int j=1;j<strs.length;j++){
                if(i==strs[j].length()||strs[j].length()!=c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }


    //divide and conquer
    public static String DivideConqu(String[] strs){
        if(strs==null || strs.length==0) return "";

        return DivideConquer(strs,0,strs.length-1);
    }

    public static String DivideConquer(String[] strs, int l,int r){
        if(l==r){
           return strs[l];
        }else{
            int mid=l+r/2;
            String left=DivideConquer(strs,l,mid);
            String right=DivideConquer(strs,mid+1,r);
            return comPrefix(left,right);


        }
    }

    public static String comPrefix(String left, String right){
        int min=Math.min(left.length(),right.length());
        for(int i=0;i<min;i++){
            if(left.charAt(i)!=right.charAt(i)){
                return left.substring(0,i);
            }
        }
        return left.substring(0,min);
    }

    public String binarySearch(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }


}