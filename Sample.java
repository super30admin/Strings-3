//Time Complexity:O(n)
//Space Complexity:O(1)

class Solution {
     String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  String[] thousands = {"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num) {
    if(num == 0)
      return "Zero";
      String word = "";
      int i=0;
      while(num > 0){
          // check if all the 3 digit is 0
          if(num % 1000 != 0)
              word = helper(num % 1000) + thousands[i] + " "+ word; 
          num = num/1000;
          i++;
      }
      return word.trim();

    }
    public String helper(int num){
      if(num == 0)
          return "";
      else if(num < 20){
          return below_20[num%20] +" ";
      }
      else if(num < 100){
          return hundreds[num/10] + " "+helper(num%10);
      }
      else
          return below_20[num/100] + " Hundred "+helper(num%100);

  }

}-------------------------------------------------------------------------------------
//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
public int calculate(String s) {

       Stack<Integer> stack = new Stack();

       int i=0;

       char sign = '+';

       int temp = 0;


       while(i < s.length()){

           char c = s.charAt(i);

           if(Character.isDigit(c)){

               temp = temp * 10 + (c - '0');

           }

           if((!Character.isDigit(c)  && c != ' ') || i == s.length()-1){

               if( sign == '+' ){

                   stack.push(+temp);

               }

               else if( sign == '-'){

                   stack.push(-temp);

               }

               else if(sign == '*' || sign == '/'){

                   int p = stack.pop();

                   if(sign == '*'){ 
                       
                       stack.push(+(p*temp));
                   }
                   else
                       stack.push(+(p/temp));
               } 
                temp = 0;
                sign = c;
           }
           i++;
       }
      int ans =0;
       while(!stack.isEmpty()){
           ans += stack.pop();
       }
       return ans;
   }
}
------------------------------------------------------------------------