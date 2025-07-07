//Time Complexity : O(1)
//Space Complexity : O(1)
class Solution {
        String[] below_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
        String[] thousands = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
      String result = "";
      int i = 0;

        while(num > 0){
            int triplet = num%1000;
            if(triplet !=0){
                result = helper(triplet).trim() + " " +thousands[i] + " "+ result;
            }
            i++;
            num = num/1000;
        }
        return result.trim();
    }
    private String helper(int curr){
        if(curr < 20){
            return below_20[curr];
        } else if(curr < 100){
            return tens[curr/10] + " "+ helper(curr%10);
        } else {
            return below_20[curr/100] + " Hundred " + helper(curr%100);
        }
    }
}
