# Time Complexity : Add - O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. process the number in triplet by accesiing the list
2. Maintain list of below20, tens and thousands
'''


class Solution:
    
    below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    
    tens = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    
    thousands = ["", "Thousand", "Million", "Billion"]
    
    def numberToWords(self, num: int) -> str:
        
        if num == 0:
            return "Zero"
        
        result = ""
        i = 0
        while num > 0:
            
            if num%1000 != 0:
                result = self._helper(num%1000) + self.thousands[i] + " "+result
                
            i += 1
            num = num//1000
            
        return result.strip(" ")
        
        
    def _helper(self, num):
        
        
        if num == 0:
            return ""
        
        elif num < 20:
            return self.below_20[num] + " "
        
        elif num >=20 and num < 100:
            return self.tens[num//10] + " " +self._helper(num%10)
        
        else:
            return self.below_20[num//100] + " Hundred " + self._helper(num%100)
        
        
        