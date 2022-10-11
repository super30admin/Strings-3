// Time Complexity : O(n)
// Space Complexity :O(1)
// n is the length of input string
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//Approach 2 - Optimised using no extra space
//TC: O(n)
//SC: O(1)

class Solution {
    public int calculate(String s) {
        //null check
        if(s == null || s.length() == 0)
            return 0;

        int tail = 0;
        int calc = 0;
        int curr = 0;
        char lastSign = '+';

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            //check if it is a digit , convert to ascii value
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }

            //check if it is not a digit, check if there is a space in the given string and need to do the same for last digit as well
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }

                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }

                else if(lastSign == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }

                else{
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }

                //resest curr to 0 and lastSign is the character in for loop
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}

//Approach 1 - Using Stack
//TC: O(n)
//SC: O(n)

class Solution {
    public int calculate(String s) {
        //null check
        if(s == null || s.length() == 0)
            return 0;

        Stack<Integer> st = new Stack<>();

        int curr = 0;
        char lastSign = '+';

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            //check if it is a digit , convert to ascii value
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }

            //check if it is not a digit, check if there is a space in the given string and need to do the same for last digit as well
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1){
                if(lastSign == '+'){
                    st.push(curr);
                }

                else if(lastSign == '-'){
                    st.push(-curr);
                }

                else if(lastSign == '*'){
                    st.push(st.pop() * curr);
                }

                else{
                    st.push(st.pop() / curr);
                }

                //resest curr to 0 and lastSign is the character in for loop
                curr = 0;
                lastSign = c;
            }
        }

        int result = 0;

        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}