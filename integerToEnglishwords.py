class Solution:
    # TC : O(1) 
    # SC: O(1)
    def magic(self,num:int) -> str:
        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num]
        elif num < 100:
            if num % 10 == 0:
                return self.tens[num // 10]
            return self.tens[num // 10]+" "+self.magic(num % 10)
        else:
            return self.below20[num //100] +  " Hundred" + (" " + self.magic(num % 100) if num % 100 != 0 else "")


    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        self.thousands = ["","Thousand","Million","Billion"]
        self.below20 = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        i = 0
        res = ""
        while num >0:
            digits = num % 1000
            if digits != 0:
                res = self.magic(digits)+" "+ self.thousands[i]+" "+res
            i += 1
            num = num // 1000
        return res.strip()
        