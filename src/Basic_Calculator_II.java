import java.util.*;
/***************************************Using Stack***************************************/
//Time Complexity : O(n), length of string
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/***Using stack, if we find a sign, means we are done with the number and push the number into stack along with sign
 * if the last number was a multiplication/division, we pop from the stack and multiply/divide and add to stack
 * at last we add all numbers left in the stack**/

class Basic_Calculator_II_Stack {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		char last_sign = '+';
		int number = 0;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = number * 10 + (c - '0');
			}

			if((!Character.isDigit(c) && c!= ' ') || i == s.length()-1){ //if its not a digit and not having space, or its last digit then has to be added to stack
				if(last_sign == '+')
					stack.push(number);
				else if(last_sign == '-')
					stack.push(-number);
				else if(last_sign == '*')   // if it is division/multiplication, pop the last number and perform division/multiplication with current number and push back
					stack.push(stack.pop() * number);
				else if(last_sign == '/')
					stack.push(stack.pop() / number);

				number = 0; //reset
				last_sign = c;  // put last sign as current sign
			}   
		}
		// now adding all numbers left in stack
		int result = 0;
		while(!stack.isEmpty()){
			result+= stack.pop();
		}
		return result;
	}
}

/***************************************Without Stack***************************************/
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class Basic_Calculator_II {
	public int calculate(String s) {
		if(s == null)
			return 0;
		s = s.trim();
		int sum = 0;
		long prevNum = 0;
		char last_sign = '+';

		for(int i=0; i<s.length(); i++){
			char c= s.charAt(i);
			if(c == ' ')
				continue;
			if(Character.isDigit(c)){
				int number = c - '0';
				while(i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					number = number * 10 + (s.charAt(i+1) - '0');
					i++;
				}
				if(last_sign == '+'){
					sum+= prevNum;
					prevNum = number;
				}
				else if(last_sign == '-'){
					sum+= prevNum;
					prevNum = -number;
				}
				else if(last_sign == '*'){
					prevNum = prevNum * number;
				}
				else if(last_sign == '/'){
					prevNum = prevNum/number;
				}
			}
			else
				last_sign = c; 
		}
		sum+= prevNum;
		return sum;
	}
}

/***************************************Basic Calculator-I***************************************/
/***The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces **/

//Time Complexity : O(n), length of string
//Space Complexity : O(n), length of string
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Basic_Calculator_I {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int number  = 0;
		int result = 0;
		int sign = 1;   //1 = +ve, -1 = -ve

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = number * 10 + (c - '0');
			}
			else if(c == '+'){
				result += sign * number;
				sign = 1;   //recently encountered '+' sign
				number = 0; //reset number
			}
			else if(c == '-'){
				result += sign * number;
				sign = -1;   //recently encountered '-' sign
				number = 0; //reset number
			}
			else if(c == '('){
				//push result and then sign if opening braces found
				stack.push(result);
				stack.push(sign);
				//reset sign and result, if we have to evaluate for new sub expression
				sign = 1;
				result = 0;
			}
			else if(c == ')'){
				// if its closing braces, evaluate the expression to the left
				result += sign * number;

				result *= stack.pop();//result is multiplied with sign on top of stack
				result+= stack.pop();// then added to next operand on the top
				number = 0; //reset number
			}
		}
		return result + (sign * number);

	}
}
/**************************************************************************************************/
/***stack is declared by Deque and implemented by linkedlist and 
 * whenever new sign is encountered, calculate the top of the stack with current number by last sign**/

class Basic_Calculator_I_Queue_Stack {
	public int calculate(String s) {
		Queue<Character> q=new LinkedList<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			q.add(c);   
		}
		q.add('&');
		return helper(q);
	}

	private int helper(Queue<Character> q){
		char last_sign = '+';
		int number = 0;
		Stack<Integer> stack=new Stack<>();

		while(!q.isEmpty()){
			char c=q.poll();
			if(c==' ') 
				continue;

			if(Character.isDigit(c)){
				number=number*10+(c-'0');

			}else if(c=='('){
				number=helper(q);

			}else{

				//before updating new sign, we have to put current value into the stack
				if(last_sign=='+'){
					stack.push(number);
				}else if(last_sign=='-'){
					stack.push(-number);
				}
				//else if(last_sign=='*'){
				//     stack.push(stack.pop()*number);
				// }else if(last_sign=='/'){
				//     stack.push(stack.pop()/number);
				// }
				//updating sign and num.
				number=0;
				last_sign=c;
				if(c==')') //break if its closing braces
					break;
			}

		}
		// now adding all numbers left in stack
		int result = 0;
		while(!stack.isEmpty()){
			result+= stack.pop();
		}
		return result;
	}
}

/***************************************Basic Calculator-III***************************************/
/***The expression string may contain open ( and closing parentheses ), +, - , / and * signs, non-negative integers and empty spaces **/

//Time Complexity : O(n), length of string
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


/***stack is declared by Deque and implemented by linkedlist and 
 * whenever new sign is encountered, calculate the top of the stack with current number by last sign**/

class Basic_Calculator_III_Queue_Stack {
	public int calculate(String s) {
		Queue<Character> q=new LinkedList<>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			q.add(c);   
		}
		q.add('&');
		return helper(q);
	}

	private int helper(Queue<Character> q){
		char last_sign = '+';
		int number = 0;
		Stack<Integer> stack=new Stack<>();

		while(!q.isEmpty()){
			char c=q.poll();
			if(c==' ') 
				continue;

			if(Character.isDigit(c)){
				number=number*10+(c-'0');

			}else if(c=='('){
				number=helper(q);

			}else{
				//before updating new sign, we have to put current value into the stack
				if(last_sign=='+'){
					stack.push(number);
				}else if(last_sign=='-'){
					stack.push(-number);
				}
				else if(last_sign=='*'){
					stack.push(stack.pop()*number);
				}else if(last_sign=='/'){
					stack.push(stack.pop()/number);
				}
				//updating sign and num.
				number=0;
				last_sign=c;
				if(c==')') //break if its closing braces
					break;
			}

		}
		// now adding all numbers left in stack
		int result = 0;
		while(!stack.isEmpty()){
			result+= stack.pop();
		}
		return result;
	}
}
