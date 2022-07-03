// Time Complexity : O(n) where n : length of i/p string 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Maintain current value, calculated value and tail value to undo the previous operation to compute multiplication and divison.
 * Build a current number until the next operator is found. When next opereator is found, 
 * update the calculated value using previous sign, calculated value, tail value and current value.
 */

class Solution {
public:
    int calculate(string s) {
        if (s.empty())
            return 0;
        
        long current = 0;
        int calculated = 0;
        int tail = 0;
        
        char sign = '+';
        
        for (int i = 0; i < s.size(); i++)
        {
            if (isdigit(s[i]))
            {
                current = current * 10 + s[i] - '0';
            }
            if ((!isdigit(s[i]) && s[i] != ' ' ) || i == (s.size() - 1)) 
            {
                if (sign == '+')
                {
                    calculated += current;
                    tail = current;
                }
                else if (sign == '-')
                {
                    calculated -= current;
                    tail = -current;
                }
                else if (sign == '*')
                {
                    calculated = calculated - tail + current * tail;
                    tail = tail * current;
                }
                else
                {
                    calculated = calculated - tail + tail / current;
                    tail = tail / current;
                }
                
                sign = s[i];
                current = 0;
            }
        }
        
        return calculated;
    }
};