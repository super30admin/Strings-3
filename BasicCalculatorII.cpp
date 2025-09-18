#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We go through the expression using a shared idx, building numbers and evaluating recursively when we hit '('.
Every time we hit an operator or ')', we apply the last operator using tail to maintain correct precedence. If we hit ')', we return the value of the inner expression immediately to the outer level.
It handles precedence and parentheses, covering Basic Calculator (I) and Basic Calculator III logic together.
*/
class Solution{
    int idx = 0;
public:
    int calculate(string s) {
        int currNum = 0;
        char lastSign = '+';
        int calc = 0, tail = 0;

        while(idx < s.length()){
            char c = s[idx++];

            if(isdigit(c)){
                currNum = currNum*10  + (c - '0');
            }else if(c == '(') currNum = calculate(s);

            if((!isdigit(c) && c != ' ')|| idx == s.length() || c == ')'){
                if(lastSign == '+'){
                    calc += currNum;
                    tail = currNum;
                }
                else if(lastSign == '-'){
                    calc -= currNum;
                    tail = -currNum;
                }
                else if(lastSign == '*'){
                    calc = (calc - tail) + (tail * currNum);
                    tail = tail * currNum;
                }else if(lastSign == '/'){
                    calc = (calc - tail) + (tail/currNum);
                    tail = tail/currNum;
                }
                currNum = 0;
                lastSign = c;

                if(c == ')') return calc;
            }
        }
        return calc;
    }
};
