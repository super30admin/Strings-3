//TC: O(log n)
//SC: O(1)

class Solution {
    
    String[] oneToNineteen = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", 
        "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    
    String[] tens = {
      "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    String[] tenPowers = {
        null, "Thousand", "Million", "Billion"
    };
    
    public String numberToWords(int num) {
        
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int i = 0;
        
        while (num > 0) {
            
            int j = num % 1000;
            
            if (j != 0) {
                String curr = toWord(j).trim();

                if (tenPowers[i] == null) {
                    result =  curr + result;
                }
                else {
                    result = curr + " " + tenPowers[i] + " " + result;
                }
            }   
        
            i++;
            num /= 1000;
        }
        
        return result.trim();
    }
    
    // recursive function
    private String toWord(int num) {

        if (num <= 19) {
            return oneToNineteen[num];
        }
        
        if (num <= 99) {
            return tens[num / 10] + " " + toWord(num % 10);
        }
        
        return toWord(num / 100) + " Hundred " + toWord(num % 100);
    }
}