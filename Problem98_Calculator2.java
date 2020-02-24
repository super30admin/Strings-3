//Time Complexity : O(n)
//Space Complexity: O(n)

class Solution {
    public int calculate(String s) {
        //edge
        if(s == null || s.length() == 0)
            return 0;
        
        char lastSign = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        //for every character in the string
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            //if character is a digit
            if(Character.isDigit(c)){
                //calculate num; since num can be double digit too
                num = num * 10 + c - '0';
            }
            //if char is a sign or is the last character of the string
            //character should not be space
            if(!Character.isDigit(c) && c != ' ' || i == s.length()-1){
                //case1: add -> add num to stack
                if(lastSign == '+')
                    st.push(num);
                //case2: sub -> add -num to stack
                if(lastSign == '-')
                    st.push(-num);
                //case3: multiply -> add num after manipulation is done 
                //with popped element and curr num
                if(lastSign == '*')
                    st.push(st.pop() * num);
                //case4: div -> add num after manipulation is done 
                //with popped element and curr num
                if(lastSign == '/')
                    st.push(st.pop() / num);
                //re-initialize num -> 0 and sign -> curr sign
                lastSign = c;
                num = 0;
            }
        }
        int sum = 0;
        //calculate sum of stack contents
        while(!st.isEmpty()){
            sum+= st.pop();
        }
        return sum;
    }
}