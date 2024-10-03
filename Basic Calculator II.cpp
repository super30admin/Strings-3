//time: O(n) space: O(1)
class Solution {
public:
    int calculate(string s) {
        int calc = 0;
        int tail = 0;
        char exp = '+';
        for(int i = 0; i < s.length(); i++) {
            if(s[i] >= '0' && s[i] <= '9') {
                int curr = 0;
                while(i < s.length() && s[i] >= '0' && s[i] <= '9') {
                    curr = curr*10 + (s[i] - '0');
                    i++;
                }
                i--;

                if(exp == '+') {
                    calc = calc+curr;
                    tail = +curr;
                }
                else if(exp == '-') {
                    calc = calc-curr;
                    tail = -curr;
                }
                else if(exp == '*') {
                    calc = calc-tail+tail*curr;
                    tail = tail*curr;
                }
                else if(exp == '/') {
                    calc = calc-tail+tail/curr;
                    tail = tail/curr;
                }
            }
            else if(s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
                exp = s[i];
            }
        }
        return calc;
    }
};