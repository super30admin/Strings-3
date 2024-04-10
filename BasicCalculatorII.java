/**
TC, SC - O(n)
 */ 
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack();
        int num =0;
        char opr = '+';
        char ch[] = s.toCharArray();
        for(int i=0;i<ch.length;i++){

            if(Character.isDigit(ch[i])){
                num = num*10+ch[i]-'0';

                
            }
            if(!Character.isDigit(ch[i]) && ch[i]!=' ' || i==ch.length-1){
                if(opr == '+'){
                    st.push(num);
                }
                else if(opr=='-'){
                    st.push(-num);
                }
                else if(opr == '*'){
                st.push(st.pop()*num);
                }
                else{
                  st.push(st.pop()/num);  
                }
                opr = ch[i];
                num =0;
            }

        }
        int res =0;
        while(!st.isEmpty()) res+=st.pop();

        return res;
        
    }
}
