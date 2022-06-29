// Time Complexity : O(1) n no.of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
traverse through the whole expression and used tail to add to the current calculation for every sub expression

class Solution {
    public int calculate(String s) {
        //Stack<Integer>st = new Stack<>();
        int curnum = 0;
        char lastsign = '+';
        int calc =0;
        int tail = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curnum = curnum*10 + (c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastsign == '+'){
                    calc = calc + curnum;
                    tail = curnum;
                }
                else if(lastsign == '-'){
                    calc = calc - curnum;
                    tail = -curnum;
                }
                else if(lastsign == '*'){
                    calc = calc - tail + (tail*curnum);
                    tail = tail*curnum;
                }
                else if(lastsign == '/'){
                    calc = calc - tail + (tail/curnum);
                    tail = tail/curnum;
                }
                curnum=0;
                lastsign=c;
            }
        }
        return calc;
    }
}