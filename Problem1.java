//Time = O(1)
//Space = O(1)

class Solution {
    // Define arrays to hold the English words for numbers from 0 to 19, and for multiples of 10 up to 90
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        // Handle the case where num is 0 separately
        if (num == 0) {
            return "Zero";
        }
        
        // Call the recursive helper function to convert num to English words
        return convertToWords(num);
    }
    
    private String convertToWords(int num) {
        String result = "";
        
        // Convert billions
        if (num >= 1000000000) {
            result += convertToWords(num / 1000000000) + " Billion ";
            num %= 1000000000;
        }
        
        // Convert millions
        if (num >= 1000000) {
            result += convertToWords(num / 1000000) + " Million ";
            num %= 1000000;
        }
        
        // Convert thousands
        if (num >= 1000) {
            result += convertToWords(num / 1000) + " Thousand ";
            num %= 1000;
        }
        
        // Convert hundreds
        if (num >= 100) {
            result += convertToWords(num / 100) + " Hundred ";
            num %= 100;
        }
        
        // Convert tens and ones
        if (num < 20) {
            result += LESS_THAN_20[num];
        } else {
            result += TENS[num / 10] + " ";
            num %= 10;
            if (num != 0) {
                result += LESS_THAN_20[num] + " ";
            }
        }
        
        // Remove trailing whitespace and return the result
        return result.trim();
    }
}
