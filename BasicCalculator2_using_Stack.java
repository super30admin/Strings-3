package week8.day1;

import java.util.Stack;

//TC - O(n)
//SC - O(1)
//TC - O(n)
//SC - O(1)
class Solution14 {
  public int calculate(String s) {
      s = s.trim();
      char lastSign ='+'; 
      int curr =0; 
      Stack<Integer> stack = new Stack<>();
      for(int i=0;i<s.length();i++){
          char ch= s.charAt(i);
          if(ch==' ')
              continue;
          if(Character.isDigit(ch)){
              curr = curr*10 + ch-'0';
          }
         if(!Character.isDigit(ch) || i==s.length()-1){
        	 
              //operator
              if(lastSign=='+')
              {
            	  stack.push(curr);
              }
              else if(lastSign=='-'){
            	  stack.push(-curr);
              }
              else if(lastSign=='*'){
            	  int popped = stack.pop();
            	  stack.push(popped*curr);
              }
              else if(lastSign=='/'){
            	  int popped = stack.pop();
            	  stack.push(popped/curr);
              }
              curr =0;
        	  lastSign = ch;
          }
      }
      while(!stack.isEmpty()) {
    	  int popped = stack.pop();
    	  curr = curr+popped;
      }
      return curr;
  }

}
public class BasicCalculator2_using_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3+2*2";
		Solution ob = new Solution();
		System.out.println(ob.calculate(s));

	}

}
