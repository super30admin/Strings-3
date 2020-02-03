// Time Complexity - O(n) where n is the length of the String . traverse through the string 
// Space Complexity - O(n) where n is the length of the string. space used by the stack
// This Solution worked on LeetCode

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() ==0)   return 0;
        Stack<Integer> st = new Stack<>();
        int num =0;
        char exp ='+';  // Initialize with + so as to take care of the edge case when the string has only 1 number
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){           // If the character is digit get the number by subtracting '0' . *10 is used to take care of numbers greater than single digit numbers
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){ // if c is not digit and space or c is the last character of the string. exp will hold the last sign
                if(exp == '*') st.push(st.pop() * num); // if the last sign is * multiply the number on top of stack with num and push the result on stack
                if(exp == '/') st.push(st.pop() / num);
                if(exp == '+') st.push(num);
                if(exp == '-') st.push(-num);  // if the last sign is - push the number with sign on stack. This will be useful for add operations after the string ends
                exp = c;                // update the last sign with new operation character      
                num = 0;                // Update the num to 0 since num is already processed now
            }
        }
        num =0; // Initialize the num to 0 and use to to save the running sum of the stack elements 
        while(!st.isEmpty()){
            num +=st.pop();
        }
        return num;
    }
}
