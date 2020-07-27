// Time Complexity : O(n)
// Space Complexity : O(n) // stack space to save the integers
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//1. Add the numbers wrt '+' and '-' sign previously.
//2. If a multiplication sign is encountered pop the elements perform the operation because of BODMAS rule
//3. After the stack is formed with relevant initial sign, add all the elements of the stack
class Solution {
public:
    int calculate(string s) {
        //edge
        if(s.length()==0) return 0;
        
        //logic
        int tail=0; char prev_operation='+';
        long num=0; 
        stack<int> n;
        for(int i=0; i<s.length();i++){
            if(isdigit(s[i])) {
                num = num*10 + s[i] - '0';
            }
            if((!isdigit(s[i]) && s[i]!=' ') || i==s.length()-1){
                 if(prev_operation == '-' || prev_operation == '+') { 
                    num = (prev_operation == '+')? num : -num; 
                    n.push(num); 
                }else if(prev_operation == '*') { 
                     int n2 = n.top(); n.pop();
                     n.push(n2 * num); 
                }else if(prev_operation == '/') { 
                     int n2 = n.top(); n.pop();
                     n.push(n2/num); 
                }
                num=0;
                prev_operation = s[i];  
            }

        }

        int result=0;
        while(!n.empty()){
            int n2 = n.top(); n.pop();
            result=result+n2;
        }
        
        return result;
    }
};
