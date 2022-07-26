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

// Time COmplexity -> O(n)
// Space Complexity -> O(1)
// Problems Faced - It did not work if I took 'num' as 'int'. So I changed it to 'long'.
// It runs on Leetcode!
class Solution {
public:
    int calculate(string s) {
        char lastSign = '+';
        long calc = 0;
        long tail = 0;
        long num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s[i];
            if(isdigit(c)){
                num = num*10 + c - '0';
            }
            
            if((!isdigit(c) && c != ' ') || i == s.length() - 1){
                if(lastSign == '+'){
                    calc = calc + num;
                    tail = num;
                }
                else if(lastSign == '-'){
                    calc = calc - num;
                    tail = -num;
                }
                else if(lastSign == '*'){
                    calc = calc - tail + num*tail;
                    tail = num*tail;
                }
                else if(lastSign == '/'){
                    calc = calc - tail + tail/num;
                    tail = tail/num;
                }
                num = 0;
                lastSign = c;
            }
        }
        return calc;
    }
};