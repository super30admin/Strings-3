// Time Complexity: O(n)
// Space Complexity: O(1)
// using variables calc, tail, digit, operator
public class BasicCalculatorII {
    public int calculate(String s) {
        int calc = 0;
        if(s == null || s.length() == 0)
            return calc;
        
        int curr = 0 , tail = 0;
        char lastOp = '+';
        
        for(int i = 0 ; i < s.length() ; i ++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curr = curr * 10 + c -'0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() -1 ) // evaluate last op and no when at the end of string
            {
                if(lastOp == '+')
                {
                    calc += curr;
                    tail = curr;
                }
                else if(lastOp == '-')
                {
                    calc -= curr;
                    tail = -curr;
                }
                else if(lastOp == '*')
                {
                    // calc - tail basically means undo last operation
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                else
                {
                    calc = calc - tail + tail / curr;
                    tail = tail / curr;
                }
                lastOp = c;
                curr = 0;
                
            }
        }
        return calc;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)
// Using Stack
public class BasicCalculatorII {
    // Stack and String
    public int calculate(String s) {
        int cal = 0 ;
        if(s == null || s.length() == 0)
            return cal;
        
        Stack<Integer> st = new Stack<>();
        int no = 0;
        char lastOp = '+';
        // convert string to char array
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
               no = no * 10 + c - '0';
            }
            // this has to be a if condition so that we evalute last digit and operator
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()-1) 
            {
                // check operator
                if(lastOp == '+')
                {
                    st.push(no);
                }
                else if(lastOp == '-')
                {
                    st.push(-no);
                }
                else if(lastOp == '*')
                {
                    st.push(no * st.pop());
                }
                else
                {
                    st.push(st.pop() / no);
                }
                // reset last char and no
                no = 0;
                lastOp = c;
            }
        }
        
        // add all numbers in stack
        while(!st.isEmpty())
        {
            int val = st.pop();
            cal+= val;
        }
        
        return cal;
    }
}