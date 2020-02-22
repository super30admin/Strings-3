//TC : O(n) where n is the length of string
//SC : O(n) where n is the length of string

class Solution {
    public int calculate(String s) {
        
        if(s.length() == 0 || s == null)
            return 0;
        
        char lastsign='+'; int num=0;
        Stack<Integer> stack = new Stack<>();
        
         for(int i=0; i<s.length() ; i++){
            char c = s.charAt(i);
            
            //Keep pushing the number
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            //Since the i==s.length()-1 is handled, which means even if the last character is 2, 
            //even if 2 is a digit , this condition has to be processed
            //Hence use an if and not an else if
             if(!Character.isDigit(c) && c!= ' ' || i == s.length()-1){
                if(lastsign=='+') stack.push(num);
                if(lastsign=='-') stack.push(-num);
                if(lastsign=='*') stack.push(stack.pop()*num);
                if(lastsign=='/') stack.push(stack.pop()/num);
                num = 0; 
                //Kep track of the last sign
                lastsign = c;
                   
            }
            
        }
        
        int sum = 0;
       
        while(!stack.isEmpty()){
            sum = sum+stack.pop();
        }
        
        return sum;

    }
}