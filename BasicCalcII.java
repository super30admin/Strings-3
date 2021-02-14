// Time Complexity : O(n) n = length of str
// Space Complexity : O(N/2) for stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Add nums to stack
//Process if * or /
//Note that * & /  are treated at same level

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;

        Stack<Integer> intStack = new Stack<Integer>();

        int curNum = 0;
        Character curOp = '+';

        for(int i = 0; i < s.length(); i++) {

            Character c = s.charAt(i);
            if(Character.isDigit(c)) {
                curNum = curNum * 10 + Character.getNumericValue(c);

            }
            if((!Character.isDigit(c) &&  c != ' ') || i == s.length()-1){
                if(curOp == '-') {
                    intStack.push(-1 * curNum);
                } else if ( curOp == '+') {
                    intStack.push(curNum);
                } else if ( curOp == '*') {
                    int digit1 = intStack.pop();
                    int val = digit1 * curNum;
                    intStack.push(val);
                } else {
                    int digit1 = intStack.pop();
                    int val = digit1 / curNum;
                    intStack.push(val);
                }

                curOp = c;
                curNum = 0;
            }

        }

        curNum = 0;
        while(!intStack.isEmpty()) {
            curNum += intStack.pop();
        }

        return curNum;
    }
}
