public class BasicCalculatorII {
    public int calculate(String s) {
        if(s==null || s.length()<0) return 0;
        char lastSign = '+';
        int curr = 0;
        int calc = 0;
        int tail = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10+ch-'0';
            }if( (!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(lastSign=='+'){
                    calc = calc+curr;
                    tail = +curr;
                }else if(lastSign=='-'){
                    calc = calc-curr;
                    tail = -curr;
                }else if(lastSign=='*'){
                    calc = calc - tail + (tail*curr);
                    tail = tail*curr;
                }else{
                        calc = calc - tail + (tail/curr);
                        tail = tail/curr;
                }
                curr = 0;
                lastSign = ch;
            }
        }
        return calc;
    }
}

// TC - O(n)
// SC - O(1)

// stack
public class BasicCalculatorII{
    public int calculate(String s) {
        if(s==null || s.length()<0) return 0;
        char lastSign = '+';
        int curr = 0;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){ 
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10+ch-'0';
            }if( (!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(lastSign=='+'){
                    st.push(curr);
                }else if(lastSign=='-'){
                    st.push(-curr);
                }else if(lastSign=='*'){
                    st.push(st.pop()*curr);
                }else{
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastSign = ch;
            }
        }
        while(!st.isEmpty()){
            result+=st.pop();
        }
        return result;
    }
}

// TC - O(n)
// SC - O(n)