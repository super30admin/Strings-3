/* 
    Time Complexity                              :  O(N) - where N is the size of the string s
    Space Complexity                             :  O(N) - in the worst case. the combined
                                                    size of the 2 stacks
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/basic-calculator-ii/submissions/

class Solution {
public:
    int calculate(string s) {
        
        stack<int> st1;
        stack<char> st2;
        int n = s.size();
        if(n == 1) return stoi(s);
        
        string temp = "";
        for(int i=0;i<n;i++) {
            
            if(s[i] >= '0' and s[i] <= '9') {
                temp += s[i];
            }
            
            if(s[i] == '*' or s[i] == '/' or s[i] == '+' or s[i] == '-' or i == n-1) {
                int t = stoi(temp);
                temp = "";
                
                if(!st2.empty()) {
                    
                    char expr = st2.top();
                    
                    if(expr == '*') {
                        t = st1.top() * t;
                        st1.pop();
                        st2.pop();
                    } else if (expr == '/') {
                        t = st1.top() / t;
                        st1.pop();
                        st2.pop();
                    } else if (expr == '-') {
                        t *= -1;
                        st2.pop();
                    }
                }
                
                st1.push(t);
                if(i != n-1)
                    st2.push(s[i]);
            }
        }
    
        int ans = 0;
        while(!st1.empty()) {
            ans += st1.top();
            st1.pop();
        }
        
        return ans;
    }
};