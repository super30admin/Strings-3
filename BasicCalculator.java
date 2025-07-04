//Solution: Using stack method 
class Solution {
    public int calculate(String s) {
        s =s.trim();
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        int num =0;
        char lastSign = '+';

        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){

                num = num *10 + c-'0';
            }else if(c == '('){
                if(lastSign == '+'){
                    st.push(1);
                } else if(lastSign == '-'){
                    st.push(-1);
                }else if(lastSign == '*'){ //identifier for * is 2
                    st.push(2);
                }else if(lastSign == '/'){ //identifier for / is -2
                    st.push(-2);
                }
                st.push(Integer.MAX_VALUE); // '('
                num =0;
                lastSign = '+';
            } else if(c == ')'){
                //1. process the number
                if(lastSign == '+'){
                    st.push(num);
                }else{
                    st.push(-num);
                }

                //2. unfold the stack till opening bracket
                int inter =0;
                while(st.peek() != Integer.MAX_VALUE){
                    inter += st.pop();
                }

                st.pop(); //pop Integer.MAX_VALUE
                int popped = st.pop();  //equivalent of sign below '('

                if(popped == 1 || popped == -1){
                    inter = inter * popped;
                }else if(popped == 2){
                    //previous num in stack multiply the curr interresult and put that in stack
                }else{
                    //previous num in stack / the curr interresult and put that in stack
                }
                st.push(inter);

                num =0;
                lastSign = '+';

            }else if((!Character.isDigit(c) && c!= ' ')){
                if(lastSign == '+'){
                    st.push(num);
                }else {
                    st.push(-num);
                }
                
                num =0;
                lastSign = c;
            }
        }

        int calc =0;
        if(s.charAt(n-1) != ')'){ //in this case last character is digit
            if(lastSign == '+'){
                st.push(num);
            }else{
                st.push(-num);
            }
        }

        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}