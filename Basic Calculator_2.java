// Time Complexity - O(n) where n is the length of the string.
// Space Complexity - O(n) where n is the length of the string.

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() ==0)   return 0;
        Stack<Integer> st = new Stack<>();
        int num =0;
        char exp ='+';  
        for(int i=0;i < s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){           
                num = num * 10 + c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){ 
                if(exp == '*') st.push(st.pop() * num); 
                if(exp == '/') st.push(st.pop() / num);
                if(exp == '+') st.push(num);
                if(exp == '-') st.push(-num);  
                exp = c;               
                num = 0;                
            }
        }
        num =0;
        while(!st.isEmpty()){
            num +=st.pop();
        }
        return num;
    }
}