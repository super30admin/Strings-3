class Solution {
    public int calculate(String s) {
        //base case
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int num = 0;//current number
        char sign = '+';//previous sign 
        int i = 0;
        
        //iterate through the length of the string
        while(i < s.length()){
            char ch = s.charAt(i);
            
            //if the character encountered is a digit then convert it to number
            if(Character.isDigit(ch)){
                num = num *10 + (ch -'0');
                System.out.println(num);
            }
            
            //when you encounter a sign or end of string you need to take care of the number you have
            if(!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){
                //if sign before the number is + or - we push it on to stack with the appropriate sign
                //if the sign is * or / we pop the element perfom the operation and push back on to stack
                if(sign == '+'){
                    System.out.println("pushing on to stack");
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(num * -1);
                }else if(sign == '*' && !stack.isEmpty()){
                    int temp = stack.pop();
                    stack.push(temp * num);
                }else if(sign == '/' && !stack.isEmpty()){
                    int temp = stack.pop();
                    stack.push(temp / num);
                }
                //after performing an operation, update the number to default value and sign to current character, to get appropriate results
                num = 0;
                sign = ch;
            }
            
            i++;
        }
        
        int result = 0;
        
        //every time you pop an element from stack add it to result
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        
        return result;
    }
}
//Time Complexity: O(n)
// Space Complexity: O(n)