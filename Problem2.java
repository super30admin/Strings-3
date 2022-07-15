// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//227. Basic Calculator II
//https://leetcode.com/problems/basic-calculator-ii/

class Solution {
    // Approach two - Evaluate on the fly - works only when there are no brackets in
    // the expression - faster runtime compared to before
    // time: O(n)
    // space: O(1)
    public int calculate(String s) {

        int n = s.length();
        // null case
        if (n == 0)
            return 0;

        int num = 0;
        int tail = 0;
        int cal = 0;
        char lastSign = '+';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = (num * 10) + Character.getNumericValue(c);
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (lastSign == '+') {
                    cal = cal + num;
                    tail = num;

                } else if (lastSign == '-') {
                    cal = cal - num;
                    tail = -num;

                } else if (lastSign == '*') {
                    cal = cal - tail + tail * num;
                    tail = tail * num;

                } else if (lastSign == '/') {
                    cal = cal - tail + tail / num;
                    tail = tail / num;

                }

                num = 0;
                lastSign = c;
            }
        }

        return cal;
    }
}



/*
class Solution {
    // Approach one - evaluate all * and / first in the stack and then, in the end,
    // add all elements that are in the stack
    // time: O(n) - where n is the length of the string s
    // space: O(n) - the numbers in the stack will be n/2 or more
    public int calculate(String s) {
        
        int n = s.length();
        //null case
        if(n == 0) return 0;
        //make a stack
        Stack<Integer> st = new Stack<>();
        
        //have num and lastSign and initialize num to 0 and lastSign to + 
        int num = 0;
        char lastSign = '+'; //make it String or char, let's see
        
            
        //iterate through the string
        for(int i=0; i<=n; i++){
            char c;
            if(i<n){
                c = s.charAt(i); 
            }else{
                c = '&';
            }
            
            if(Character.isDigit(c)){ //System.out.print("num before " + num + " "); //int res = c; System.out.print("res " + res + " ");
                num = num*10 + Character.getNumericValue(c); //System.out.println("num " + num);
                lastSign = lastSign; //do we need to do this? check in the end
                
            }else{
                //end of the string thing over here
                
                //otherwise
                if(lastSign != '*' && lastSign != '/' && c != ' '){
                    if(lastSign == '+'){
                        st.push(num); 
                        num = 0;
                        if(c != '&')
                            lastSign = c;
                    }else{
                        st.push(-num);
                        num = 0;
                         if(c != '&')
                            lastSign = c;
                    }
                }else if( (lastSign == '*' || lastSign == '/') && c != ' '){
                    if(lastSign == '*'){
                        num = num*st.pop();
                        st.push(num);
                        num = 0;
                         if(c != '&')
                            lastSign = c;
                        
                    }else if(lastSign == '/'){
                        num = st.pop()/num;
                        st.push(num);
                        num = 0;
                         if(c != '&')
                            lastSign = c;
                    }
                }
            }
        }
        
        
        int result = 0; 
        while(!st.isEmpty()){
            int nm = st.pop(); //System.out.println("nm " + nm);
            result += nm;
        }

        
        //if we encounter a digit, update num to 10*num + num and last Sign to whatever lastSign is
        
        //if we encounter an operator or the end of the string,
        //one case (when lastSign is not * or /), then 1) if lastSign is +, push +num to the stack else -num to stack 2) Update num to 0 3) Update lastSign to whatever the encountered operator is
        
        //second case (when lastSign is * or /), then 1) pop the stack 2) operate on the popped element and num as per lastSign 3) push the result to the stack 4) update num to 0 5) update lastSign to whatever the operator encountered was or nothing if it was the end of the string
        return result;
    }
}
*/
