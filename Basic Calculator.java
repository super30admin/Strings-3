// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will maintain a stack for storing all the characters in the string. Two variables curr and lastSign to store the current value of the operator respectively. 
// Whenever we encounter a digit, we add it to current and whenevere we encounter an operator, we push the digit into the stack. When we encounter an opening bracket, 
// we push +1 or -1 into the stack according to the operator in the lastSign. This indicates the sign outside the opening bracket. When we come across a closing bracket, 
// we keep popping the elements from the stack and performing the operation associated with it until we get an opening bracket. After this we multiply it with +1 or -1 according to the sign which was given for the opening bracket.

class Solution {
    public int calculate(String s) {
        if (s==null || s.length()==0) return 0;
        s=s.trim();
        int curr=0; char lastSign='+';
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);

            //if character is a digit
            if(Character.isDigit(c))
            {
                curr=curr*10 + c- '0';
                //if we have reached the last character of the string
                if(i==s.length()-1)
                {
                    //check if lastSign is +ve or negative
                    if(lastSign=='+')  st.push(curr);
                    else               st.push(-curr);
                }
            }
            //if character is not a digit
            //if it is + or -
            else if(c=='+' || c=='-')
            {
                if(lastSign=='+')  st.push(curr);
                else               st.push(-curr);
                //reset the value of curr and lastSign
                curr=0; lastSign=c;
            }
            //if it is (
            else if(c == '(')
            {
                // we will maintain the sign given outside the opening bracket, hence we will push 1 or -1 into the stack, so we can later multiply it with the value inside
                if(lastSign=='+')  st.push(1);
                else               st.push(-1);
                st.push(Integer.MAX_VALUE); //We will push Integer.MAX_VALUE to denote we have reached an opening bracket
                //reset curr and lastSign
                curr=0;lastSign='+';
            }
            //if it is )
            else if(c==')')
            {
                //we will first push the curr value into the stack
                if(lastSign=='+')  st.push(curr);
                else               st.push(-curr);

                int interResult=0;
                //we will pop all the elements from the stack and perform the operation
                while(st.peek()!=Integer.MAX_VALUE) //until we get the opeining bracket
                {
                    interResult+=st.pop();
                }
                st.pop();   //we need to pop the Integer.MAX_VALUE as well
                //to give the sign outside the opening bracket to the calculated value, we will pop again and multiply it with the interResult
                interResult=interResult*st.pop();
                //we will push this value into the stack
                st.push(interResult);
                //reset curr and lastSign
                curr=0;lastSign='+';
            }
        }
        
        //we will add all the elements remaining in the stack
        int result=0;
        while(!st.isEmpty())
        {
            result+=st.pop();
        }
        return result;
    }
}