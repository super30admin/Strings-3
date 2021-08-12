//Time Complexity: O(N)
//Space Complexity: O(N);
class Solution {
    public int calculate(String s) {
        if(s == null | s.length() == 0){
            return 0;
        }
        s = s+"+";
        s = s.replace(" ","");
        int num=0;
        char operator ='+';
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) -'0';
            }else{
                if(operator == '+'){
                    st.push(num);
                }else if(operator == '-'){
                    st.push(-1*num);
                }else if(operator == '*'){
                    st.push(st.pop()*num);
                }else if(operator == '/'){
                    st.push(st.pop()/num);
                }
                operator = s.charAt(i);
                num=0;
            }

        }
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}