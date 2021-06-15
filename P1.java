//time- o(n)

//idea is to keep tack of last operator, 
//when we see a new operator perform last operation with curr number and popped number

class Solution {
    public int calculate(String s) {
        
        s= s.trim();
        Stack<Integer> st = new Stack<>();
        char lastSign = '+';
        int result = 0;
        int num=0;
        for(int i=0 ; i<s.length(); i++){
            
            char c = s.charAt(i);
                        
            //digit
            if(Character.isDigit(c))
            {
                num = num*10 + c-'0';
            }
            
            //operator
            if((c != ' ') && (  !Character.isDigit(c)  || i==s.length()-1))
            {
                if(lastSign == '+') st.push(num);
                else if(lastSign == '-') st.push(-num);
                else if(lastSign == '*') st.push(st.pop()*num);
                else if(lastSign == '/') st.push(st.pop()/num);
                lastSign = c;
                num = 0;
            }
        }
        
        while(!st.isEmpty())
        {
            result += st.pop();
        }
        
        return result;
    }
}