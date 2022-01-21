// Time Complexity : O(1) number is divided by 1000 times each time : So, 4 triplets at max as billion is max value of num
// Space Complexity : O(1) constant space as the hashsets are fixed length

class Solution {
    
    // "" : Added for every hashset to match the correct index as per the number
    // Hashsets of 0-19 and 10 multiples
    // 0-19 
    String[] below20s = {"", "One" , "Two" , "Three" , "Four" , "Five" , "Six", "Seven" , "Eight" , "Nine" , "Ten", "Eleven" , "Twelve" , "Thirteen" , "Fourteen" , "Fifteen", "Sixteen", "Seventeen", "Eighteen" , "Nineteen" }; 
        
    // 10 -90 only 10 multiples 
    String[] tens = { "" , "Ten", "Twenty" , "Thirty" , "Forty" , "Fifty" , "Sixty" , "Seventy" , "Eighty", "Ninety" };
    
    // suffix to add for every triplet
    String[] suffix = { "" , "Thousand " , "Million " , "Billion " }; // space internally added
    
    String result = "";
    public String numberToWords(int num) {
         
        if (num == 0){
            return "Zero";
        }
        
        int place = 0; 
        
        // recursively call for all the triplets
        while (num  > 0 ) {
            
            // started from last triplet to first , So append at last
            
            // For num is multiple of 1000s then we can go directly to the next triplet
            if (num % 1000 != 0 ){ 
                result = helper(num % 1000) + suffix[place]  + result;
            }
            
            num = num / 1000;
            
            place++;
        }
        
        // remove the last space
        return result.trim();
    }
    
    
    public String helper (int num){
        
        if (num == 0){
            return "";
        }
        
        // 0- 19
        if (num < 20) {
            return below20s[num] + " ";
        }
        
        // 20- 99
        else if (num < 100){
            return tens[num / 10] +  " "  + helper(num % 10);
        }
        
        // > 100
        else {
            return below20s[num/100] + " Hundred " + helper(num % 100);
        }
    }
}