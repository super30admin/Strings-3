// Time Complexity : O(n)  
// Space Complexity : O(n)  
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Maintain char lastSign, long num=0 and a stack to store numbers. Preprocess to remove trailing spaces
// 2. Iterate through string. If char is digit, multiply num by 10 and add char value.
// 3. When we encounter an operator, we add the number formed so far along with last sign to stack (for * and / pop last el and multiply/divide then add)
// 4. Finally gp thru stack and add all elements. Long num is required for INT_MAX or INT_MIN as input

class Solution {
public:
    int calculate(string s) {
        char lastSign='+';
        stack<int> st; long num=0;
        char c = s.back();
        while(isspace(c)){
            s.pop_back();
            c = s.back();
        }
        for(auto c: s)
            cout<<c;
        for(int i=0; i<s.size(); i++){
            char c = s[i];
            if(isdigit(c))
                num = num*10 + c-'0';
            if(!isspace(c)){
                if(!isdigit(c) || i==s.size()-1){
                    if(lastSign == '+')
                        st.push(num);
                    else if(lastSign == '-')
                        st.push(-num);
                    else if(lastSign == '*'){
                        int temp=st.top(); st.pop();
                        st.push(temp*num);
                    }
                    else if(lastSign == '/'){
                        int temp=st.top(); st.pop();
                        st.push(temp/num);
                    }
                    lastSign = c;
                    num=0;
                }
            }
        }
        int res = 0;
        while(!st.empty()){
            res+=st.top();
            st.pop();
        }
        return res;
    }
};