# Time Complexity:
# O(1) 

# Space Complexity:  
# O(1)   


class Solution(object):
    def __init__(self):
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
                    "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                    "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
               "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]

    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"

        i = 0
        result = ""   # return this string
        while(num>0):
            if num%1000 != 0:
                result = self.recurse(num%1000) + self.thousands[i] + " " + result
            i += 1
            num = num/1000
        
        return result.strip()
    


    def recurse(self, num):
        if num == 0:
            return ""

        elif num < 20:
            return self.below_20[num] + " "

        elif num < 100:
            return self.tens[num/10] + " "+ self.recurse(num%10)
        
        else:
            return self.below_20[num/100] + " Hundred " + self.recurse(num%100)
