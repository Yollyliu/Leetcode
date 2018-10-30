public class isPalindrome {

    public static void main(String[] args) {

        System.out.print( leetSolution(12321));;
    }

    public static boolean isP(int x){
        if(x<0){
            return false;
        }

        else{
            int y=x,ans=0;
            while(y>0){
                int p=y%10;
                ans=ans*10+p;
                y=y/10;
            }

            System.out.println(ans);
            if(ans==x) {

                return true;
            }else{
                return false;
            }
        }
    }

    // just half of the sentence
    public static boolean leetSolution(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }


}
