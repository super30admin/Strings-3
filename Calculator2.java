import java.util.Stack;

public class Calculator2 {
    public int calculate(String s){
        s.trim();
        int n=s.length();
        //create a stack of integer type
        Stack<Integer> st = new Stack<>();
        int lastSign='+';
        int currNum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                currNum=currNum*10(ch-'0');
            }
            if((!Character.isDigit(ch)&&ch!=' ')|| i==s.length()-1){
                if(lastSign=='+'){
                    st.push(currNum);
                }else if(lastSign=='-'){
                    st.push(-currNum);
                }else if(lastSign=='/'){
                    st.push(st.pop()/currNum);
                }else if(lastSign=='*'){
                    st.push(st.pop()*currNum);
                }
                currNum=0;
                lastSign=ch;
            }
        }
        int result=0;
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}

//TC: O(N)
//SC: O(N)