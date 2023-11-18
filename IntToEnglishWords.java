// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class IntToEnglishWords {
    class Solution {
        String[] below20;
        String[] tens;
        String[] thousands;

        public String numberToWords(int num) {
            below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
            tens = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
            thousands = new String[]{"", "Thousand", "Million", "Billion"};

            if(num == 0)
                return "Zero";

            String result = "";
            int i = 0;

            while(num > 0){
                int triplet = num % 1000;
                if(triplet != 0)
                    result = helper(triplet) +" "+thousands[i]+ " " + result;
                num = num / 1000;
                i++;
            }
            return result.trim();
        }

        private String helper(int num){
            if(num < 20){
                return below20[num];
            }
            else if(num < 100 && (num % 10 == 0)){
                return (tens[num / 10]);
            }
            else if(num < 100){
                return (tens[num / 10] +" "+ helper(num % 10));
            }
            else if(num >= 100 && (num % 100 == 0)){
                return (below20[num / 100]+" Hundred");
            }
            else{
                return (below20[num / 100] +" Hundred "+ helper(num % 100));
            }
        }
    }
}
