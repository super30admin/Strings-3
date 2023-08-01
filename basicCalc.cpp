class Solution {
public:
    int calculate(string s) {
        deque<int> st; 
        char lastExp;
        int result = 0; 
        int currNum = 0;

        for(int i = 0; i <= s.size(); i++) {
            if(s[i] == ' ') continue; 
            if(i != s.size() && isdigit(s[i])) {
                currNum = currNum * 10 + (s[i] - '0');
            } else {
                int prevNum; 
                switch(lastExp) {
                    case '+' : 
                        st.push_back(currNum);
                        break; 
                    case '-':
                        st.push_back(currNum * -1);
                        break;
                    case '*':
                        prevNum = st.back(); 
                        st.pop_back(); 
                        st.push_back(prevNum*currNum);
                        break; 
                    case '/':
                        prevNum = st.back(); 
                        st.pop_back(); 
                        st.push_back(prevNum/currNum);
                        break; 
                    default: 
                        st.push_back(currNum);
                        break; 
                }
                lastExp = s[i];
                currNum = 0; 
            }
        }

        while(!st.empty()) {
            result += st.back(); 
            st.pop_back(); 
        }         

        return result; 
    }
};