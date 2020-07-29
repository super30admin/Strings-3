// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>(); // to process the digits
        char last_sign = '+';
        int num = 0;
        int number = 0;
        
        for(int i=0;i<s.length();i++) //iterate over the string
        {
            char c = s.charAt(i); 
            
            if(Character.isDigit(c)) // if it is digit
            {
                 number = number * 10 + (c - '0'); // use to form the number 
            }
         if((!Character.isDigit(c) && c!= ' ') || i == s.length()-1) // if it is not a digit and not a space or it it is the last digit, it has to be added to stack as well
            {
                if(last_sign == '+') // checking last sign that was there and pushing number formed till that point to stack
                    stack.push(number);
                else if(last_sign == '-')
                    stack.push(-number);
                else if(last_sign == '*') //pop the last number out of stack and multiply with curr number and then add it back i.e process it
                    stack.push(stack.pop() * number);
                else if(last_sign =='/')
                    stack.push(stack.pop() / number);
                number = 0; //reset
                last_sign = c; // put last sign as curr sign
            }
        }
        int result = 0; // now just add all numbers of stack
        while(!stack.isEmpty())
        {
          result += stack.pop();  
        }
        
        return result;
    }
}

// Time Complexity : O(1) as helper has fixed 3 length number and when dividing the number in partition of 3, num can be upto billion so elngth = 4 which are constants
// Space Complexity : O(1) = length of triplet = 3 i.e constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String result = "";
        int i = 0; // to add suffix
       
        while(num > 0) // till number is greater than zero
        {
         if(num%1000 != 0) // if suffix can be present
        {
            result =  helper(num%1000) + thousands[i] + " " + result; // call helper on division of three and add suffix from thousands array based on index i
        }  
            i++; //increase i
            num = num/1000; // get front part
        }
       
        return result.trim(); //at end trim the result dur to extra space added
    }
    
    private String helper(int num)
    {
        if(num == 0) return ""; // if number has become zero string would be empty
        else if(num<20) return below_20[num] + " "; // if less than 20, get from below 20 array directly based on num
        else if(num<100) return tens[num/10] + " " + helper(num%10); // if num less than 100, then get the prefix from tens(eg 56/10 = 5 which gives fifty) and call helper on 6
        else 
            return below_20[num/100]+" Hundred "+ helper(num%100); // num = 356 then below_20 gives three (356/1000 =3) and add hundred and call helper on rest part ie. num%100
            
    }
    
}