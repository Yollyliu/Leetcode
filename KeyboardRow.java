import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyboardRow {
    public static void main(String[] args) {
        String [] words=new String[]{"Hello","Alaska","Dad","Peace"};
        String[] ans=findWordsSet(words);
        for(String s:ans){
            System.out.println(s);
        }

    }

   // set
    public static String[] findWordsSet(String[] words) {
        Set<Character> setF=new HashSet <>();
        Set<Character> setS=new HashSet <>();
        Set<Character> setT=new HashSet <>();


        List<String> ans = new ArrayList<String>();

        setF.add('q');
        setF.add('w');
        setF.add('e');
        setF.add('r');
        setF.add('t');
        setF.add('y');
        setF.add('u');
        setF.add('i');
        setF.add('o');
        setF.add('p');

        setS.add('a');
        setS.add('s');
        setS.add('d');
        setS.add('f');
        setS.add('g');
        setS.add('h');
        setS.add('j');
        setS.add('k');
        setS.add('l');

        setT.add('z');
        setT.add('x');
        setT.add('c');
        setT.add('v');
        setT.add('b');
        setT.add('n');
        setT.add('m');
        int row=-1;

        for(String s:words){
            boolean flag=true;
            String temp=s.toLowerCase();
            if(!setF.add(temp.charAt(0))){
                row=1;
            }else if(!setS.add(temp.charAt(0))){
                row=2;
            }else if(!setT.add(temp.charAt(0))){
                row=3;
            }
            System.out.println("the row of "+ s +" belongs to "+ row);

            for(char c:temp.toCharArray()){
                if(row==1){
                    if(setF.add(c)){
                        flag=false;
                        break;
                    }
                }else if(row==2){
                    if(setS.add(c)){
                        flag=false;
                        break;
                    }
                }else if(row==3){
                    if(setT.add(c)){
                        flag=false;
                        System.out.println("the current letter is "+c);
                        break;
                    }
                }
                System.out.println("the flag is "+flag);


            }
            if(flag){
                ans.add(s);
            }

        }
        return ans.toArray(new String[0]);


    }

// nothing
    public static  String[] findWords(String[] words) {
        String[] letters = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> ans = new ArrayList<String>();
        for (String word : words) {
            boolean pass = true;
            int row = 0;
            if (letters[1].indexOf(word.toLowerCase().charAt(0)) >= 0)
                row = 1;
            else if (letters[2].indexOf(word.toLowerCase().charAt(0)) >= 0)
                row = 2;
            for (char c : word.toLowerCase().toCharArray()) {
                if (letters[row].indexOf(c) == -1) {
                    pass = false;
                    break;
                }
            }
            if (pass)
                ans.add(word);
        }
        return ans.toArray(new String[ans.size()]);
    }



//

    public static String[] findWordsMatch(String[] words) {
        List<String> result = new ArrayList<>();
        for (String s : words)
            if (s.matches("[QqWwEeRrTtYyUuIiOoPp]+|[AaSsDdFfGgHhJjKkLl]+|[ZzXxCcVvBbNnMm]+"))
                result.add(s);
        return result.toArray(new String[0]);
    }

}
