// https://leetcode.com/problems/basic-calculator-ii/description/
// Time Complexity : O(n) where n is the length of the string 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public:
        int calculate(string s) {
            int curr = 0; char sign = '+'; int cal = 0; int tail = 0;
            for(int i=0; i<s.length(); i++){
                if(isdigit(s[i])){
                    curr = curr*10 + (s[i] - '0');
                }
                if((!isdigit(s[i]) && s[i] != ' ') || i == s.length() - 1){
                    if(sign == '+'){
                        cal += curr;
                        tail = curr;
                    }
                    else if(sign  == '-'){
                        cal -= curr;
                        tail = -curr;
                    }
                    else if(sign  == '*'){
                        cal = cal-tail + tail*curr;
                        tail = tail*curr;
                    }
                    else if(sign == '/'){
                        cal = cal - tail + tail/curr;
                        tail = tail/curr;
                    }
                    curr = 0;
                    sign = s[i];
                }
            }
            return cal;
        }
    };