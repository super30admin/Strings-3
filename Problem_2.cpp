// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Basic Calculator II
// Approach: String Parsing with Simulation
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public:
        int calculate(string s) {
            if (s.empty()) {
                return 0;
            }
    
            int calc = 0, tail = 0, num = 0;
            char lastSign = '+';
    
            for (int i = 0; i < s.length(); i++) {
                char c = s[i];
    
                if (isdigit(c)) {
                    num = num * 10 + (c - '0');  
                }
    
                if ((!isdigit(c) && c != ' ') || i == s.length() - 1) {  
                    if (lastSign == '+') {
                        calc += num;
                        tail = num;
                    } else if (lastSign == '-') {
                        calc -= num;
                        tail = -num;
                    } else if (lastSign == '*') {
                        calc = calc - tail + (tail * num);
                        tail *= num;
                    } else if (lastSign == '/') {
                        calc = calc - tail + (tail / num);
                        tail /= num;
                    }
    
                    lastSign = c;  
                    num = 0;
                }
            }
    
            return calc;
        }
    };
    