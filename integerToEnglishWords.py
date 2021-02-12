# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : How to fix extra white 
# space at the end.. eventually used rstrip()



# Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.belowTwenty = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        
        self.thousands = ["", "Thousand", "Million", "Billion"] 
        
        
    def numberToWords(self, num: int) -> str:
        """
        evaluate every triplet of a number... 
        with each triplet.. we process the number, find appropriate suffix and add to res string
        """
        
        res = deque([]) 
        if num == 0:
            return "Zero"
        i = 0 #index 
        while num > 0:
            if num % 1000 != 0:
                #append left since we are processing every right three
                res.appendleft(self.helper(num%1000) + self.thousands[i] + " ")
                
            num = num // 1000
            #since we process every right three aka every thousands..gotta increment i
            i+=1
        
        return ''.join(res).rstrip()
    
    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.belowTwenty[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num % 10)
        else:
            return self.belowTwenty[num // 100] + " " + "Hundred" + " " + self.helper(num % 100)