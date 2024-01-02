//  Time Complexity: O(n)
//  Space Complexity: O(1)
class Solution {
    public int calculate(String s) {
        int curr = 0;
        int tail = 0;
        int calc = 0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c!= ' ' || (i == s.length() -1)){
                if(lastSign == '+'){
                    calc += curr;
                    tail = curr;
                }else if(lastSign == '-'){
                    calc -= curr;
                    tail = -curr;
                }else if(lastSign == '*'){
                    calc = calc - tail + (curr * tail);
                    tail = curr * tail;
                }else if(lastSign == '/'){
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;    
    }
}



//  Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int result = 0;
        char lastSign = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c!= ' ' || (i == s.length() -1)){
                if(lastSign == '+'){
                    stack.push(curr);
                }else if(lastSign == '-'){
                    stack.push(-curr);
                }else if(lastSign == '*'){
                    int popped = stack.pop();
                    stack.push(curr * popped);
                }else if(lastSign == '/'){
                    int popped = stack.pop();
                    stack.push(popped/curr);
                }
                curr = 0;
                lastSign = c;
            }
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }
}