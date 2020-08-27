/*
  time: O(n)
  space: O(n)
  Run on leetcode:yes
*/
class Solution {
    public int calculate(String s) {
        int ret = 0;
        if(s.length() == 0)
            return ret;

        Stack<Integer> stk = new Stack<>();
        int num = 0;
        char last = '+';
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = (num*10)+(ch-'0');
            }
            else if(ch != ' '){
                if(last == '+') stk.push(num);
                else if(last == '-')stk.push(-num);
                else if(last == '*')stk.push(stk.pop()*num);
                else if(last == '/')stk.push(stk.pop()/num);
                num = 0;
                last = ch;
            }
        }

        //do this again for last num and sign.
        if(last == '+') stk.push(num);
        else if(last == '-')stk.push(-num);
        else if(last == '*')stk.push(stk.pop()*num);
        else if(last == '/')stk.push(stk.pop()/num);

        while(!stk.isEmpty()){
            ret += stk.pop();
        }
        return ret;
    }
}
