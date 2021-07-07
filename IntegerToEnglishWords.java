// 273.
// time - O(n)
// space - constant
class Solution {
    
        String[] below20s = {"", "One", "Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] hundreds = {"", "", "Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        //edge
        if(num == 0)
        {
            return "Zero";
        }
        String word = "";
        int i = 0;
        while(num > 0) // eg - num = 123,456
        {
            if(num % 1000 > 0) //process 456 to get four hundred fifty six
            {
                word = helper(num % 1000) + thousands[i] + " "+ word;
            }
            i += 1; //in the next iteration num becomes 123
            num = num / 1000;
        }
        return word.trim();
    }
    
    //helper method processes and returns the english words for 3 digit numbers or less
    private String helper(int num) {
        if(num == 0)
        {
            return "";
        }
        else if(num < 20) //eg - num = 14 - return 14th index in below20s array
        {
            return (below20s[num] + " ");
        }
        else if(num < 100) //eg - num = 24 - answer = hundres[2] + helper(4)
        {
            return hundreds[num / 10] + " " + helper(num % 10);
        }
        else //eg - num = 999 - answer = below20s[9] + Hundred + helper(99);
        {
            return below20s[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
