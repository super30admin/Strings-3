# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The number is divided up into groups of three digits. These groups of three are translated through the defined lists. 
"""

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == None: return ''
        if num == 0: return 'Zero'

        self.below20 = ["","One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.thousands = ["", "Thousand", "Million", "Billion"]
        self.tens = ["","Ten","Twenty","Thirty","Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        result = ""
        i = 0

        while num > 0:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + " " + self.thousands[i] + " " + result
            num = num // 1000
            i = i + 1

        return result.strip()

    def helper(self, num):
        if num == 0: return ""
        elif num < 20:
            return self.below20[num]
        elif num < 100:
            return (self.tens[num // 10] + " " + self.below20[num % 10]).strip()
        else:
            return (self.below20[num // 100] + " Hundred " + self.helper(num % 100)).strip()