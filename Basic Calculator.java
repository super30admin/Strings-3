//  Time Complexity: O(n)
//  Space Complexity: O(n)
class Solution {
    public int calculate(String s) {
        int result = 0;
        int curr = 0;
        int lastSign = 1;
        int open_brace = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }else if(c == '('){
                stack.push(lastSign);
                stack.push(open_brace);
                curr = 0;
                lastSign = 1;
            }else if(c == ')'){
                stack.push(curr * lastSign);
                int temp = 0;
                while(stack.peek() != open_brace){
                    temp += stack.pop();
                }
                stack.pop();
                stack.push(temp * stack.pop());
                curr = 0;
                lastSign = 1;
            }else if(c =='+'){
                stack.push(curr * lastSign);
                curr = 0;
                lastSign = 1;
            }else if(c =='-'){
                stack.push(curr * lastSign);
                curr = 0;
                lastSign = -1;
            }
        }

        if(curr != 0) stack.push(curr * lastSign);

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        return result;

    }
}