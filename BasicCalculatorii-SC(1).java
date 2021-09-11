

// Time Complexity : o(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BasicCalculatorii {
    public int calculate(String s) {
    if(s == null || s.length() == 0) {
    return 0;
    }
    int num = 0;
    int result = 0;
    char lastSign= '+';
    Stack<Integer> st = new Stack<>();
    for(int i=0; i< s.length(); i++) {
    char c = s.charAt(i);
    if(Character.isDigit(c)){
    num = num * 10 + c- '0';
    }
    if((!Character.isDigit(c) && c!= ' ') || (i == s.length() - 1)){
    if (lastSign == '+') 
    {
    st.push(num);
    }
    else if( lastSign == '-'){
    st.push(-num);
    }
    else if(lastSign == '*') {
    st.push(st.pop() * num );
    }
    else {
    st.push(st.pop() / num );
    }
    lastSign = c ;
    num = 0;
    }
    }
    while( !st.isEmpty()){
    result += st.pop();
    }
    return result ;
    }
    }