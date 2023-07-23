/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : First condition of using a stack 
and choosing multiplication for operation. Secondly to handle space into the digits.


// Your code here along with comments explaining your approach
Evaluate if the next character is operator or the last element.
find the number and the expression before it.
if the expression before it is multiplication or division
Take out the last element pushed into the stack and apply the opoerator on the current number and again push it into the stack.
if the operator is add or subtract push it into the stack 
Rest the digit and update the operator 
after performing the operation

Add all the elements inside the stack.
*/


#include<stack>
#include<vector>
#include<string>

using namespace std;

class Solution {
public:
    int calculate(string s) {
        int curr_num{};
        char last_expr{'+'};
        stack<int> st;
        int sz = s.length();
        //cout<<"curr_num"<<" "<<"last_expr"<<endl;
        //cout<<curr_num<<" "<<last_expr<<endl;
        for (int i{};i<sz;++i){
            char c = s.at(i);
            if((isdigit(c) || isspace(c)) && i<(sz-1)){
                if(isdigit(c))   curr_num = curr_num*10 + c -'0';
            }
            else{
                if(i == sz-1){
                    if(isdigit(c)){
                        curr_num = curr_num*10 + (c -'0');
                    }
                }
                if(last_expr == '+' || last_expr == '-'){
                    int mul = (last_expr == '+')?1:-1;
                    st.push(mul*curr_num);
                }
                else if(last_expr == '*' || last_expr == '/'){
                    int mul = st.top();
                    //cout<<"mul "<<mul<<endl;
                    st.pop();
                    if(last_expr == '*'){
                        st.push(mul*curr_num);
                    }
                    if(last_expr == '/'){
                        st.push(mul/curr_num);
                    }
                }
                last_expr = c;
                curr_num = 0;
            }
            //cout<<curr_num<<" "<<last_expr<<endl;   
        }
        int sum{};
        while (!st.empty()){
            int num = st.top();
            sum+=num;
            st.pop();
        }
        return sum; 
    }
};