class Solution {
    public int calculate(String s) {
        Stack<Long> nums = new Stack<>();


        int index = 0;
        long current = 0;
        char c;
        long next;
        boolean operator = false;
        int digit;
        while(index < s.length()){
            c = s.charAt(index);
            if(c=='+'||c=='-'||c=='*'||c=='/')
                if(operator){
                    current *= -1;
                    operator = false;
                }
            if(c=='+'){
                nums.push(current);
                current = 0;
            }
            else if(c=='-'){
                nums.push(current);
                current = 0;
                operator = true;
            }
            else if(Character.isDigit(c)){
                digit = (c-'0');
                current = current*10 + digit;
            }
            else if(c=='*' || c=='/'){
                index++;
                next = 0;
                char c1;
                while(index < s.length() ){
                    c1 = s.charAt(index++);
                    if(Character.isDigit(c1))
                        next = next * 10 + c1 - '0';
                    if(c1=='+' || c1=='-' || c1=='*' || c1 == '/'){
                        index--;
                        break;
                    }

                }
                current = c=='*'?current*next:current/next;
                continue;
            }
            index++;
        }
        if(operator){
            current *= -1;
            operator = false;
        }
        char op;
        long num;
        while(!nums.isEmpty()){
            num = nums.pop();
            current += num;
        }
        return (int)current;
    }
}