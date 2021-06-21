// Time Complexity : O(size of word)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

public class IntToEnglish {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] hundreds = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) { 

       
        if(num == 0)
            return "Zero";

        int i = 0;
        String word = "";
        while(num > 0){
            if(num % 1000 != 0)     // Edge Case -> 1,000,000   (when we have three zeros parts like for one million, billion)
                word = recur(num % 1000) + thousands[i] + " " + word;
            i++;
            num = num / 1000;
        }
        return word.trim();
    }

    public String recur(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return below_20[num] + " ";
        else if(num < 100)
            return hundreds[num/10] + " " + recur(num % 10);
        else if(num >= 100)
            return below_20[num/100] + " Hundred " + recur(num % 100);

        return "";
    }
}
