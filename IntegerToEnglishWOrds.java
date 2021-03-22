/**
 * TC: O(N)
 * SC: O(1) recursive stack space does not grow with input
 * Approach: DIVIDE AND CONQUER
 *             Divide the number into triplets, conquer (solve) the triplets and then process the next triplet
 *             7123456789
 *              789
 *              567 Thousand
 *              123 Million
 *                7 Billion
 *            Process the triplets from right, append thousand/million, billion depending upon the num and prepend the result to the result of next triplet
 *            Prepend operation becuase numbers are processed from right to left but numbers are read from left to right
 */

class Solution {
    String[] belowTwenty;
    String[] tens;
    String[] thousands;
    
    public String numberToWords(int num) {
        belowTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        tens = new String[] {"", "", "Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        thousands = new String[] {"", "Thousand", "Million", "Billion"};
        
        if(num == 0) {
            return "Zero";
        }
        
        int i = 0;
        String result = new String();
        
        while(num > 0) {
            // if there is a triplet to process
            if(num % 1000 > 0) {
                result = processTriplet(num % 1000) + thousands[i] + " " + result;
            }
            
            i++;
            num = num / 1000;
        }
        
        return result.trim();
    }
    
    private String processTriplet(int num) {
        // 0
        if(num == 0) {
            return  "";
        }
        // 1-19
        else if(num < 20) {
            return belowTwenty[num] + " ";
        }
        // 20 - 99
        else if(num < 100) {
            return tens[num / 10] + " " + processTriplet(num % 10);
        }
        // 100 - 999
        else {
            return belowTwenty[num / 100]  + " Hundred " + processTriplet(num % 100);
        }
    }
}
