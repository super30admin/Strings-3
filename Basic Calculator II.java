// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int calculate(String s) {
        //edge 
        if(s.length() == 0 || s == null) return 0;
        //create the result int to be returned
        int res = 0;
        //set the length of the string
        int m = s.length();
        //set the lastSign with +
        char lastS = '+';
        //the added num int
        int num = 0;
        //create the stack
        Stack<Integer> st = new Stack<>();
        //start a for loop to go through the string
        for(int i = 0; i < m; i++){
            //get the char
            char c = s.charAt(i);
            //check if it is a digit
            if(Character.isDigit(c)){
                //add to the num
                num = num * 10 + c - '0';
            }
            //if it is not a digit and not a space or the end of the string
            if((!Character.isDigit(c) && c != ' ') || i == m -1){
                //do all four operators only * / have stack pops
                if(lastS == '+') st.push(num);
                else if(lastS == '-') st.push(-num);
                else if(lastS == '*') st.push(st.pop() * num);
                else if(lastS == '/') st.push(st.pop()/num);
                //reset num to 0
                num = 0;
                //change lastS back
                lastS = c;
            }
        }
        //while loop to go through the stack and add the remaining 
        while(!st.isEmpty()){
            res += st.pop();
        }
        return res;
    }
}