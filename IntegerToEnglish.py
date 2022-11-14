class Solution:
    def numberToWords(self, num: int) -> str:
        
        thousands = ["", "Thousand", "Million", "Billion"]
        
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        tens = ["","Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        def helper(number):
            
            if number == 0:
                return ""
            
            if number < 20:
                return below_20[number % 20] + " "
            elif number < 100:
                return tens[number//10] + " " + helper(number%10)
            else:
                return below_20[number//100] + " Hundred " + helper(number%100)
                
            
        i = 0  
        result = ""
        
        if num == 0:
            return "Zero"
        
        while num > 0:
            if (num % 1000) != 0:
                result = helper(num % 1000) + thousands[i] + " " + result
                
            num = num // 1000
            i += 1
        
        
        return result.strip()
    
    # Time Complexity: O(n) where n is the length of the string
    # Space Complexity: O(1)