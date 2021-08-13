class Solution {
    public int calculate(String s) {
     
        //time- O(N)
        //space- O(N)
        //process- stack
        //last sign(record)
        //last sign is+  push +num in stack
        //last sign- push -num in stack
        // if * or / then proces
        int res=0;
       Stack<Integer> st= new Stack<>();
        String str=s.replace(" ", "");
        str+='+';
        
        int i=0;
        char symbol='<';
        int num=0;
        while(i<str.length()){
            
            char c= str.charAt(i);
            if(Character.isDigit(c)){
                num= num*10+ c-'0';
                i++;
                continue;
            }
            
            if(symbol=='+'){
                st.push(num);
            }
            
            else if(symbol== '-'){
                st.push(num*-1);
        
            }
            else if(symbol=='*'){
                st.push(st.pop()*num);
               
            }
            else if(symbol=='/'){
                st.push(st.pop()/num);
               
            }
            else st.push(num);
            
            
            num=0;
            symbol=c;
            i++;
            
        }
        
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
        
    }
}