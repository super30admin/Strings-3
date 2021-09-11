/*
Time Complexity = O(N)
Space Complexity = O(N)
where n is the size of the given string.
*/
class Solution {
public:
    int calculate(string str) {
        if(str.length()==0)
            return 0;
        stack<int> s;
        int result=0;
        int num=0,i;
        char lastsign='+';
        for(i=0;i<str.length();i++){
            if(isdigit(str[i]))
                num=(num*10)+(str[i]-'0');
            if((!isdigit(str[i]) && str[i]!=' ') || i==str.length()-1)
            {
                if(lastsign=='+')
                    s.push(num);
                else if(lastsign=='-')
                    s.push(-1*num);
                else if(lastsign=='*'){
                    int x = s.top()*num;
                    s.pop();
                    s.push(x);
                }
                else{
                    if(num!=0 ) {int x = s.top()/num;
                    s.pop();
                    s.push(x);}
                }
                lastsign = str[i];
                num=0;
            }
        }
        while(!s.empty()){
            result+=s.top();
            s.pop();
        }
        return result;
    }
};


/*
Time Complexity = O(N)
Space Complexity = O(1)
where n is the size of the given string.
*/
class Solution {
public:
    int calculate(string str) {
        if(str.length()==0)
            return 0;
        int calc=0,i,tail=0,num=0;
        char lastsign='+';
        for(i=0;i<str.length();i++){
            if(isdigit(str[i]))
                num=(num*10)+(str[i]-'0');
            if((!isdigit(str[i]) && str[i]!=' ') || i==str.length()-1)
            {
                if(lastsign=='+'){
                    calc = calc+num;
                    tail = num;
                }
                else if(lastsign=='-'){
                    calc = calc-num;
                    tail = -1*num;
                }
                else if(lastsign=='*'){
                    calc = calc-tail +tail*num;
                    tail = tail*num;
                }
                else{
                    calc = calc-tail +tail/num;
                    tail = tail/num;
                }
                lastsign = str[i];
                num=0;
            }
        }
        return calc;
    }
};
