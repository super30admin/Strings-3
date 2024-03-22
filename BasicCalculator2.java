// Time Complexity : O(n), length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Keeping BODMAS rule in mind iterate over the string and compute value based on precedence of operators


class Solution {
    public int calculate(String s) {
        int curr = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                curr = curr * 10 + ch - '0';
            }
           if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1){
                if(lastSign == '+'){
                    calc += curr;
                    tail = curr; 
                } else if(lastSign == '-'){
                    calc -= curr;
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
                
                curr = 0;
                lastSign = ch;
            }
        }

        return calc;
    }
}


//Using stacks
// Time Complexity : O(n), length of string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : to give precedence to / and * operations, keep adding it to the stack and if * or /, compute the value with last-in number from the stack.


class Solution {
    public int calculate(String s) {
        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                curr = curr * 10 + ch - '0';
            }
           if((!Character.isDigit(ch) && ch != ' ') || i == s.length()-1){
                if(lastSign == '+'){
                    st.push(curr);
                } else if(lastSign == '-'){
                    st.push(-curr);
                }
                else if(lastSign == '*'){
                    st.push(curr * st.pop());
                }else {
                    st.push(st.pop()/curr);
                }
                
                curr = 0;
                lastSign = ch;
            }
        }
        int calc = 0;
        while(!st.isEmpty()){
            calc += st.pop();
        }

        return calc;
    }
}