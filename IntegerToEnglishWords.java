
// TC - O(n)
// SC - O(n)

// 1 -19 - special case
// 10 , 20 , 30 ...etc
// 101 ~ 100 + 1 

// Loop through the words backwords
// Update the base at every 3 digits.


class IntegerToEnglishWords {
    private final String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
   private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
   private final String[] thousands  = {"", "Thousand", "Million", "Billion"};

   public String numberToWords(int num) {
       
       if(num == 0) return "Zero" ; 
   
   String result = " " ;
   int i = 0;
    while(num>0)
       {
           if(num%1000!=0)
           {
               result=helper(num%1000)+thousands[i]+" "+result;
           }
             num=num/1000;
             i++;
       }
       return result.trim();   

   
}
  private String helper(int num)
   {
       if(num==0)
           return "";

       if(num<20)
       {
           return below_20[num]+" ";
       }
       else if(num<100)
       {
           return tens[num/10]+" "+helper(num%10);
       }
       else
       {
          return below_20[num/100]+" Hundred "+helper(num%100);  
       }
   }
}
