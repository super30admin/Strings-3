// Time Complexity : O(1) // Since at most we will go upto billion
// Space Complexity : O(1) // Although every time a new string will be created for string but that will still be constant number of time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
package Strings-3;

public class IntegertoEnglish {
    class Solution {
    
        String [] below_20 = {"","One", "Two","Three", "Four", "Five","Six","Seven", "Eight","Nine","Ten","Eleven", "Twelve", "Thirteen","Fourteen","Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"};
        String [] thousands = {"","Thousand","Million","Billion"};
        String [] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        public String numberToWords(int num) {    
        if(num ==0)
            return ("Zero");
         String result = "";
         int index = 0;
          while(num>0)
          {
              if(num%1000!=0)
              {
                  result = helper(num%1000) + thousands[index] + " " + result;
              }
              
              num = num/1000;
              index++;
          }
            return result.trim();
        }
        
        public String helper(int num)
        {
            while(num>0)
            {
                if(num==0) return "";
                else if(num<20)
                {
                    return below_20[num]+" ";
                }else if(num<100)
                {
                    return tens[num/10]+" "+helper(num%10);
                }else{                
                    return below_20[num/100]+" "+"Hundred"+" "+helper(num%100);
                }
            }
            return "";
        }
    }    
}
