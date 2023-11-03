'''
        
        num = 110, 432, 986
        
        res = ""
        SI = 0
        
        curr = "Nine Hundred Eighty Six"
        
        next iteration
        num = 110, 432
        SI = 1
        res =  "Nine Hundred Eighty Six"
        curr = "Four Hundred Thirty Two"
        
        next iteration
        num = 110
        SI = 2
        res = "Four Hundred Thirty Two Thousand Nine Hundred Eighty Six"
        curr = "One Hundred ten"
        
        next iteration
        num = ""
        SI = 3
        res = "One Hundred ten Million Four Hundred Thirty Two Thousand Nine Hundred Eighty Six"
'''

class Solution:
    def numberToWords(self, num: int) -> str:
        belowTwenty = ["", "One", "Two", "Three", "Four", "Five", "Six", 
                       "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", 
                       "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        tens = [ "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        suffix = ["", "Thousand", "Million", "Billion", "Trillion"]
        
        def numbersToWord(num):
            if num == 0:
                return "Zero"
            
            suffixIndex = 0
            res = ""
            
            while num > 0:
                curr = toWords(num%1000).strip()
                
                if curr:
                    res = (curr +" "+ suffix[suffixIndex] +" "+res).strip()
                
                suffixIndex +=1 
                num = num//1000
            
            return res
        
        
        def toWords(num):
            if num <= 19:
                return belowTwenty[num]
            elif num<=99:
                return tens[num//10] +" "+ toWords(num%10)
            else:
                return toWords(num//100) + " Hundred " + toWords(num%100)
            
        return numbersToWord(num)
            
        