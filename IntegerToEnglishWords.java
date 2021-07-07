// Time Complexity : O(n) where n is number of digits in number
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : Main idea here is to use recursion for evaluating repetitive pattern. 
// The unique representations can be stored in a global array.
// Maximum integer representation in number will lie between 2-3 billion. Considering this fact, the respective checks need to be performed.

class Solution {
    private String LESS_THAN_TWENTY[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String TENS[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        //edge case
        if(num == 0) return "Zero";
        return helper(num);
    }
    
    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        if(num >= 1000000000) {
            result.append(helper(num/1000000000) + " Billion " + helper(num%1000000000));
        }
        else if(num >= 1000000) {
            result.append(helper(num/1000000) + " Million " + helper(num%1000000));
        }
        else if(num >= 1000) {
            result.append(helper(num/1000) + " Thousand " + helper(num%1000));
        }
        else if(num >= 100) {
            result.append(helper(num/100) + " Hundred " + helper(num%100));
        }
        else if(num >= 20) {
            result.append(TENS[num/10] +" "+ helper(num%10));
        }
        else {
            result.append(LESS_THAN_TWENTY[num%20]);
        }
        return result.toString().trim();
    }
}

