class Solution {
     private final String[] belowtwenty = {"" ,"One" , "Two" , "Three" , "Four" , "Five" ,"Six" ,"Seven" , "Eight" , "Nine" , "Ten" , "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen" , "Sixteen" , "Seventeen" , "Eighteen" ,"Nineteen" };
        private final String[] thousands = {"", "Thousand" , "Million" ,"Billion"};
        private final String[] tens = {"" , "Ten" , "Twenty" , "Thirty" , "Forty" , "Fifty" , "Sixty" , "Seventy" , "Eighty" , "Ninety" };
    public String numberToWords(int num) {
       
        if(num == 0){
            return "Zero";
        }
        String result = "";
        int i = 0; //first triplet is at 0 index , so on
        while(num > 0){
            int triplet = num % 1000;
            if(triplet!=0){
                result = helper(triplet).trim() + " "+ thousands[i] + " " + result;

            }
            i++;
            num = num / 1000;
        }
        return result.trim();
        
    }
    private String helper(int curr){
        if(curr < 20){
            return belowtwenty[curr] + " ";
        }
        else if(curr < 100){
            return tens[curr/10] + " " + helper(curr % 10); 
        }
        else {
            return belowtwenty[curr / 100] + " Hundred " + helper(curr % 100);

        }
    }
    
}