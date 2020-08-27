// Time O(n) where n = number of digits
// Space O(1) O(size of answer) auxillary space
class Solution {
    
    StringBuilder result=new StringBuilder();
    
    public String numberToWords(int num) {
        
    if(num==0)
        return "Zero";
        
    String[] tensNames = {
    "",
    "Ten",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety" };
        
    String[] numbers = {
    "",
    "One",
    "Two",
    "Three",
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
    "Nineteen"
  };
        
        
        /* Billion */
       if(num>=(1000000000))
       {
          numberToWords(num/(1000000000));
          result.append(" Billion");
          if(num%1000000000!=0)
                result.append(" ");
          numberToWords(num%(1000000000));
       } 
        else if(num>=(1000000))
       {
           numberToWords(num/1000000);
           result.append(" Million");
           if(num%1000000!=0)
                result.append(" ");
           numberToWords(num%(1000000));
       }
        else if(num>=1000)
        {
            numberToWords(num/1000);
            result.append(" Thousand");
            if(num%1000!=0)
                result.append(" ");
            numberToWords(num%(1000));
        }
        else if(num>=100)
        {
            result.append(numbers[num/100]+" Hundred");
            if(num%100!=0)
                result.append(" ");
            numberToWords(num%100);
        } 
        else if(num>=20)
        {
            result.append(tensNames[num/10]);
            if(num%10!=0)
                result.append(" ");
            numberToWords(num%10);
        }
        else if(num>=1)
        {
            result.append(numbers[num]);
        }
        else if(num<0)
        {
            result.append("Negative ");
            numberToWords(num*-1);
        }
        
       return result.toString();
    }
}