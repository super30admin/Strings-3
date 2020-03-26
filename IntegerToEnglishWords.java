/*Time complexity : O(N) where N of digits in the input.
Space complexity : O(1) since the output is just a string.*/

class Solution {
    String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    String[] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    // this function divide number into smaller part and call helper for smaller number.  result is appended after every call ansd returned.
    public String numberToWords(int num) {
        if(num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        // for number in billion
        if(num / 1000000000 > 0) {
            sb.append(helper(num/1000000000)).append(" ").append("Billion").append(" ");
            num = num % 1000000000;
        }
        // for number in Millions
        if(num / 1000000 > 0) {
            sb.append(helper(num/1000000)).append(" ").append("Million").append(" ");
            num = num % 1000000;
        }
        //for number in thousand
        if(num / 1000 > 0) {
            sb.append(helper(num/1000)).append(" ").append("Thousand").append(" ");
            num = num % 1000;
        }
        sb.append(helper(num));
        return sb.toString().trim();   
    }
    //helper function for the driver function, it convert 3 digit or lesser  to word.
    //0 to 999
    public String helper(int num){
        if(num == 0)  return "";
        StringBuilder sb = new StringBuilder();
        if(num < 20) 
            sb.append(belowTwenty[num]);
        else if(num < 100) 
            sb.append(tens[num/10]).append(" ").append(belowTwenty[num%10]);
        else 
             sb.append(belowTwenty[num/100]).append(" ").append("Hundred").append(" ").append(helper(num%100));
        return sb.toString().trim();
    }

}
