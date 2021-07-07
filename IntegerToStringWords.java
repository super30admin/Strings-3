// Time Complexity : O(n)
// Space Complexity : Constant Space )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class IntegerToStringWords {
    String[] hundreds = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] thousands = new String[]{"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        String word = "";
        int i = 0;
        while(num > 0){
            if(num % 1000 != 0){
                word = helper(num % 1000) + thousands[i] + " "+ word;
            }
            i += 1;
            num = num / 1000;
        }

        return word.trim();
    }

    // num has at most three digits

    private String helper (int num){
        if(num == 0){
            return "";
        } else if(num < 20){
            return below20[num % 20] + " ";
        } else if(num < 100){
            return hundreds[num / 10] + " " + helper(num % 10);
        } else {
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
