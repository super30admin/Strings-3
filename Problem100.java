/**
 * Time Complexity - O(n)
 * Space Complexity - O(n)  n = length of string
 */

class Solution {

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        char sign = '+';
        int num = 0;

        for(int i=0; i < s.length(); i++){

            if(Character.isDigit(s.charAt(i))){
                num = num*10 + (s.charAt(i)-'0');
            }

            if(i == s.length()-1 || (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i))){

                if(sign == '-')
                    stack.push(-num);
                else if(sign == '+')
                    stack.push(num);
                else if(sign == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);

                sign = s.charAt(i);
                num=0;
            }
        }

        int ans=0;

        for(int value : stack){
            ans += value;
        }

        return ans;

    }
}