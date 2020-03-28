/*

Passed All Test Cases 
Time-> O(N). N is # of digits in nums 
Space-> O(1)
*/


class Solution {
    //arrays for values less than 20 
     String [] below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    //arrays for values in tens after 19 
    String [] tens = {"","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"} ; 
    
    public String numberToWords(int num) {
        
        //edge case
        if(num == 0)
            return "Zero" ; 
        
        //to store the final ans
        StringBuilder sb = new StringBuilder() ; 
        
        //to computer billions
        if((num / 1000000000) > 0) {
             sb.append(helper(num / 1000000000)) ;
             sb.append(" Billion ") ;
            
            //special case when num is exactly = billion 
            if(num % 1000000000 == 0)
             return sb.toString().trim();
            
             sb.append(numberToWords(num % 1000000000)) ; 
        }
        //to compute millions 
        else if((num / 1000000) > 0) {
            sb.append(helper(num / 1000000)) ; 
            sb.append(" Million ") ;
            
            //when num is = million
            if(num % 1000000 == 0)
               return sb.toString().trim() ;
            
            sb.append(numberToWords(num % 1000000)) ; 
        }  
        //to computer thousands
         else  if((num / 1000) > 0) {
            sb.append(helper(num/ 1000)) ; 
            sb.append(" Thousand ") ;
             
             //when num = 1000
             if(num % 1000 == 0)
                return sb.toString().trim() ;
             
            sb.append(helper(num % 1000)) ; 
        } 
        else
        //to compute values below 1000
        sb.append(helper(num)) ; 
        
        //returning the ans 
        return sb.toString() ; 
    }
    
    
    //helper get string number for nums < 1000
    private String helper(int num) {
        StringBuilder sb = new StringBuilder() ; 
        
        //edge case 
        if(num == 0) return "" ; 
        
        if(num < 20) {
            sb.append(below20[num]) ; 
        }
         else if(num < 100) {
            sb.append(tens[num/10]) ; 
            if(num % 10 > 0)
            sb.append(" ") ; 
            sb.append(below20[num % 10]) ; 
        }
        else {
            sb.append(below20[num / 100]) ;
            sb.append(" Hundred ") ;
            sb.append(helper(num % 100)) ; 
        }
        
        return sb.toString().trim() ; 
    }
}