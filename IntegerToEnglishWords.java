/*
This solution splits up the integer into triplets, and processes the triplets recursively and individually before 
combining them for the final solution. String arrays of all the unique number words are used to achieve this.

Did this code run on leetcode: Yes
*/
class Solution {
    //An array for all the numbers below 20 are used since they are all unique
    String[] below20 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    //All the 2 digit multiples of 10 have unique words, so we use an array for these as well
    String[] tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    //And finally, the triplets have unique names to be stored
    String[] triples = {"", "Thousand ", "Million ", "Billion "};
    
    //Time Complexity: O(1) since we can only process a maximum of 10 numbers due to the integer range limit
    //Space Complexity: O(1) as we have a set amount of unique words
    public String numberToWords(int num) {
        
        if(num == 0)
            return "Zero";
        
        String result = "";
        int i = 0;
        
        while(num > 0)
        {
            int curr = num % 1000;
            //If the current triplet has only zeroes, we disregard the triplet
            if(curr != 0)
                result = helper(curr) + triples[i] + result;
            
            num /= 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String helper(int curr)
    {
        if(curr >= 100)
            return below20[curr / 100] + "Hundred " + helper(curr % 100);
        
        else if(curr >= 20)
            return tens[curr / 10] + helper(curr % 10);
        
        else if(curr < 20 && curr > 0)
            return below20[curr];

        else
            return "";
    }
}