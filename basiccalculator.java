//Time complexity:O(n)
//Space complexity:O(n)

class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int num=0;
        char lastsign='+';
        int n=s.length();
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10 + (c - '0');
            }
            if((!Character.isDigit(c) && c!=' ')|| i==n-1){
                if(lastsign == '+'){
                    st.push(num);
                }
                else if(lastsign=='-'){
                    st.push(-num);
                }
                else if(lastsign=='*'){
                    st.push(st.pop()*num);
                }
                else{
                    st.push(st.pop()/num);
                }
                lastsign=c; 
                num=0;
            }
        }
        int result=0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}