// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// at any point of time we keep a track of tail and calculated to get the result in a single parse and also by giving precendence to * , /
// if we get + , - , we update the calc and tail respectively.
// if we get *, / we need to remove the previosuly processed element from the cal (calc-tail ) and add that to (tail * curr). we need to process the previous elemetn (tail) witht the curr.
class Solution {
    public int calculate(String s) {
        if(s==null) return 0;
        s.trim();
        char lastSign= '+';
        int curr =0;
        int calc =0;
        int tail =0;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curr = curr*10 + (c-'0');
            }
            if((!Character.isDigit(c) && c != ' ') || i == n-1)
            {
                if(lastSign == '+')
                {
                    calc += curr;
                    tail = curr; 
                }
                else if(lastSign == '-')
                {
                    calc -= curr;
                    tail = -curr;
                }
                else if(lastSign == '*')
                {
                    calc = (calc-tail)+ (tail*curr);
                    tail = tail*curr;
                }
                else 
                {
                    calc = (calc-tail)+ (tail/curr);
                    tail = tail/curr;
                }
                curr=0;
                lastSign=c;
            }
            
        }
        return calc;
    }
}