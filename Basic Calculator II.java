/*
class Solution:
    def calculate(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        
        stack = []
        num = 0
        lastsign = '+'
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + ord(s[i]) - ord('0')
                
            if (not s[i].isdigit() and s[i] != ' ') or i == len(s) - 1:
                
                if lastsign == '+':
                    stack.append(num)
                    
                    
                if lastsign == "-":
                    stack.append(-num)
                
                if lastsign == "*":
                    stack.append(stack.pop() * num)
                    
                
                if lastsign == "/":
                    temp = stack.pop()
                    if temp < 0:
                        temp = -(-temp // num)
                    else:
                        temp = temp // num
                    stack.append(temp)
                
                num = 0
                lastsign = s[i]
                
        answer = 0
        while len(stack) > 0:
            answer += stack.pop()
        return answer
*/

// Time - O(n) n is size of s
// Space - O(n) for stack
// Logic - Calculated string from left to right wit higher precedence operator calculated on the spot and lower precendence goes on stack

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int answer = 0, num = 0;
        char lastsign = '+';
        Stack<Integer> st = new Stack<>();
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            
            if ((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)){  // <-- this last condition is imp as it has to go inside after last digit
                if (lastsign == '+'){
                    st.push(num);
                }
                else if (lastsign == '-'){
                    st.push(-num);
                }
                else if (lastsign == '*'){
                    st.push(st.pop() * num);
                }
                else{
                    st.push(st.pop() / num);
                }
                
                lastsign = c;
                num = 0;
            }
        }
        while (!st.isEmpty()){
            answer += st.pop();
        }
        return answer;
    }
}