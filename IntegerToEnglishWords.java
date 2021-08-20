// Time complexity: O(1)
// Space complexity: O(1)
// Run on leetcode: yes
// Issues faces: forgot about this case : if(num % 1000 != 0)

class Solution {
    String [] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String [] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String [] higher = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int i = 0;
        String res = "";
        while(num > 0){
            if(num % 1000 != 0)
             res = helper(num%1000) + higher[i] + " " + res;
            num = num/1000;
            i++;
        }
        return res.trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return below_20[num] + " ";
        else if(num < 100) return tens[num/10] + " " + helper(num%10);
        else return below_20[num/100] + " " + "Hundred" + " " + helper(num%100);
    }
}
