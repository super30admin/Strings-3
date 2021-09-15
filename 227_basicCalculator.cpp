// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    int calculate(string s) {
        if(s.empty() || s.length() == 0)
            return 0;
        int num = 0;
        char lastSign = '+';
        int result = 0;
        stack<int> st;
        for(int i=0; i<s.length(); i++){
            char c = s[i];
            if(isdigit(c))
                num = num * 10 + (c - '0');
            if((!isdigit(c) && c != ' ') || (i == s.length()-1)){
                if(lastSign == '+')
                    st.push(num);
                else if(lastSign == '-')
                    st.push(-num);
                else if(lastSign == '*'){
                    int val = st.top();
                    st.pop();
                    st.push(val*num);
                }
                else{
                    int val = st.top();
                    st.pop();
                    st.push(val/num);
                }
                lastSign = c;
                num = 0;
            }
        }
        while(!st.empty()){
            int val = st.top();
            st.pop();
            result += val;
        }
        return result;
    }
};



// Time Complexity : O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int calculate(string s) {
        if(s.empty() || s.length() == 0)
            return 0;
        int num = 0;
        char lastSign = '+';
        int calc=0, tail=0;
        for(int i=0; i<s.length(); i++){
            char c = s[i];
            if(isdigit(c))
                num = num * 10 + (c - '0');
            if((!isdigit(c) && c != ' ') || (i == s.length()-1)){
                if(lastSign == '+'){
                    calc = calc+num;
                    tail = num;
                }
                else if(lastSign == '-'){
                    calc = calc-num;
                    tail = -num;
                }
                else if(lastSign == '*'){
                    calc = (calc - tail) + (tail * num);
                    tail = tail * num;
                }
                else{
                    calc = (calc - tail) + (tail / num);
                    tail = tail/num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc;
    }
};
