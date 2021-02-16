// Time Complexity:O(n)
// Space Complexity:O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class IntegertoEnglishWords {
    class Solution {

        //Constants corresponding to string value of index positiong
        private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
        private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"};
        private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                "Eighty", "Ninety"};


        public String numberToWords(int num) {
            if(num == 0) return "Zero"; //edge case

            StringBuilder sb = new StringBuilder();
            int index = 0;
            //start from left to right and if num%1000 is not equal to 0, then call helper method and append to sb thousands string
            while(num > 0){
                if(num%1000 != 0){
                    StringBuilder tmp = new StringBuilder();
                    helper(tmp, num%1000);
                    sb.insert(0, tmp.append(THOUSANDS[index]).append(" "));
                }
                index++;
                num = num/1000;
            }
            return sb.toString().trim();//convert string builder to string and trim leading and trailing spaces
        }

        //helper method to return string values of less than twenty, tens, and hundred
        private void helper(StringBuilder sb, int num){
            if(num == 0){
                return;
            }else if(num < 20){
                sb.append(LESS_THAN_TWENTY[num]).append(" ");//append string to string builder for strings less than 20
                return;
            } else if(num < 100){
                sb.append(TENS[num/10]).append(" ");//append string to string builder for strings in the tens
                helper(sb, num%10);
            }else{
                sb.append(LESS_THAN_TWENTY[num/100]).append(" Hundred ");// append string to string builder for hundreds
                helper(sb, num%100);
            }
        }
    }
}