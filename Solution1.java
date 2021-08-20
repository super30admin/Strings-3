//Time complexity: O(n), where n is the number of digits in num.
//Space complexity: O(1)

class Solution {
    String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}; 
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; 
    String[] suffix = {"", "Thousand", "Million", "Billion"}; 
    public String numberToWords(int num) {
        if(num == 0) return "Zero"; 
        StringBuilder word = new StringBuilder(); 
        int i = 0; 
        while(num > 0) {
            int triplet = num % 1000; 
            if(triplet != 0) {
                word.insert(0, tripletToWords(triplet) + suffix[i]+" ");
            }
            num = num / 1000;
            i++;
        }
        return word.toString().trim();
    }
    
    public String tripletToWords(int num) {
        if(num == 0) return "";
        if(num < 20) return lessThanTwenty[num] + " "; 
        else if(num >= 20 && num < 100) return tens[num/10] + " " + tripletToWords(num%10);
        else return lessThanTwenty[num/100] + " Hundred " + tripletToWords(num%100);
    }
}