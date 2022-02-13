# Strings-3

## Problem1 
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
 //Solution
 //Time Complexity: O(1)
 //Space Complexity: O(1)
class Solution {
    String[] zeroToNineteen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                           "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","hahaha", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] greaterThanThousand = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i =0;
        String result = "";
        while(num > 0)
        {
            if(num%1000 !=0)
            {
                // num % 1000 gets us the three digits between 0-999 to be processed for this step
                result = helper(num % 1000) + greaterThanThousand[i] + " " + result;
               
            }
            num = num/1000;
            i++;    
        }
        return result.trim();
    }
    
    private String helper(int num)
    {
        if(num ==0) return "";
        else if(num < 20) return  zeroToNineteen[num] + " ";
        else if (num <100) return tens[num/10] + " " +helper(num%10);
        else 
        {
            return zeroToNineteen[num/100] + " Hundred " + helper(num%100);
        }
    }
}
## Problem2 

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)
//Solution
class Solution {
    //Time Complexity: O(N)
    //Space Complexity:O(1)
    public int calculate(String s) {
        //checks for null or empty string 
        if( s== null || s.length() == 0) return 0;
        s= s.trim();
        int curr =0;
        int tail =0;
        int calc =0;
        char operator = '+';
        for(int i=0; i< s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curr = curr * 10  + (c-'0');
            }
            else if (Character.isWhitespace(c))
            {
                //skip
            }
            if((!Character.isWhitespace(c) && !Character.isDigit(c)) || (!Character.isWhitespace(c) && i== s.length() -1))
            {
                if(operator == '+')
                {
                    calc = calc + curr;
                    tail = curr;
                }
                else if (operator  == '-')
                {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if (operator  == '*')
                {
                    calc = calc - tail + (tail* curr);
                    tail = + (tail* curr);
                }
                else if (operator  == '/')
                {
                    calc = calc - tail + (tail/ curr);
                    tail = + (tail / curr);
                }
                curr =0;
                operator = c;
            }
        }
        
        return calc;
    }
}

