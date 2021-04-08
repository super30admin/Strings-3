// Time Complexity :
O(number of digits in num)
// Space Complexity :
O(1)
// Did this code successfully run on Leetcode :
Yes
// Three line explanation of solution in plain english
/*
 Split the given number into groups of three and then split this 
 three digit number further into two subproblems i.e.
 convert two digit integer and convert two digit integer
*/
// Your code here along with comments explaining your approach


class Solution {
  
        private String oneDigit(int num){
            switch(num){
            case 1: return "One";
            case 2: return "Two"; 
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
                    
            }
          return "";  
        }
        
        private String belowTwenty(int num){
            switch(num){
            case 10: return "Ten";
            case 11: return "Eleven"; 
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
                        
            }
            
            return "";
        }
        
        private String tens(int num){
            switch(num){
            case 20: return "Twenty";
            case 30: return "Thirty"; 
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
               
            }
          return "" ;
        }
        
        private String twoDigits(int num){
            if(num < 10){
                return oneDigit(num);
            }
            if(num < 20){
                return belowTwenty(num);
            }
            int digitAtTens = num/10 * 10;
            int digitAtOnes = num % 10 ;
            if(digitAtOnes == 0){
                return tens(digitAtTens);
            }
            return tens(digitAtTens) + " " + oneDigit(digitAtOnes);
        }
        
        private String threeDigits(int num){
            int digitAtHundreds = num /100;
            int remaining = num % 100;
            
            if(digitAtHundreds == 0){
                return twoDigits(remaining);
            }
            if(remaining == 0){
                return oneDigit(digitAtHundreds) + " " + "Hundred" ;
            }else{
                return oneDigit(digitAtHundreds) + " " + "Hundred"  + " " 
                    + twoDigits(remaining);
            }
        }
        public String numberToWords(int num) {
        if(num == 0){
            return "Zero" ;
        }
        int billion = num / 1000000000 ;
        num -= billion * 1000000000 ;
        int million = num / 1000000 ;
        num -= million * 1000000;
        int thousand = num /1000 ;
        num -= thousand * 1000;
            
        String res = "";
        if(billion > 0){
            res += (threeDigits(billion) + " Billion ");
        }
        if(million > 0){
            res += (threeDigits(million) + " Million ");
        }
        if(thousand > 0){
            res += (threeDigits(thousand) + " Thousand ");
        }
        if(num > 0){
            res += threeDigits(num); 
        }
         return res.strip();   
        }
}