/*
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

if bracket found solve the inside and give it as a number 
find the number and previous operator.
as soon as the next operator is found store the number and the last operator in stack.
once completed all the string
add all the elements stored in the stack

*/

#include<iostream>
#include<vector>
#include<string>
#include<stack>

using namespace std;

// self solution

class Solution {
    vector<int> helper(string& s,int st_idx){
        vector<int> res(2,0);
        stack<int> st;
        int curr_num{0};
        char last_expr{'+'};
        //cout<<"curr_num "<<"last_expr"<<endl;
        int i{st_idx};
        for(;s.at(i)!=')';++i){
            //cout<<curr_num<<" "<<last_expr<<endl;
            char c = s.at(i);
            if((isdigit(c)) || isspace(c) || c == '('){
                if(isdigit(c)) curr_num = curr_num * 10 + (c - '0');
                else if(c == '('){
                    vector<int> arr{0,0};
                    arr = helper(s,i+1);
                    curr_num = arr.at(0);
                    i = arr.at(1);
                }
            }
            else if(last_expr == '+' || last_expr == '-'){
                //cout<<"curr_num "<<curr_num<<endl;
                int mul = (last_expr == '+')?1:-1;
                st.push(mul*curr_num);
                last_expr = s.at(i);
                curr_num = 0; 
            }
        }
        int mul = (last_expr == '+')?1:-1;
        st.push(mul*curr_num);
        int sum{};
        //cout<<"element inside the stacks "<<endl;
        while(!st.empty()){
            int num = st.top();
            //cout<<num<<" ";
            sum+= num;
            st.pop();
        }
        cout<<endl;
        res.at(0) = sum;
        res.at(1) = i;
        return res;
    }
public:
    int calculate(string s) {
        int curr_num{0};
        char last_expr{'+'};
        int sz = s.size();
        stack<int> st{};
        for(int i{};i<sz;++i){
            char c = s.at(i);
            
            if((isdigit(c)) || isspace(c) || c == '('){
                if(isdigit(c)) curr_num = curr_num * 10 + (c - '0');
                if(c == '('){
                    //cout<<"start_bracket "<<i<<endl;;
                    vector<int> arr{0,0};
                    arr = helper(s,i+1);
                    curr_num = arr.at(0);
                    i = arr.at(1);
                    //cout<<"close_bracket "<<i<<endl;
                    //cout<<"curr_num "<<curr_num<<endl;
                }
            }
            else if(last_expr == '+' || last_expr == '-'){
                int mul = (last_expr == '+')?1:-1;
                st.push(mul*curr_num);
                last_expr = s.at(i);
                curr_num = 0; 
            }
        }
        int mul = (last_expr == '+')?1:-1;
        st.push(mul*curr_num);
        int sum{};
        while(!st.empty()){
            int num = st.top();
            sum+=num;
            st.pop();
        }
        return sum;

    }
};




