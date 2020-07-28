
"""
// Time Complexity : o(1) , constant
// Space Complexity : o(1), constant
// Did this code successfully run on Leetcode : not on leetcode
// Any problem you faced while coding this : no
"""
class Solution:
    def helper(self, num):
        
        if num == 0:
            return ""
        if num < 20:
            return self.below_20[num] + " " 
        
        elif num < 100:
            return self.tens[int(num/10)]  + " " + self.helper(int(num%10))
        
        else:
            return self.below_20[int(num/100)] + " Hundred " + self.helper(int(num%100))
        
    
    
    def numberToWords(self, num: int) -> str:
        self.below_20 = ["","One","Two", "Three","Four", "Five", "Six", "Seven", "Eight","Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        
        self.tens = ["","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        self.thousands = ["", "Thousand", "Million", "Billion"]
        
        if num == 0:
            return "Zero"

        res = ""
        i = 0 #for thousands list
        
        while num != 0:
            if num % 1000 != 0: #helps in considering 3 digits at a time, the pattern is repeated at every 3 digits
                res = self.helper(num % 1000) + self.thousands[i] + " " + res #iterating over the thousands array
                
            i = i + 1 #pointer in thousands array
            num = int(num/1000) #update number
    
        return res.strip(" ")
