//Time Complexity: O(1) , 12 operations we cam have in total. Total 4 triplet and each triplet has max 3 operations

class Solution {
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }

        String result = "";
        int i=0;
        while(num >0){
            int triplet = num % 1000;
            if(triplet != 0){
                result = helper(triplet).trim() + " " + thousands[i] + " " + result;
            }
            i++;
            num = num /1000;
        }
        return result.trim();    
    }

    public String helper(int curr){
        if(curr < 20){
            return below_20[curr];
        }
        else if(curr < 100){
            return tens[curr/10] + " " + helper(curr%10);
        }
        else{
            return below_20[curr/100] + " Hundred " + helper(curr %100);
        }
    }
}