# 273. Integer to English Words

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        thousands = ["","Thousand","Million","Billion","Trillion"]
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
           "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        def helper(num):
            if num == 0:
                return ""
            elif num < 20:
                return below_20[num] + " "
            elif num < 100:
                return tens[num // 10] + " " + (below_20[num % 10] + " " if num % 10 != 0 else "")
            else:
                return below_20[num//100] + " Hundred " + helper(num % 100)

        i = 0
        result = ''
        while num > 0:
            triplet = num % 1000
            if triplet > 0:
                result = helper(triplet) + thousands[i] + " " + result
            i += 1
            num = num // 1000
            
        return result.strip()


        
        
        