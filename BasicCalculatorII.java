/**
 * Algo: stack of all the numbers to be finally added and sent and assign the starting operator as '+'
 *      #traverse thr the entire string and when we stumble upon non digit and non space or end of string
 *              then we consider the lastop and based on that push the num to stack Ex: lastop = - then the num pushed ll be -num
 *                                                                                      lastop = '*' num is popped from stack and is multiplied with the num and pushed
 *      #finally traverse thr the stack and add the values and return it
 *
 *      Time: O(n) n- length of string
 *      Space: O(n)
 */
class Solution {
    public int calculate(String s) {
        int num = 0;
        int lastop = '+';
        Stack<Integer> stk = new Stack();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = (num*10) + s.charAt(i)-'0';
            }

            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1){
                char c = s.charAt(i);
                if(lastop == '+') stk.push(num);
                else if(lastop ==  '-') stk.push(-num);
                else if(lastop == '*') stk.push(stk.pop()*num);
                else if(lastop == '/') stk.push(stk.pop()/num);
                lastop = c; num = 0;
            }
        }

        int res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return res;
    }
}