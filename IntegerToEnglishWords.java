//Time Complexity : O(1) - while loop runs for a maximum of four times 
//Space Complexity : O(1)
class IntegerToEnglishWords {
    String[] thousands = {"", " Thousand ", " Million ", " Billion "};
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                             "Eighteen", "Nineteen"};
    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = 0;
        while(num > 0) {
            int triplet = num%1000;
            if(triplet != 0) {
                res = helper(triplet).trim() + thousands[i] + res;
            }
            num = num/1000;
            i++;
        }
        return res.trim();
    }
    private String helper(int num) {
        String res = "";
        if(num < 20) {
            res = below20[num];
        } else if(num < 100) {
            res = tens[num/10] +" "+ below20[num%10];
        } else {
            res = below20[num/100] + " Hundred " + helper(num%100);
        }
        return res;
    }
}