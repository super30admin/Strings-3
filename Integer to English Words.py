# time complexity is o(1), because at maximum we could have size of num as 10, which is a constant.
# space complexity is o(1), where all the outputs can be formed from limited number of words below in code.
class Solution:
    def numberToWords(self, num: int) -> str:
        thousands = ["", "Thousand", "Million", "Billion"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        i = 0
        res = ""
        if(num == 0):
            return "Zero"
        while(num > 0):
            if(num%1000 > 0):
                res = self.helper(thousands, tens, below_20, num%1000) + thousands[i] + " " + res
            i += 1
            num = num//1000
            
        return res.strip()
            
    def helper(self, thousands, tens, below_20, num):
        if(num == 0):
            return ""
        elif(num < 20):
            return below_20[num] + " "
        elif(num < 100):
            return tens[num//10] + " " + self.helper(thousands, tens, below_20, num%10)
        else:
            return below_20[num//100] + " Hundred " + self.helper(thousands, tens, below_20, num%100)
            
        
        