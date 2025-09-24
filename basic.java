class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Stack<Integer>st=new Stack<>();
        int num=0;
        char last='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || (i==s.length()-1)){
                if(last=='+'){
                    st.push(num);
                }
                else if(last=='-'){
                    st.push(-num);
                }
                else if(last=='*'){
                    st.push(st.pop()*num);
                }
                else if(last=='/'){
                    st.push(st.pop()/num);
                }
                num=0;
                last=c;
            }
        }
        int res=0;
        while(!st.isEmpty()){
            res+=st.pop();
        }
        return res;
        
    }
