class Solution {
    public int calculate(String s) {
        if(s ==null || s.length() == 0){
            return 0;
        }
        
        //Logic
        int num = 0;
        int result = 0;
        char sign = '+';
        //Stack to keep track of num calculated so far
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num *10 + c - '0';
            }
            if((!Character.isDigit(c) && c!= ' ' ) || (i== s.length() - 1)){
              if(sign == '+'){
                  st.push(num);
              }
              else if(sign == '-'){
                  st.push(-num);
              }  
              else if(sign == '*'){
                  st.push(st.pop()*num);
              }
              else{
                  st.push(st.pop()/num);
               }
                sign = c;
                num = 0;
            }  
        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}
