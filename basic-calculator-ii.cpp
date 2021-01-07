//Time - O(len(s))
//Space - O(1)

class Solution {
public:
    int calculate(string s) {
        int currVal = 0, prevVal = -1;
        int sign = '+';
        int total = 0;
        
        for(int i=0;i<s.length();i++){
            char currChar = s[i];
            if(isdigit(currChar)){
                currVal = currVal*10 + (currChar-'0');
            }
            
            if((!isdigit(currChar) && currChar!=' ') || i == s.length()-1){
               if(sign == '+'){
                   total = total + currVal;
                   prevVal = currVal;
                   currVal = 0;
               }else if(sign == '-'){
                   total = total - currVal;
                   prevVal = -currVal;
                   currVal = 0;
               }else if(sign == '*'){
                   total = total - prevVal;
                   total = total + currVal*prevVal;
                   prevVal = currVal*prevVal;currVal = 0;
               }else if(sign == '/'){
                   total = total - prevVal;
                   total = total + prevVal/currVal;
                   prevVal = prevVal/currVal;currVal = 0;
               }
                sign = currChar;
            }
        }
        
        return total;
    }
};