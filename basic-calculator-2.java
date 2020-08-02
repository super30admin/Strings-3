	

//Time Complexity : O(n)
//Space Complexity : O(n)
//Did it run on leetcode : yes
class Solution {
    public int calculate(String s) {
        
        int n = s.length();
        
        if(s == null || n == 0)
            return 0;
        
        char lastSign ='+';
        int num = 0 ;
        int result =0 ;
        Stack<Integer> stack = new Stack<>();
        for(int i  = 0 ; i < n;i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
                num = num*10 + (c - '0');
          
            
            
            if(c == '+' || c=='-' || c == '*' || c == '/' || i == n -1 ){
               // System.out.println("here");
                if(lastSign == '+'){
                     stack.push(num);
                }
                else if(lastSign == '-')
                {
                    num  = num *-1;
                    stack.push(num);
                }
                else if(lastSign == '*'){
                    stack.push(stack.pop()*num);
                }
                else{   
                    stack.push(stack.pop()/num);
                    
                }
                lastSign = c;
                num = 0;
                
            }
            
            
            
        }
         
            
        
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        
        return result;
        
    }
}
