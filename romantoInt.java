public class romantoInt {


    public static void main(String[] args) {

        System.out.println(roman("LVIII"));
    }

    public static int roman(String s){

        int ans=0;
        for(int i=0;i<s.length();i++){
            if(i<=s.length()-2) {
                if (smaller(s.charAt(i), s.charAt(i + 1))) {
                    ans = ans + getNum(s.charAt(i + 1)) - getNum(s.charAt(i));
                    i=i+1;

                } else {
                    System.out.println("1");
                    ans =ans+ getNum(s.charAt(i));

                }

            }else if(i==s.length()-1){
                System.out.println("2");
                ans=ans+getNum(s.charAt(i));
            }
        }
        return ans;
    }

    public static boolean smaller(char a, char b){
        System.out.println("hello");
        if((a=='I' && (b=='V' || b=='X'))||
                ((a=='X') && ((b=='L')||(b=='C')))||
                        ((a=='C') && (b=='D' || b=='M'))){
            return true;
        }
        return false;


    }

    public static int getNum(char a){
        if(a=='I'){
            return 1;
        }else if(a=='V'){
            return 5;
        }else if(a=='X'){
            return 10;
        }else if(a=='L'){
            return 50;
        }else if(a=='C'){
            return 100;
        }else if(a=='D'){
            return 500;
        }else {
            return 1000;
        }
    }
}
