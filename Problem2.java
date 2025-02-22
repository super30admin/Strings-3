public class Problem2 {
    class Solution {
        //t.c -> O(n)
        //s.c -> O(1)
        public int calculate(String s) {
            if(s==null ||s.length() ==0){
                return 0;
            }
            int cal = 0;
            int tail = 0;
            int num = 0;
            char lastSign = '+';
            for(int i =0;i<s.length();i++){
                char c =s.charAt(i);
                if(Character.isDigit(c)){
                    num = num * 10 + c - '0';

                }
                if((!Character.isDigit(c) && c!= ' ')||(i ==s.length()-1)){
                    if(lastSign == '+'){
                        cal = cal +num;
                        tail = +num;
                    }
                    if(lastSign == '-'){
                        cal = cal - num;
                        tail = -num;
                    }
                    if(lastSign == '*'){
                        cal = cal - tail + (tail * num);
                        tail = tail * num;
                    }
                    if(lastSign == '/'){
                        cal = cal - tail + (tail / num);
                        tail = tail / num;
                    }
                    lastSign = c;
                    num = 0;

                }
            }
            return cal;
        }
    }
}
