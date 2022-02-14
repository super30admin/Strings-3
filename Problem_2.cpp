/**
 * Time complexity:
 * O(n)
 */

/**
 * Space Complexity:
 * O(1)
 */

/**
 * Approach:
 * This problem is similar to expression add operator. The only difference here is that
 * we have division operator too. We are maintaining tail, current and calculated value
 * here. Curr is the value of the current digit, calculated is the value calculated till
 * now and tail is the value which was used to perform operation on the value calculated
 * till that point.
 * 
 * Based on this we have built our entire solution.
 */


class Solution {
public:
    int calculate(string s) {
        if(s.size() == 0) return 0;
        int calc = 0;
        long curr = 0;
        int tail = 0;
        //trim the extra spaces
        s.erase(remove(s.begin(), s.end(), ' '), s.end());
        char lastSign ='+';
        for(int i =0; i<s.size(); i++){
            char c = s[i];
            //if(c == ' ') continue;
             if(isdigit(c)){
                curr = curr * 10 + c -'0';
            }
            if( (!isdigit(c) || i == s.size() -1) && c != ' '){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                } else if(lastSign =='-'){
                    calc = calc - curr;
                    tail = -curr;
                } else if (lastSign == '*'){
                    calc = calc - tail + (tail*curr);
                        tail = tail*curr;
                } else {
                    calc = calc - tail + (tail/curr);
                    tail = tail/curr;
                }
                lastSign = c;
                curr = 0;
            }
        }
        return calc;
    }
            
                           
};