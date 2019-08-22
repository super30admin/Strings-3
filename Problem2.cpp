//
// Created by shazm on 8/22/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <stack>

using namespace std;

class Solution {
public:
    int calculate(string s) {
        stack<long long> stk;
        long long temp = 0; int retVal = 0;
        char opp = '+';
        for(int x = 0; x<s.size(); x++){
            if(s[x]>='0' && s[x]<='9'){
                temp = temp*10 + s[x]-'0';
            }

            if(!(s[x]>='0' && s[x]<='9') && s[x]!=' ' || x == s.size()-1){
                if(opp == '+'){
                    stk.push(temp);
                }else if(opp == '-'){
                    stk.push(-temp);
                }else if(opp == '*'){
                    long long top = stk.top(); stk.pop();
                    stk.push(top*temp);
                }else if(opp == '/'){
                    long long top = stk.top(); stk.pop();
                    stk.push(top/temp);
                }
                opp = s[x]; temp = 0;
            }
        }

        while(!stk.empty()){
            retVal += stk.top();
            stk.pop();
        }

        return retVal;
    }
};