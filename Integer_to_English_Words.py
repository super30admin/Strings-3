class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below_twenty = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.thousands = ["","Thousand", "Million", "Billion" ]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        i = 0
        result = ""
        while num > 0:
            
            #1,542
            if num % 1000 !=0:
                result = self.string_helper(num % 1000) +  self.thousands[i] + " " + result            
            i+=1
            num = num // 1000 
        
        return result.strip()    
        
        
    def string_helper(self,num):        
        
        if num == 0:
            return ""
        elif num < 20:
            return self.below_twenty[num]+ " "
        elif num < 100:
            return self.tens[num // 10] + " " + self.string_helper(num % 10)
        else:
            return self.below_twenty[num // 100] + " Hundred " + self.string_helper(num % 100)
            
