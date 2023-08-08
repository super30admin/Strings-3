// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// We can divide this problem into sub problems of triplets.
// we need to find the english version of the 3 digit number and add the thousands place.
// to get the three digit number(987) we used a helper function if the number > 99 , we get the 100th place by /100(9) from the below20 and append hunder and call helper on num%100 (87)
// if number is less than 20 we get it from below 20 array
// if number is less than 99 (87).. we get tht tens (8) from the tens array and append the helper on (num%10)(7)
class Solution {
    static String[] below_20 ={"","One ","Two ","Three ","Four ","Five ","Six ","Seven ",
      "Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ",
      "Seventeen ","Eighteen ","Nineteen "};

    static String[] tens = {"", "Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ",
      "Seventy ","Eighty ","Ninety "};

    static String[] thousands ={"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        if(num ==0) return "Zero";
        String result = "";
        int i=0;
        while(num>0)
        {
          int triplet = num%1000;
          if(triplet!=0)
          {
              result =helper(triplet) + thousands[i] + result;
          }
          i++;
          num/=1000;
        }
        return result.trim();
    } 

    private String helper(int num)
    {
      if(num<20)
          return below_20[num];
      else if(num<100)
          return tens[num/10] + helper(num%10);
      else 
          return below_20[num/100] +"Hundred "+ helper(num%100);
  }
}