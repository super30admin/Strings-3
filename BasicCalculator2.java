// Approach is to  iterate over string and check character is digit or sign. use stack to store digit and result of product and division.
//while doing multiplication and division previous no is fetched from stack.pop and current no is through iteration and result into stack again. for + and - sign push the previous no in stack.
//after iteration add values in stack.
//tc: with stack o(n)
//sc with stack:o(n)

import java.util.Stack;

public class BasicCalculator2 {
	//without stack
	    public static int calculate(String s) {
	        int sum = 0;
	        int tempSum = 0;
	        int num = 0;
	        char lastSign = '+';
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (Character.isDigit(c)) num = num * 10 + c - '0';
	            if (i == s.length() - 1 || !Character.isDigit(c) && c!=' ') {
	                switch(lastSign) {
	                    case '+':
	                        sum+=tempSum;
	                        tempSum = num;
	                        break;
	                    case '-':
	                        sum+=tempSum;
	                        tempSum = -num;
	                        break;
	                    case '*':
	                        tempSum *= num;
	                        break;
	                    case '/':
	                        tempSum /= num;
	                        break;
	                }
	                lastSign = c;
	                num=0;
	            }
	        }
	        sum+=tempSum;
	        return sum;
	    }
	


//with stack
	    public int calculate2(String s) {
	         if(s==null || ( s.length()==0)) return 0;
	        Stack<Integer> stack = new Stack<>();
	        int sum = 0;
	        int num=0;
	        char lastSign = '+';
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if(Character.isDigit(c)){
	                num = 10*num + c - '0';
	            }
	            if(!Character.isDigit(c) && c !=' ' || i==s.length()-1){
	                if(lastSign == '+') stack.push(num);
	                if(lastSign == '-') stack.push(-num);
	                if(lastSign == '*') stack.push(stack.pop()*num);
	                if(lastSign == '/') stack.push( stack.pop()/num);
	                lastSign = c;
	                num =0;
	            }
	        }
	        
	        while(!stack.isEmpty()){
	            sum = sum +stack.pop();
	        }
	        return sum;
	    }
      public static void main(String[] args) {
    	  String in = "3+4*5";
    	  int result = calculate(in);
    	  System.out.println("result is"+result);
      }
}
