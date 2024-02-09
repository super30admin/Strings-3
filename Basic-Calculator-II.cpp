// Time Complexity : O(N)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Keeping in mind the precedence of the * and / operator, calculate the calc 
// tail.

// 227. Basic Calculator II

#include<bits/stdc++.h>
using namespace std;

class Solution {
private:
    // Helper function to trim leading and trailing whitespace
    string trim(const string& str) {
        size_t start = str.find_first_not_of(" ");
        size_t end = str.find_last_not_of(" ");
        return (start == string::npos) ? "" : str.substr(start, end - start + 1);
    }
public:
    int calculate(string s) {
        s = trim(s);
        long long tail=0,curr=0,calc=0;
        char lastEx = '+';
        for(int i=0;i<s.length();i++){
            if(isdigit(s[i])){
                curr = curr*10+s[i]-'0';
            }
            if((!isdigit(s[i]) && s[i] != ' ') || i == s.length()-1){
                if(lastEx == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastEx == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastEx == '*'){
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                else{
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                curr = 0;
                lastEx = s[i];
            }
        }
        return calc;
    }
};