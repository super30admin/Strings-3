//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public int calculate(String s) {
        //null case
        if(s == null)
            return 0; 
        s =s.trim();
        if(s.length() == 0)
            return 0;
        char lastSign = '+';
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr *10 + c -'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                //space inbetween expression

                if(lastSign == '+'){
                    st.push(curr);
                }
                else if(lastSign == '-'){
                    st.push(-curr);
                }else if(lastSign == '*'){
                    st.push(st.pop()*curr);
                }
                else{
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastSign = c;
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}

//Solution: Expression Add Operator Method, here mulitple and deivision already took precendence

class Solution {
    public int calculate(String s) {
        //null case
        if(s == null)
            return 0; 
        s =s.trim();
        if(s.length() == 0)
            return 0;
        char lastSign = '+';
        int curr = 0;
        int calc = 0;
        int tail = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr *10 + c -'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                //space inbetween expression

                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }else if(lastSign == '*'){
                    calc = calc - tail + (tail * curr);
                    tail = tail*curr;
                }
                else{
                    calc = calc - tail + (tail / curr);
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = c;
            }
        }
        return calc;
    }
}

