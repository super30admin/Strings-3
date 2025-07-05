class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        int curr = 0;
        char lastsign = '+';
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch-'0');
            }
            if(!Character.isDigit(ch) && ch != ' ' || i==s.length()-1){
                if(lastsign == '+'){
                    stack.push(curr);
                }
                else if(lastsign == '-'){
                    stack.push(-curr);
                }
                else if(lastsign == '*'){
                    stack.push(stack.pop() * curr);
                }
                else if(lastsign == '/'){
                    stack.push(stack.pop() / curr);
                }
                curr = 0;
                lastsign = ch;
            }

        }
        //add all numbers in stack once done with processing string
        int output = 0;
        while(!stack.isEmpty()){
            output+=stack.pop();
        }
        return output;
        
    }
}