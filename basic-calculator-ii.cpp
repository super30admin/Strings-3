// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <string>
#include <stack>

class BasicCalculatorII {
public:
    int calculate(std::string s) {
        std::stack<int> stack;
        int i = 0;
        char sign = '+';
        int temp = 0;

        while (i < s.length()) {
            char c = s[i];

            if (std::isdigit(c)) {
                temp = temp * 10 + (c - '0');
            }

            if ((!std::isdigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(+temp);
                } else if (sign == '-') {
                    stack.push(-temp);
                } else if (sign == '*' || sign == '/') {
                    int p = stack.top();
                    stack.pop();

                    if (sign == '*') {
                        stack.push(p * temp);
                    } else {
                        stack.push(p / temp);
                    }
                }

                temp = 0;
                sign = c;
            }

            i++;
        }

        int ans = 0;

        while (!stack.empty()) {
            ans += stack.top();
            stack.pop();
        }

        return ans;
    }
};