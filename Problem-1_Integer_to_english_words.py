# APPROACH  
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Split the given number into groups of 3 from leftmost position. Have lists for numbers 1-19, all tens and all suffixes other than Hundred. 
# 2. Keep doing till num > 0. Must check if the group > 0 (Eg., 1,000,000 where all are zeros and no words for such parts). 
# 3. Call the helper function on that triple and add at the begining of the result as we are processing the triples from the left and words need to be from right. 
# 4. In helper function - if num is 0 -> return "" (Eg., 50 where I process 5 and call func on 0)
#                         if num < 20 -> access 1-19 array 
#                         if num < 100 -> access tens array + call func on units part
#                         if num btw 100 - 999 -> access 1-19 array + hundred + call func on tens and units part

class Solution:
    def __init__(self):
        self.suffix = ["", "Thousand", "Million", "Billion"]
        self.one_nineteen = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        
    def numberToWords(self, num: int) -> str:
               
        if num == 0:
            return "Zero"
        
        result, level = "", 0
        
        while num > 0:
            if num % 1000 > 0:
                result = self.helper(num % 1000) + self.suffix[level] + " " + result
            
            num = num // 1000
            level += 1
            
        return result.strip()
    
    
    def helper(self, num):
        if num == 0:
            return ""
        
        if num < 20:
            return self.one_nineteen[num] + " "
        
        elif num < 100:
            return self.tens[num // 10] + " " + self.helper(num % 10)
        
        else:
            return self.one_nineteen[num // 100] + " Hundred " + self.helper(num % 100)
            
