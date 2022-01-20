//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;

class Solution {
public:
    int calculate(string s) {
        int calc=0;
        int curr=0;
        int tail=0;
        char lastSign='+';
        for(int i=0;i<s.size();i++)
        {
            char c=s[i];
            if(isdigit(c))
            {
                curr=curr*10 + (c-'0');
            }
            if((!isdigit(c) && c!=' ') || i==s.size()-1){
                if(lastSign=='+')
                {   
                    calc=calc+curr;
                    tail=curr;
                }
                else if(lastSign=='-')
                {
                    calc=calc-curr;
                    tail=-curr;
                }
                else if(lastSign=='*')
                {
                    calc= calc - tail + tail*curr;
                    tail = tail*curr;
                }
                else
                {
                    calc=calc-tail + tail/curr;
                    tail=tail/curr;
                }
                lastSign=c;
                curr=0;
            }
        }
        return calc;
    }
};