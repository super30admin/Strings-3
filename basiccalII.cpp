
#include<iostream>
using namespace std;

class Solution {
public:
    int calculate(string s) {
        
        char lastsing = '+' ;
        int cal = 0;
        int curr = 0;
        int tail = 0;
        int n = s.size();

        for(int i = 0 ;i<s.length();i++)
        {
            char c = s[i];
            if(c>='0' && c<='9'){
                curr = curr*10 + (c-'0');
            }

            if((c<'0' || c>'9') && c!=' ' ||  i== (n-1) ){
                if(lastsing == '+'){
                    cal = cal + curr;
                    tail = curr;
                }else if(lastsing == '-'){
                    cal = cal - curr;
                    tail = -1*curr;
                }else if(lastsing == '*'){
                    cal = cal-tail + (tail*curr);
                    tail = (tail*curr);
                }else {
                    cal = cal-tail + (tail/curr);
                    tail = (tail/curr);
                }

                curr = 0;
                lastsing = c;
            }

        }


        return cal;


        
    }
};