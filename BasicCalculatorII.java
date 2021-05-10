//Approach - use Stack to store the numbers in the expression and finally add them each other and return the result
//if the lastSign is + or - , store the digit as per the sign
//if the lastSign is * or /, pop the last element, perform * or / with the digit,
//                      then store it in stack
//Time Complexity - O(N) - where N is the length of String s
//Space Complexity - O(N) - where N is the length of String s

class Solution {
  public int calculate(String s) {
    if(s == null || s.length() == 0){
      return 0;
    }

    Stack<Integer> stack = new Stack<>();
    int lastSign = '+';
    int num = 0;
    int result = 0;
    for(int i=0; i<s.length(); i++){
      char ch = s.charAt(i);

      if(Character.isDigit(ch)){
        num = num*10 + (ch-'0');
      }
      if((!Character.isDigit(ch) && ch != ' ')|| i == s.length()-1){

        if(lastSign == '+'){
          stack.push(num);
        }
        else if(lastSign == '-'){
          stack.push(-num);
        }
        else if(lastSign == '*'){
          stack.push(stack.pop()*num);
        }
        else{
          stack.push(stack.pop()/num);
        }

        num = 0;
        lastSign = ch;
      }
    }

    while(!stack.isEmpty()){
      result = result+stack.pop();
    }

    return result;
  }
}
