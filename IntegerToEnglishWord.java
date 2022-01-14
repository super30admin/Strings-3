// Time Complexity: O(n) -> O(2 ^32 -1) -> O(1)
// Space Complexity: array + recursive call for triplets - > O(1)
public class IntegerToEnglishWord {
    String [] below_20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                                       "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String [] below_100 = new String[] {"", "Ten","Twenty", "Thirty" , "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String [] thousands = new String[] {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String result = "";
        int i = 0;
        while(num > 0)
        {
            if(num % 1000 != 0) // find the triplet location
            {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            num = num /1000;
            i++;
        }
        return result.trim();
    }
    
    private String helper(int num)
    {
        if(num == 0)
            return ""; // because we do not use zero in string rep 
        else if(num < 20)
        {
            return below_20[num] + " "; 
        }
        else if(num < 100)
        {
            // we need to call helper since num%10 could be 0 or below_20
            return below_100[num/10] + " " + helper(num %10);
        }
        else
        {
            return below_20[num/100] + " Hundred "+ helper(num % 100);
        }   
    }
}
