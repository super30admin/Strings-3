// Time Complexity : O(1) //constant because you know there could be only specific numbers possible
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


class intToEng {
    String[] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        String result = "";
        int idx = 0;
        
        //example: 21,938
        while(num > 0){
            
            //step 1: 21,938 % 1000 = 938 so we go through
            if(num % 1000 != 0){
                
                //step 2: sending 938 through the helper method and idx = 0 so suffix is empty
                
                //accessing triplet + suffix + earlier result
                result = helper(num % 1000) + thousands[idx] + " " + result;
            }
            
            //num is now 21 because 21938 /1000 is 21 (next triplet)
            num = num/1000;
            //index is 1 so that when 21 is processed we put thousand after it as suffix
            idx++;
        }
        
        return result.trim();
    }
    
    //we are passing 938 first 
    private String helper(int num){
        if(num == 0){
            return "";
        }
        
        //pass 3: below20[8] = eight
        if( num < 20){
            return below20[num] + " ";
        }
        
        //pass 2: 38/10 = tens[3] = thirty + helper(8)
        else if(num < 100){
            return tens[num / 10] + " " + helper(num % 10);
        }
        
        //pass 1: 900/100 = 9 Hundred + helper(38)
        else{
            return below20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}