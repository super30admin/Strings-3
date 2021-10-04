class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operation = '+';
        int lastInt = 0;
        for(char a: s.toCharArray()) {
            if(a == ' ') continue;
            if(Character.isDigit(a)) {
               lastInt = lastInt * 10 + Character.getNumericValue(a);
                continue;
            }
            switch(operation) {
                case '+':
                    stack.push(lastInt);
                    break;
                case '-':
                    stack.push((-1)*lastInt);
                    break;
                case '*':
                    int temp = stack.pop();
                    stack.push(temp*lastInt);
                    break;
                case '/':
                    int temp1 = stack.pop();
                    stack.push(temp1/lastInt);
                    break;
                default:
                    break;
            }
            operation = a;
            lastInt = 0;
        }
        switch(operation) {
                case '+':
                    stack.push(lastInt);
                    break;
                case '-':
                    stack.push((-1)*lastInt);
                    break;
                case '*':
                    int temp = stack.pop();
                    stack.push(temp*lastInt);
                    break;
                case '/':
                    int temp1 = stack.pop();
                    stack.push(temp1/lastInt);
                    break;
                default:
                    break;
            }
        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        
        return answer;
    }
}