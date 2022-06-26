// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

public class IntegerToWords {
    private String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {"", "Thousand", "Million", "Billion"};
public String numberToWords(int num) {
    if(num == 0) return "Zero";
    String result = new String();
    int i =0 ;
    while(num > 0){
        if(num % 1000 != 0){
            result = helper(num  % 1000) + thousands[i] + " " + result;
        }
        i++;
        num = num / 1000;
    }
    return result.trim();
}
private String helper(int num){
    if(num == 0) return "";
    if(num < 20)
        return below_20[num] + " ";
    if(num < 100)
        return tens[num/10] + " " + helper(num % 10);
    return below_20[num/100] + " Hundred " + helper(num %100);
}
    
}