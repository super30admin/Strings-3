//Time Complexity: O(n) where n is the length of the string
//Space Complexity: O(n)

//Successfully runs on leetcode 

//Approach: We track the precedence of the signs using stack and calculate the result and store it back in the stack.

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char lastSign = '+';
        int lastNumber = 0;
        int result = 0;
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                lastNumber = lastNumber * 10 + c - '0';
            }           
            if((!Character.isDigit(c) && c != ' ') || i == n - 1)
            {
                if(lastSign == '+')
                    stack.push(lastNumber);
                else if(lastSign == '+')
                    stack.push(-lastNumber);
                else if(lastSign == '*')
                    stack.push(stack.pop() * lastNumber);
                else
                    stack.push(stack.pop() / lastNumber);
                lastSign = c; lastNumber = 0;
            }
        }
        
        while(!stack.isEmpty())
        {
            result += stack.pop();
        }
        return result;
    }
}