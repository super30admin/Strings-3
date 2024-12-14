class Solution {
    public int calculate(String s) {
        s = s.trim();// trimmed it up
        int n = s.length();
        char lastSign='+';
        int curr=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i< s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr*10+ (c-'0');
            } else if(c=='(') {
                if(lastSign=='+') {
                    stack.push(+1);
                } else if(lastSign=='-') {
                    stack.push(-1);
                }
                stack.push(Integer.MAX_VALUE);
                curr=0;
                lastSign='+';
            } else if(c==')') {
                if(lastSign=='+') {
                    stack.push(curr);
                } else if(lastSign =='-') {
                    stack.push(-curr);
                }
                // you get ), not unravel it
                int inter =0;
                while(stack.peek()!= Integer.MAX_VALUE) {
                    inter += stack.pop();
                }
                stack.pop(); // pop the +infinity.
                inter = stack.pop()*inter; // for -1 * (inter) or +1 * (inter)
                stack.push(inter);
                lastSign='+';
                curr = 0;
            } else if((!Character.isDigit(c) && c!=' ') ) {
                if(lastSign=='+') {
                    stack.push(curr);
                } else if(lastSign == '-') {
                    stack.push(-curr);
                }
                lastSign = c;
                curr =0;
            }
        }
        if(s.charAt(n-1) != ')') {
            if(lastSign=='+') {
                    stack.push(curr);
                } else if(lastSign == '-') {
                    stack.push(-curr);
                }
        }
        int res =0;
        while(!stack.isEmpty()) {
            res+= stack.pop();
        }
        return res;
    }
}