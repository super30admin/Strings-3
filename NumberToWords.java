// Time Complexity : O(1)
// Space Complexity : O(1)

class Solution {
    String[] below20 = new String[]{"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = new String[]{"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = new String[]{"", "Thousand ", "Million ", "Billion "};
    
    public String numberToWords(int num) {
        String result = "";
        int i = 0;
        if(num == 0)
            return "Zero";
        while(num != 0){
            if(num % 1000 != 0 ){
                result = helper(num % 1000)+ thousands[i] + result;
            }
            num /=  1000;
            i++;
        }
        return result.trim();
    }
    
    private String helper(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return below20[num];
        else if(num < 100)
            return tens[num / 10] + helper(num % 10);
        else
            return below20[num / 100] + "Hundred " + helper(num % 100);
    }
}