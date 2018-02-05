package Week68;

import com.sun.corba.se.spi.monitoring.StringMonitoredAttributeBase;
import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.*;

public class ReorganizeString {
    public static void main(String[] args) {
        String ab="";

        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();



        //ab=new ReorganizeString().run(s);
        ab=new ReorganizeString().reorganizeString(s);
        System.out.println(ab);
    }

    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq=new PriorityQueue <>((a,b)->b[1]-a[1]);
        int [] m =new int[26];
        for(int i=0; i<S.length(); i++){
            m[S.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++){
            if(m[i]!= 0){
                pq.offer(new int[] {i,m[i]});
            }
        }
        int [] pre=new int[] {-1,0};


        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(pre[1]>0)  {pq.offer(pre);}

            sb.append((char)(cur[0]+'a'));
            //sb.append((char)(cur[0] + 'a'));

            cur[1]--;
//            if(cur[1]>0){
//                pq.offer(cur);
//            }
            pre=cur;
            if(pq.isEmpty () &&pre[1]>0){
                return "";
            }

        }

        return sb.toString();

    }



    public String run(String S){
        HashMap<String,Integer> hashMap=new HashMap <String, Integer>();
        String sapp="";
        String[] scur= S.split("");




        int max1 = 1;
        String maxs1 = scur[0];
        String lasts="";
        for (String sc : scur) {

            if (!hashMap.containsKey(sc)) {
                hashMap.put(sc, 1);

            } else {
                hashMap.put(sc, hashMap.get(sc) + 1);
                if(hashMap.get(sc)>max1){
                    max1=hashMap.get(sc);
                    maxs1=sc;
                }

            }
        }

        Set<String> findlast=hashMap.keySet();
        Iterator<String>  iteratorlast=findlast.iterator();
        if(hashMap.size()==2){
            String key1=iteratorlast.next();
            int value1=hashMap.get(key1);
            String key2=iteratorlast.next();
            int value2=hashMap.get(key2);
            int sum=value1+value2;

            if(Math.abs(value1-value2)<2){
                while (sum>0){
                    if(value1>value2){
                        sapp=sapp+key1;
                        if(value1==1){
                            hashMap.remove(key1);
                        }
                        value1--;
                        hashMap.put(key1,value1);
                        if(value2>0) {
                            sapp = sapp + key2;
                            if (value2 == 1) {
                                hashMap.remove(key2);
                            }
                            value2--;
                            hashMap.put(key2,value2);
                        }

                    }else{
                        sapp=sapp+key2;
                        if(value2==1){
                            hashMap.remove(key2);
                        }
                        value2--;
                        hashMap.put(key2,value2);
                        if(value1>0) {


                            sapp = sapp + key1;

                            if (value1 == 1) {
                                hashMap.remove(key1);
                            }
                            value1--;
                            hashMap.put(key1,value1);
                        }
                    }
                    sum=sum-2;

                }
            }
            return sapp;
        }


        while (iteratorlast.hasNext()) {
             lasts = iteratorlast.next();
        }
        int lastt=hashMap.get(lasts);

        hashMap.remove(lasts,lastt);


        String maxs=maxs1;

        for (HashMap.Entry<String, Integer> entry : hashMap.entrySet()) {  // Itrate through hashmap
            if (!entry.getKey().equals(maxs1)) {

                max1 =max1- entry.getValue();     // Print the key with max value

                if(Math.abs(max1)<2){
                    break;
                }
            }
        }

        if(Math.abs(max1)<2) {

            while (hashMap.size()>0) {
                if(hashMap.containsKey(maxs1)) {
                    hashMap.put(maxs1, hashMap.get(maxs1) - 1);
                    sapp = sapp + maxs1;

                    if (hashMap.get(maxs1) == 0) {
                        hashMap.remove(maxs1);

                    }
                }




                Set<String> keys = hashMap.keySet() ;// 得到全部的key
                Iterator<String> iter = keys.iterator() ;
                while(iter.hasNext()){

                    String key = iter.next() ;


                    if ((!key.equals(maxs))) {
                        if(sapp.endsWith(key)&&(iter.hasNext())){
                            key=iter.next();

                        }
                        sapp = sapp + key;
                        hashMap.put(key, hashMap.get(key) - 1);
                        if (hashMap.get(key) == 0) {
                            hashMap.remove(key);
                        }
                        break;

                    }


                }
            }
        }

        return sapp;
    }

}
