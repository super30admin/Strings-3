// TC:  O(N) -> N is the no. of digits of the input number
// SC : O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    String[] below20;
    String[] tens;
    String[] thousands;
  public String numberToWords(int num)
  {
      below20 = new String[]{"","One", "Two", "Three", 
                         "Four", 
                         "Five", 
                         "Six", 
                         "Seven", 
                         "Eight", 
                         "Nine", 
                         "Ten", 
                         "Eleven",
                         "Twelve", 
                         "Thirteen", 
                         "Fourteen", 
                         "Fifteen", 
                         "Sixteen", 
                         "Seventeen", 
                         "Eighteen", 
                         "Nineteen"};
      
     tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy","Eighty", "Ninety"};
      
     thousands = new String[]{"", "Thousand", "Million", "Billion"};
      
      String result = "";
      int i = 0;
      if ( num == 0)
          return "Zero";
      while ( num  > 0)
      {
          if (num % 1000 != 0) // 123,456,789
          {
              result = helper(num % 1000) + thousands[i] + " " + result;
          }
          num = num / 1000;
          i++;
      }
      return result.trim();
  }
   private String helper(int num)
   {
       // return the triplet with a space
       if ( num == 0)
           return "";
       else if ( num < 20 ) // 16
       {
           return below20[num] + " ";
       }
       else if ( num < 100)
       {
           return tens[num / 10] + " " +  helper(num % 10) ;
       }
       else
       {
           return below20[num/100] + " " + "Hundred" + " " + helper(num % 100);
       }
   }
}
