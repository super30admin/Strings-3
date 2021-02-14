// Time Complexity : O(n) n = length of str
// Space Complexity : O(1) arrays are constant size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
//Maitain arrays for distinct digits 1- 10, tens and thousands
// Process each triplet and appends from thousands array


class Solution {
    public String numberToWords(int num) {

        String[] thousands = new String[] {"", "Thousand", "Million", "Billion"};

        if(num == 0) return "Zero";

        String result = "";
        int i = 0;
        while(num > 0) {
            if(num % 1000 != 0 ) {
                result = processTriplet(num % 1000).trim() + " " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();

    }

    String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = new String[] {"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String processTriplet(int num) {
        if(num == 0) return "";

        if(num < 20) {
            return digits[num];
        }
        else if (num < 100) {
            return tens[num/10] + " " + processTriplet(num%10);
        } else {
            return digits[num/100] + " Hundred " + processTriplet(num%100);
        }


    }

}
