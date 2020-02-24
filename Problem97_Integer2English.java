//Time Compexity: O(n)
//Sapce Complexity: constant space

class Solution {
    //creating strings for respective numbers
    String[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                        "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                         "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                     "Eighty","Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        //for zero
        if(num == 0)
            return "Zero";
        
        String word = "";
        int i = 0;
        
        while(num > 0){
            if(num % 1000 != 0){
                //call helper for the remainder
                word = helper(num % 1000)+thousands[i]+" "+word;
            }
            //increment each time
            i++;
            num/= 1000;
        }
        return word.trim();
    }
    
    public String helper(int num){
        //if One's place has zero, return space
        if(num == 0)
            return "";
        else if(num < 20)
            //call below_20 and add spce
            return below_20[num]+" ";
        else if(num < 100)
            //call tens string with helper function again on remaining digits
            return tens[num/10]+" "+ helper(num%10);
        //else the num is greater or equal to hundred's
        else return below_20[num/100]+" Hundred "+ helper(num%100);
    }
}