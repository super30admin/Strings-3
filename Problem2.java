/**
LeetCode Submitted : YES
Space Complexity : O(len(s))
Time Complexity : O(len(s))

The idea is to use stack to store intermediate results. We will be maintianing currNum and currOp which will store last encountered operation. On encountering a new operation we will check and add to Stack. Also, if we encounter division and multiplication pop the top element from stack and perform appropriate operation with currNum.

**/
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() < 1)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        char currOp  = '+';
        int  currNum = 0;
        int sum = 0;
        
        for(int i = 0; i<s.length();i++){
            char curr = s.charAt(i);
            
            //Add digit to currNum
            if(Character.isDigit(curr))
                currNum = currNum*10 + Character.getNumericValue(curr);
            
            //Add to Stack operation if not a digit and last character
            if((!Character.isDigit(curr) && curr != ' ') || i == s.length() - 1){
                if(currOp == '+')
                    st.push(currNum);
                else if(currOp == '-')
                    st.push(-currNum);
                else if(currOp == '*')
                    st.push(currNum * st.pop());
                else
                    st.push(st.pop()/currNum);
                
                currOp = curr;
                currNum = 0;
            }
        }
        
        //Pop all elements of stack and summing it up
        while(!st.isEmpty())
            sum += st.pop();
        
        return sum;
        
    }
}
