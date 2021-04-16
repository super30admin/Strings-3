// Time O(n)
//Space O(n)
class Solution {
    public int calculate(String s) {
        if(s.length() == 0) return 0;
        int i=0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while(i < s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                    num =  num * 10 + (ch - '0');
                    //System.out.println(num);
            }
//            else{
            if((!Character.isDigit(ch)  && ch != ' ') || i == s.length()-1){
                if(sign == '+') {
                    stack.push(+num);
                }
                 if(sign == '-') {
                    stack.push(-num);
                }
                 if(sign== '*' || sign == '/' ){
                    int popped = Integer.valueOf(stack.pop());

                    int res = process(popped,sign,num);
                    stack.push(res);
                }
                num = 0;
                sign = ch;

            }
            i++;
            //System.out.println(stack);
        }
        int out = 0;
        while(!stack.isEmpty()){

             out += stack.pop();
        }

        return out;
    }
    public int process(int op1,char op, int op2){
        if(op == '*'){
            return op1 * op2;
        }
        else if(op == '/'){
            return op1/op2;
        }
        return 0;
    }
}
