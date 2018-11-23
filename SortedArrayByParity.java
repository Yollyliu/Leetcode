public class SortedArrayByParity {
    public static void main(String[] args) {
        int[] A=new int[]{4,2,5,7};
        int[] B=sortArrayByParityII(A);
        for(int i:A){
            System.out.print(i+" ");
        }

    }
    public static int[] sortArrayByParityII(int[] A) {
        for(int i=0;i<A.length;i++){
            if(i%2==0){          //i is even
                if(A[i]%2!=0){
                    int j=i;
                    while(A[j]%2!=0 && j<A.length){
                        j++;
                    }
                    int temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;

                }
            }else{          //odd

                if(A[i]%2==0){
                    int j=i;
                    while(A[j]%2==0  && j<A.length){
                        j++;
                    }
                    int temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;
                }

            }
        }
        return A;

    }

    public int[] sortArrayByParityIITwoIndex(int[] A) {
        int i = 0;
        int j = 1;
        while((i < A.length-1) && (j < A.length)) {
            if((A[i] % 2 != 0) && (A[j] % 2 != 1)) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            if(A[i] % 2 == 0) i = i + 2;
            if(A[j] % 2 == 1) j = j + 2;
        }
        return A;
    }

    public int[] sortArrayByParityIIThreeArray(int[] A) {
        int[] odd = new int[A.length/2];
        int[] even = new int[A.length/2];
        int[] res = new int[A.length];

        int evenIndex = 0;
        int oddIndex = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                even[evenIndex++] = i;

            }
            else {
                odd[oddIndex++] = i;
            }
        }

        int index = 0;
        for (int i = 0; i < A.length - 1; i+=2) {
            res[i] = even[index];
            res[i + 1] = odd[index];
            index++;
        }

        return res;
    }
}
