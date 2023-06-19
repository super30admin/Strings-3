// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach\
//      calc                    tail
// + => calc+curr               +curr
// - => calc - curr             -curr 
// * => calc-tail+tail*curr     tail*curr 
// - => calc-tail+tail/curr     tail/curr 
// using the above calculations, we can maintain the operator precedence . and proceed


class Solution {
public:
    int calculate(string s) {
        int n = s.size();
        char lastsign = '+';
        long long curr = 0,tail=0,calc=0;
        for(int i = 0;i<n;i++)
        {
            if(isdigit(s[i])){
                curr = curr*10 + s[i] - '0';
            }
            if((!isdigit(s[i]) && s[i]!=' ') || (i == n-1))
            {
                if(lastsign=='+'){
                    calc = calc + curr;
                    tail = +curr;
                }
                else if(lastsign=='-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastsign == '*'){
                    calc = calc - tail + tail*curr;
                    tail = tail * curr;
                }
                else{
                    calc = calc - tail + (tail/curr);
                    tail = tail/curr;
                }
                lastsign = s[i];
                curr = 0;
            }
        }
        return calc;
    }
};