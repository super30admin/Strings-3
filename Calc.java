class Solution {
    public int calculate(String s) {
         StringBuilder sb= new StringBuilder();
        int p1=0;
        while(p1<s.length()){
            if(s.charAt(p1)!=' '){
                sb.append(s.charAt(p1));
            }
        p1++;}
        
        s=sb.toString();
        Stack<Integer> st = new Stack<>();
        Stack<Character> stt= new Stack<>();
        
        int p=0;
        while(p<s.length()){
            
            char c=s.charAt(p);
            if(Character.isDigit(c)){
              int num=0;
                
            while(p<s.length()&&Character.isDigit(s.charAt(p))){
                num=num*10+Character.getNumericValue(s.charAt(p));
                p++;     
            }st.add(num);
              p--; }else if(c!=' '){
                if(c=='+'){
                    stt.add(c);
                    
                }else if(c=='-'){
                int num=0;
                    //calculate next num
                    
                    p++;
                    while(p<s.length()&&Character.isDigit(s.charAt(p))){
                num=num*10+Character.getNumericValue(s.charAt(p));
                p++;     
            }
              p--;
                    
                    st.add(num*(-1));
                    stt.add('+');
                
                }else{
                    
                    int num=0;
                    //calculate next num
                    
                    p++;
                    while(p<s.length()&&Character.isDigit(s.charAt(p))){
                num=num*10+Character.getNumericValue(s.charAt(p));
                p++;     
            }
              p--;
                    
                    
                    if(c=='/'){
                       // System.out.println(st.peek());
                        num=st.pop()/num;
                   //    System.out.println(p+" "+num); 
                      st.push(num);
                    }else{
                      num=num*st.pop();
                      st.push(num);  
                        
                    }
                    
                    
                }
                
                
            }
            
         p++;       
        }
        
        //System.out.println(st);
        //System.out.println(stt);
        
        while(!stt.isEmpty()){
            char op=stt.pop();
            int one=st.pop();
            int two=st.pop();
            if(op=='-'){
                
                st.add(two-one);
            }else{
                
                st.add(two+one);
                
            }
            
            
            
        }
        return st.peek();
        
    }
}
