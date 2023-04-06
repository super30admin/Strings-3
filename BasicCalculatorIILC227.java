class Solution {
    
   
    //Time Complexity: O(n), n = length of s
    //Space Complexity: O(1)
    
    public int calculate(String s) {
     
        int result = 0;
        int currNum = 0;
        int tail = 0;
        char lastSign = '+';
        
        for(int i=0; i<s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                currNum = currNum * 10 + c - '0'; 
            }
            
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                
                if (lastSign == '+'){
                    
                    result = result + currNum;
                    tail = currNum;
                }
                else if (lastSign == '-'){
                    
                    result = result - currNum;
                    tail = -currNum;
                }
                else if (lastSign == '*'){
                    
                    result = result - tail + tail * currNum;
                    tail = tail * currNum;
                }
                else if (lastSign == '/'){
                    
                    result = result - tail + tail / currNum;
                    tail = tail / currNum;
                }
                
                currNum = 0;
                lastSign = c;
            }   
        }
        return result;
    }
    
    

    
    
    
    //Time Complexity: O(n), n = length of s
    //Space Complexity: O(n)
    
//     public int calculate(String s) {
        
//         Stack<Integer> stack = new Stack<>();
//         int currNum = 0;
//         char lastSign = '+';
        
//         for(int i=0; i<s.length(); i++){
          
//             char c = s.charAt(i);
            
//             if(Character.isDigit(c)){
                
//                 currNum = currNum * 10 + c -'0';
                
//             }
//             if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                
//                 if (lastSign == '+') stack.push(currNum);
//                 else if (lastSign == '-') stack.push(-currNum);
//                 else if (lastSign == '*') stack.push(stack.pop() * currNum);
//                 else if (lastSign == '/') stack.push(stack.pop() / currNum);
                
//                 currNum = 0;
//                 lastSign = c;
//             }
//         }
        
//         int result = 0;
//         while(!stack.isEmpty()){
//             result += stack.pop();
//         }
//         return result;
//     }
}
