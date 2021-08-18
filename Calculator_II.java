//Time : O(n)
//space: O(n)
//Did it run successfully on leetcode: yes
class Calculator_II {
    public int calculate(String s) {
        //removing whitespaces from begining and end
        s = s.trim();
        //stack to store integers
        Stack<Integer> st = new Stack<>();
        //variable to store last sign encounter in input string
        Character lastSign = '+';
        //current number encounter in the string
        int num = 0;
        //looping through the input string
        for(int i=0; i<s.length(); i++){
            //getting current character
            Character c = s.charAt(i);
            //if current character is digit
            if(Character.isDigit(c)){
                //conver character to integer
                num = 10*num + Integer.valueOf(c.toString());
            }
            //if current character is not a whitesace and is a sign or is the last character of input string
            if(c!=' '  && (!Character.isDigit(c) || i==s.length()-1)){

                if(lastSign=='+') st.push(num);//just push the current integer to stack
                else if(lastSign=='-') st.push(-num);//just push negative the current integer to stack
                else if(lastSign=='*') st.push(st.pop()*num);//pop() previous integer from stack and multiply with current integer and add to stack
                else if(lastSign=='/') st.push(st.pop()/num);//pop() previous integer from stack and divide with current integer and add to stack
                //update lastSign
                lastSign = c;
                //reinitialize num to zero
                num = 0;
            }
        }
        //variable to store our final answer
        int ans = 0;
        //untill stack is not empty
        while(!st.isEmpty()){
            //add top element in stack to our answer
            ans = ans+st.pop();
        }
        return ans;

    }
}