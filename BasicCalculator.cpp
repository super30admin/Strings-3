// Time COmplexity -> O(n)
// Space Complexity -> O(n)
// Problems Faced - It did not work if I took 'num' as 'int'. So I changed it to 'long'.
// It runs on Leetcode!

class Solution {
public:
    int calculate(string s) {
        stack<long> st;
        char lastSign = '+';
        long num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            
            if(isdigit(c))
                num = num * 10 + c - '0';
            
            if((!isdigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+')
                    st.push(num);
                     
                else if(lastSign == '-')
                    st.push(-num);
                else if(lastSign == '*'){
                    long curr = st.top(); st.pop();
                    st.push(curr*num);
                }
                else if(lastSign == '/'){
                    long curr = st.top(); st.pop();
                    st.push(curr/num);
                }
                lastSign = c;
                num = 0;
            }
        }
        long answer = 0;
        while(!st.empty()){
            answer += st.top();
            st.pop();
        }
        return answer;
    }
};