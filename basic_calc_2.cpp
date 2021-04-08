//TC: O(n)
//SC: O(n) where n is the length of the string

class Solution {
public:
    int calculate(string s) {
        
        stack<int> stack;
        
        //initialize the number to 0, since we add 0 to the stack in the beginning
        int num=0; 
        char sign = '+';
        
        int i = 0;
        
        //increment i until we reach the end of the string
        while(i < s.size()){
            //extract each character
            char ch = s[i];
            //if this is isdigit
            if(isdigit(ch)){
                num = num*10 + (ch-'0');    
            }
            
            //check if the character is not a space and if it is not a digit or if it is the last character in the string
            if(ch!=' ' && !isdigit(ch) || (i == s.size()-1)){
                
                //initially our sign is "+", so our first num will be added to 0 and then added back to the stack. This is done so that we first process the number after any sign and then process the operation.
                
                if(sign == '+'){
                    //if the sign  is + or -, push the number on to the stack
                    stack.push(num);
                } else if(sign == '-'){
                    // if the sign is -, push the negative inverse of the number on to the stack
                    stack.push(num*-1);
                } else if(sign == '*'){
                    //if sign is * then get the top of the stack and process the current num. We perform this operation and then  
                    int temp = stack.top();
                    stack.pop();
                    stack.push(temp*num);
                } else if(sign == '/'){
                    int temp = stack.top();
                    stack.pop();
                    stack.push(temp/num);
                }
                
                //num is re-initialized
                num = 0;
                //we assign sign here so that we first process the number following the sign and then assign the sign the next time we encounter a non number of when we reach the end of the array
                sign = ch;
            }
            
            i++;
        }
        
        int result = 0;
        //sum up all the elements in the stack
        while(!stack.empty()){
            result += stack.top();
            stack.pop();
        }
        
        return result;
    }
};