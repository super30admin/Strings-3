# problem 1 

# https://leetcode.com/problems/integer-to-english-words/

class Solution:
    thousands = ["", " Thousand ", " Million ", " Billion "]
    below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        i = 0
        result = []
        while num > 0:
            last_3 = num % 1000
            if last_3 > 0:
                result.insert(0,self.helper(last_3).strip()+ self.thousands[i])
            num //=1000
            i+=1
        return "".join(result).strip()
    
    def helper(self,num):
        result = []
        if num < 20:
            result.append(self.below_20[num])
        elif num < 100:
            result.append(self.tens[num // 10])
            result.append(" ")
            result.append(self.below_20[num % 10])
        else:
            result.append(self.below_20[num // 100])
            result.append(" Hundred ")
            result.append(self.helper(num % 100))
        return "".join(result)