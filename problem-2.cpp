// t-c: n
// s-c: 1
class Solution {
public:
    int calculate(string s) {
        long long currnum = 0, tail = 0, result = 0;
        char lastsign = '+';
        for(int i = 0; i < s.size(); i++)
        {
            if(s[i] >= '0' && s[i] <= '9')
            {
               currnum = (currnum * 10) + (s[i] - '0');
            }
            if(s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/' || i==s.size()-1)
            {
                if(lastsign == '+')
                {
                    result += currnum;
                    tail = currnum;
                }
                else if(lastsign =='-')
                {
                    result -= currnum;
                    tail = -currnum;
                }
                else if(lastsign == '*')
                {
                    result = (result - tail) + (tail * currnum);
                    tail = tail*currnum;
                }
                else if(lastsign == '/')
                {
                    result = (result - tail) + (tail / currnum);
                    tail = tail/currnum;
                }
                currnum = 0;
                lastsign = s[i];
            }
        }
        return result;
    }
};
