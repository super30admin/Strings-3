/*
class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.below100 = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousand = ["", "Thousand", "Million", "Billion"]
        
        result = ""
        
        i = 0
        while num > 0:
            if num % 1000 > 0:
                print(num%1000)
                result = self.helper(num%1000) + self.thousand[i] + " "+ result
            num = num // 1000
            i += 1
        return result.rstrip()
    
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num] + " "
        elif num < 100:
            return self.below100[num//10] + " " +self.helper(num%10)
        else:
            return self.below20[num//100] + " Hundred " + self.helper(num%100)
*/
// Time - O(n) where n is no of digits
// Space - O(1) since helper will run max 3 times for every triplet and rest is constant space
// Logic - Stripping down 3 digits at a time and handled different cases as per output

class Solution {
    String[] below20, below100, thousand;
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        below20 = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        below100 = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        thousand = new String[] {"", "Thousand", "Million", "Billion"};
        
        int i=0;
        String result = "";
        while (num > 0){            // O(n/3) since we are stripping down by  digits
            if (num % 1000 > 0){
                result = helper(num%1000) + thousand[i] + " "+ result;  
            }
            num = num / 1000;
            i++;
        }
            
        return result.trim();  
         
    }
    private String helper(int num){         // for every triplet it will run max 3 times
        if (num == 0)
            return "";
        
        else if (num < 20)
            return below20[num] + " ";
            
        else if (num < 100)
            return below100[num/10] + " " + helper(num%10);
            
        else
            return below20[num/100] + " Hundred " + helper(num%100);
    }
}
        