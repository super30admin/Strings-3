//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using switch case
//any issues faced? yes, did not understand it, had to look the solution

class Solution {
public:
    int calculate(string s) {
        int length=s.size();
        if(length==0)
            return 0;
        int currentnumber=0, lastnumber=0, result=0;
        char sign='+';
        for(int i=0; i<length; i++)
        {
            char currentchar=s[i];
            if(isdigit(currentchar))
            {
                currentnumber=(currentnumber*10)+(currentchar-'0');
            }
            if(!isdigit(currentchar)&&!iswspace(currentchar)||i==length-1)
            {
                if(sign=='+' || sign=='-')
                {
                    result+=lastnumber;
                    lastnumber=(sign=='+')?currentnumber:-currentnumber;
                }
                else if(sign=='*')
                {
                    lastnumber=lastnumber*currentnumber;
                }
                else if(sign=='/')
                {
                    lastnumber=lastnumber/currentnumber;
                }
                sign=currentchar;
                currentnumber=0;
            }
        }
        result+=lastnumber;
        return result;
    }

};