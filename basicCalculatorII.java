// TC : O(N) where N is length of the string
// SC : O(N) where we are storing calculated values on stack

import java.util.*;
public class basicCalculatorII {

	public int calculate(String s) {
		
		if(s == null || s.length() == 0)
			return 0;
		Stack<Integer> st = new Stack<>();
		int len = s.length();
		int num = 0;
		char sign = '+';  // initialize the sign function where we will be storing our previous sign values
		
		for(int i=0;i<s.length();i++) {
			
			if(Character.isDigit(s.charAt(i))) {
				num = num*10 + s.charAt(i) - '0';  //convert the character digit to number, if character digit is repeated, we can numbers as 100 or 10 os anyt length
				// so multiply previous number value by 10 and then add our current number
			}
			
			if((!Character.isDigit(s.charAt(i)) && s.charAt(i)!=' ') || i == len-1) {		
				if(sign == '+')
					st.push(num); // if sign is addition, push it on stack
				if(sign == '-') 
					st.push(-num); // of sign is '-', push -num on stack
				if(sign == '*') 
					st.push(st.pop()*num);  // if sign is *, multiply the last pushed number and current number(sign here represents previous sign, 
				// so we are multiplying the previous number and number on stack
				if(sign == '/') 
					st.push(st.pop()/num); // same as multiplication sign

				sign = s.charAt(i);  // update the sign to new so that we can use this sign to update our stack values/
				num = 0;
			}
		}
		// So, now the stack will have all the values done using +, -, * and /, now we will store our values in stack to number.
		int res = 0;
		for(int i: st) {
			res += i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		basicCalculatorII bcc = new basicCalculatorII();
		System.out.println(bcc.calculate(" 3*2+2/3"));
	}
}
