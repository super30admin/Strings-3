package Strings-3;
// TC: O(n)
// SC: O(1)
public class Problem2 {
    public int calculate(String s) {
        s.trim();
        int currNum=0, tail=0, calc=0;
        int lastSign='+';
        int n = s.length();
        for(int i=0;i<n;i++){
          char c = s.charAt(i);
          if(Character.isDigit(c)){
            currNum = currNum*10 + c-'0';
          }
          if((!Character.isDigit(c) && c != ' ') || i==n-1){
            if(lastSign=='+'){
              calc = calc + currNum;
              tail = currNum;
            }else if(lastSign == '-'){
              calc = calc - currNum;
              tail = -currNum;
            }else if(lastSign == '*'){
              calc = (calc-tail) + (tail*currNum);
              tail = currNum*tail;
            }else if(lastSign == '/'){
              calc = (calc-tail) + (tail/currNum);
              tail = tail/currNum;
            }
            lastSign=c;
            currNum=0;
          }
        }
        
        return calc;
      }
}
