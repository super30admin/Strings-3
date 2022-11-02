//approach- using tail
// when last sign  + ; calc+ num
//when last sign - ; calc + (-num)
//when *; calc = (calc-tail)+ (tail*num);
//when /; calc = (calc-tail)+ (tail/num);
//after  every sign change, sign update to current character and num =0, tail = num, -num, tail*num and tail/num for +, -, / , *!
//tc - O(N), SC - O(1)

class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() ==0)
            return 0;
        
        char lastSign ='+';
        int num =0, calc =0, tail =0;
        s = s.trim();
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(c == ' ') continue;
            if(Character.isDigit(c))
            {
                num = (num*10) + (c -'0'); //c-0 is conversion of ASCII value to Digit
            }
            if(!Character.isDigit(c) || i == s.length()-1) // when last character is digit ! this length check will hop into this part. 
            {
                if(lastSign == '+')
                {
                  calc = calc+ (+num);  
                  tail = +num;
                  
                }
                else if(lastSign == '-')
                {
                    calc = calc+ (-num);
                    tail = -num;
                    
                }
                else if(lastSign == '*')
                {
                    calc = (calc - tail) + (tail*num);
                    tail = tail*num;
                }
                else
                {
                    calc = (calc - tail) + (tail/num);
                    tail = tail/num;
                }
                lastSign =c;
                num=0;
            
            }
        }
        return calc;
    }
}


//approach -2 using stack
//tc -O(N), SC - O(N)

class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() ==0)
            return 0;
        
        char lastSign ='+';
        int num =0, calc =0;
        
        Stack<Integer> stack = new Stack<>();
        
        s = s.trim();
        
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = (num*10) + (c -'0'); //c-0 is conversion of ASCII value to Digit
            }
            
            if((!Character.isDigit(c) && c != ' ' )|| (i == s.length()-1)){
                if(lastSign == '+'){
                    stack.push(num);
                } else if(lastSign == '-') {
                    stack.push(-num);
                } else if(lastSign == '*') {
                    int popped =stack.pop();
                    stack.push(popped*num);
                } else {
                    int popped =stack.pop();
                    stack.push(popped/num);
                }
                num =0;
                lastSign =c;
            }
        }
        while(!stack.isEmpty())
        {
            calc = calc + stack.pop();
        }
        return calc;
    }
}