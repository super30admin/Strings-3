# Time complexity - O(1)
# Space Complexity: O(1) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Consider 3 digits at a time and handle each case accordingly.

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen","Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.below100 = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousand = ["", "Thousand", "Million", "Billion"]
        
        res = ""
        
        i = 0
        while num > 0:
            if num % 1000 > 0:
                print(num%1000)
                res = self.helper(num%1000) + self.thousand[i] + " "+ res
            num = num // 1000
            i += 1
        return res.rstrip()
    
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.below20[num] + " "
        elif num < 100:
            return self.below100[num//10] + " " +self.helper(num%10)
        else:
            return self.below20[num//100] + " Hundred " + self.helper(num%100)