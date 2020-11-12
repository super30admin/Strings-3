class Solution {// time of O(N) and space of O(1)
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"","", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String word = "" ;
        int idx = 0 ;
        
        while (num > 0){
            // two possibilities
            if(num % 1000 != 0){
               word = helper(num % 1000) + thousands[idx] + " " + word ; 
            }
            num = num / 1000;
            idx++;
        }
        return word.trim();
    }
    private String helper(int num){
        // nums < 20
        // nums <100
        if(num == 0)
            return "";
        else if(num < 20)
            return below20[num] + " ";
        else if(num < 100)
            return tens[num/10] + " " + helper(num%10) ;
        else
            return below20[num / 100] + " Hundred " + helper(num%100);
    }
}