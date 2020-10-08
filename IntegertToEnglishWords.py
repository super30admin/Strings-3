class Solution:
    # Time Complexity - O(N)
    # Space Complexity - O(N) 
    # Using Recusive approach for values below 1000 
    def __init__(self):
        self.below20 = [" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.hundred = [" "," ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = [" ", "Thousand", "Million", "Billion"]
        
    def numberToWords(self, num):
        if num == 0:
            return "Zero"
        word = ""
        i = 0
        while num > 0:
            if num % 1000 != 0:
                word = self.recurr(num%1000) + self.thousands[i] + " " + word
            i += 1
            num = num // 1000      
        return word.strip()
            
    def recurr(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num] + " "
        elif num < 100:
            return self.hundred[num//10] + " " + self.recurr(num%10) 
        elif num >= 100:
            return self.below20[num//100] + " Hundred " + self.recurr(num%100)
        
        return ""
        
        