// Time: O(N) | Space: O(N) - first we handle all the mulplication, then we go through the stack and sum all values

class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        // currNum maintained for the capturing the current number in the string till operator
        int currNum = 0;
        // every time we encounter a new operator, we update it here
        char lastSign = '+';
        //traversing the entire string
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            // if current character is a digit,
            // we add it to the current number, reason for adding currNum * 10 is to handle if there's more than a digit number between operators
            if(Character.isDigit(c)) {
                currNum = currNum*10+Character.getNumericValue(c);
            }
            // if the current character is a symbol
            // if we are at the last number in the given string
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1) {
                // if the last sign is addition, just pushing to the stack
                // if negative, prepend the currNum with minus
                // if multiplication, pop the last value from the stack, multiply the current value with that,
                // same goes with division as multiplication
                if(lastSign == '+') st.push(currNum);
                else if(lastSign == '-') st.push(-currNum);
                else if(lastSign == '*') {
                    st.push(st.pop()*currNum);
                }
                else st.push(st.pop()/currNum);
                // resetting the currNum and last back, whenever a new symbol is encountered
                lastSign = c;
                currNum = 0;
            }
        }
        // traversing through the stack values, popping them one by one, adding it to our result
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}

// Space optimised solution, Space: O(1)
// tail technique has been used to handle multiplication division first, as of BODMOS rule
class Solution {
    public int calculate(String s) {
        int currNum = 0;
        int calc = 0;
        int tail = 1;
        char lastSign = '+';
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                currNum = currNum*10+Character.getNumericValue(c);
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1) {
                if(lastSign == '+') {
                    calc += currNum;
                    tail = currNum;
                }
                else if(lastSign == '-') {
                    calc -= currNum;
                    tail = -currNum;
                }
                else if(lastSign == '*') {
                    calc = (tail*currNum)+ (calc-tail);
                    tail = (tail*currNum);
                }
                else {
                    calc = (tail/currNum) + (calc-tail);
                    tail = (tail/currNum);
                };
                lastSign = c;
                currNum = 0;
            }
        }
        return calc;
    }
}