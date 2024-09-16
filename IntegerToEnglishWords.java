// Time Complexity: O(n), where n is the number of digits
// Space Complexity: O(1)

class Solution {
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    // this function divide number into smaller part and call helper for smaller number. 
    // result is appended after every call ansd returned.
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String word = "";
        // B
        if(num / 1000000000 > 0) {
            word = (helper(num/1000000000)).trim() + " " + "Billion";
        }
        num = num % 1000000000;
        if(num / 1000000 > 0) {
            word = word + " " + (helper(num/1000000)).trim() + " " + "Million";
        }
        num = num % 1000000;
        if(num / 1000 > 0) {
            word = word + " " + (helper(num/1000)).trim() + " " + "Thousand";
        }
        num = num % 1000;
        word = word + " " + (helper(num)).trim();
        return word.trim();
    }
  // helper function for the driver function, it convert 3 digit or lesser  to word.
    // 0 to 999
    public String helper(int num){
        if(num == 0) { 
            return "";
        }    
        if(num < 20) {
            return below_20[num];
        } 
        if(num < 100) { 
            return tens[num/10] + " " + below_20[num%10];
        }
        return (below_20[num/100] + " " + "Hundred" + " " + helper(num%100)).trim();
    }
}