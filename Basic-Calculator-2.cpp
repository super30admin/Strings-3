// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int calculate(string s) {
        if(s==""||s.length()==0){
            return 0;
        }
        stack<int> st;
        long num = 0, answer = 0;
        char lastSign = '+';
        for(int i=0;i<s.length();i++){
            char c = s[i];
            if(isdigit(c)){
                num = num*10+c-'0';
            }
            if((!isdigit(c) && c!=' ')||(i==s.length()-1)){
                if(lastSign=='+'){
                    st.push(num);
                }
                else if(lastSign == '-'){
                    st.push(-num);
                }
                else if(lastSign == '*'){
                    int t = st.top();
                    st.pop();
                    st.push(t*num);
                }
                else if(lastSign == '/'){
                    int t = st.top();
                    st.pop();
                    st.push(t/num);
                }
                num = 0;
                lastSign = c;
            }
        }
        while(!st.empty()){
            answer = answer + st.top();
            st.pop();
        }
        return answer;
    }
};
