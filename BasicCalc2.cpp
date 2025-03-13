// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    int calculate(string s) {
        int curr =0, prev = 0, res = 0;
        char op = '+';
        int i =0;
        while(i<s.length()) {
            cout<<i;
            if (isdigit(s[i])){
                while (i<s.length() && isdigit(s[i])) {
                    curr = curr*10 + (s[i] - '0');
                    i++;
                }
                i--;
                // cout<<i;

                if (op == '+' ) {
                res+=curr;
                prev = curr;
                }
                else if (op == '-'){
                    res-=curr;
                    prev = -curr;
                }
                else if (op == '*') {
                    res-=prev;
                    res += prev*curr;
                    prev = curr*prev;
                }
                else{
                    res-=prev;
                    res += prev/curr;
                    prev = prev/curr;
                }
                curr = 0;
            }
             else if (s[i] != ' '){
                op = s[i];
            }
            i++;   
        }
        return res;
    }
};