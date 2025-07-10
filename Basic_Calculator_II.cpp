#include<iostream>
#include<vector>
#include<stack>
using namespace std;
class Solution {
public:
    int calculate(string s) {
        int ans=0;
        char operation='+';
        stack<int>st;
        for(int i=0;i<s.length();i++)
        {  char ch = s[i];
            if(isdigit(ch))
            {
                ans = ans*10+(ch-'0');
            }
            if((!isdigit(ch) && ch !=' ') || i==s.size()-1)
            {
                if(operation=='+')
                {
                    st.push(ans);
                }
                else if(operation=='-')
                {
                    st.push(-ans);
                }
                else if(operation=='*')
                {
                    int num=st.top()*ans;
                    st.pop();
                    st.push(num);
                }
                else if(operation=='/')
                { 
                        int num=st.top()/ans;
                        st.pop();
                        st.push(num);
                }
                operation=ch;
                ans=0;
            }
        }
        int result=0;
        while(!st.empty())
        {
            result+=st.top();
            st.pop();
        }
        return result;
    }
};