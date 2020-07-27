class Solution:
    """
        Name : Shahreen Shahjahan Psyche
        Time : O(1) 
        Space: O(1) 


        Passed all Test cases in LC : Yes
    """
    
    def __init__(self):
        
        
        
        self.first_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", 
                         "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                         "Thirteen","Fourteen", "Fifteen", "Sixteen", 
                         "Seventeen", "Eighteen", "Nineteen"]
        self.hundreds = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]
        
        
    
    def processThreeDigits(self, num):
        
        if num == 0:
            return ""
        elif num < 20 :
            return self.first_20[num] + " "
        elif num < 100:
            return self.hundreds[int(num/10)] + " " + self.processThreeDigits(int(num%10))
        else:
            return self.first_20[int(num/100)] + " Hundred " + self.processThreeDigits(int(num%100))       
    
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        
        i = 0
        res = ""
        while num > 0:
            process = num%1000
            if process != 0:
                res =   self.processThreeDigits(process) + self.thousands[i] + " " + res
            num = int(num/1000)
            i += 1
            
        return res.strip()
        
