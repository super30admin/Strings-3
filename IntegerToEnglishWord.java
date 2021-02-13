class IntegerToEnglishWord {
        /*
          Time  : O(1) | Highest is Integer.MAX 
          Space : O(1) 
          Leetcode : YES
        */ 
        String[] below_twenties = {"","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
        String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        
        if(num == 0) return "Zero"; 
        String result  = "";
        int i = 0;
        while(num > 0){
             if(num % 1000 != 0){
                 result = helper(num%1000) + thousands[i] + " " + result;
             }
            num /= 1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String helper(int num) {
        String result = "";
        if(num == 0) return "";
        else if(num < 20){
          return  result += below_twenties[num] + " "; 
        }else if(num < 100){
           return result += tens[(num/10)] + " "  + helper(num%10);
        }else{
           return result += below_twenties[(num/100)] + " Hundred " +  helper(num%100);
        }
       
    }
}
