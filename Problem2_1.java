//Time Complexity: O(n)
//Space Complexity: O(n)
//Code run successfully on LeetCode.

public class Problem2_1 {

    public int calculate(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> st = new Stack<>();
        int calc = 0, num = 0;
        char lastSign = '+';
        
        for(int i =0; i < s.length(); i++){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c - '0';
            }
            
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1)
            {
                
                if(lastSign == '+'){
                    st.push(num);
                }
                else if(lastSign == '-')
                {
                    st.push(-num);
                }
                else if(lastSign == '*'){
                    st.push(st.pop() * num);
                }
                else{
                    st.push(st.pop() / num);
                }
                
                num = 0;
                lastSign = c;
            }
        }
        
        while(!st.isEmpty()){
            
            calc = calc + st.pop();
        }
        
        return calc;
    }
}
