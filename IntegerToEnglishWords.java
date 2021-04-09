// Time Complexity :O(n)
// Space Complexity :O(1)-->recursion stack would go maximum depth of 3
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    //dictionaries to append strings to our answer
    String below20[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String hundreds[] = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String thousands[] = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
      
      if(num == 0 )
      {
        return "Zero";
      }
      
      int i =0;
      String ans = "";
      
      while(num > 0)
      {
        if(num % 1000 != 0)
        { 
          //process 3 digit number starting from the end at any point
          ans = recursion(num % 1000) + thousands[i] + " " + ans;
        }
        i++;
        //get rid of the 3 digits from the end of the number
        num = num /1000;
      }
      //remove leading or trailing white spaces
       return ans.trim();
    }
    //get the words for the 3 digit number passed
    private String recursion(int num)
    {
      if(num == 0)
      {
        return "";
      }
      else if(num < 20)
      {
        return below20[num]+" ";
      }
      else if (num<100)
      {
        return hundreds[num/10]+ " " + recursion(num%10);
      }
      else if (num>=100)
      {
        return below20[num/100]+ " Hundred " + recursion(num%100);
      }
      return"";
    }
}