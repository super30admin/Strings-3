# Strings-3

## Problem1 
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
 
//Time Complexity = O(1)
//Space Complexity = O(1)

class Solution {
    
      String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", 
                           "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", 
                           "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousand = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = ""; 
        int i = 0;
        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousand[i] + " " + result; 
            }
            num = num / 1000; 
            System.out.println(num); 
            i++; 
        } 
        return result.trim();
    }
    
    private String helper(int num){
        //System.out.println(num); 
        if(num == 0) return ""; 
        else if(num < 20) return below_20[num] + " "; 
        else if(num < 100) return ten[num/10] + " " + helper(num % 10); 
        else return below_20[num/100] + " " + "Hundred" + " " + helper(num % 100); 
    }
}
## Problem2 

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

//time complexity = O(n)
//Space complexity = O(n)

class Solution {
    public static int calculate(String s) {
         //Base
         if(s == null || s.length() == 0) return 0;
         Stack<Integer> stack = new Stack<>();
         s = s.trim();
         int result = 0;
         int num = 0;
         char lastSign = '+';
         for(int i = 0; i < s.length() ; i++) {
             char c = s.charAt(i);
             if(Character.isDigit(c)) {
                 num = num * 10 + c - '0';
             }
             if(c != ' ' && (!Character.isDigit(c) || i == s.length() - 1)) {
                 if(lastSign == '+') stack.push(num);
                 else if(lastSign == '-') stack.push(-num);
                 else if(lastSign == '*') stack.push(stack.pop() * num);
                 else stack.push(stack.pop() / num);
                 lastSign = c;
                 num = 0;
             }
         }

         while(!stack.isEmpty()) {
             result += stack.pop();
         }
         return result;
     }
}
