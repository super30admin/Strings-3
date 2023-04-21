// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * Keep an integer for curr and a tail which keeps track of the changes made to the current value at each stage. 
 * If a multiplication or division sign is encountered, return to the earlier value and multiply the previous value before the tail was added with the current element and likewise for division as well. 
 */

class Solution {
    public int calculate(String s) {
        int n = s.length();
        char lastSign = '+';
        int calc = 0; 
        int tail = 0; 
        int curr = 0; 
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + c - '0';
            }
            if(!(Character.isDigit(c) || c == ' ') || i == n-1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr; 
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    calc = calc - tail +(tail * curr);
                    tail = tail * curr;
                }
                else {
                    calc = calc - tail + (tail/curr);
                    tail = tail /curr;
                }
                lastSign = c;
                curr = 0;
         }
        }
        return calc;
    }
}