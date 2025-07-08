/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity - O(1) -> 4 triplets for Integer.Max number
                            and every triplet will go through 3 iterations so 4* 3 = O(12) ~ O(1)
Space complexity - O(1)
*/
public class IntegerToEnglishWords_LC_273 {
    String [] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20  = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String [] tens = {"", "Ten","Twenty", "Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",};
    public String numberToWords(int num) {
        if(num == 0)  {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while(num > 0) {
            int triplet = num % 1000;

            if(triplet  != 0){
                result = helper(triplet).trim() + " "+thousands[i] +" " +result;
            }
            i++;
            num = num /1000;
        }
        return result.trim();
    }

    private String helper(int curr) {
        if(curr < 20) {
            return below_20[curr];
        } else if(curr < 100) {
            return tens[curr/10] + " " + helper(curr % 10);
        } else {
            return below_20[curr/100] + " Hundred " + helper(curr % 100);
        }
    }
}