# Time Complexity : O(1) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        self.hundreds = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.thousands = ["", "Thousand", "Million", "Billion"]
        
        result = ''
        i = 0 
        while num > 0:
            if (num%1000) != 0:
                result = self.suffix(num%1000) + self.thousands[i] + ' '+ result
            num = num //1000
            i += 1 
        
        return result.strip()
        
    def suffix(self, num):
        if num == 0:
            return ''
        if num < 20:
            return (self.below_20[num] + ' ')
        if num < 100:
            return self.hundreds[num//10] + ' ' + self.suffix(num%10)
        if num < 1000:
            return self.below_20[num//100] + ' Hundred ' + self.suffix(num%100)
        

if __name__ == "__main__":
    s = Solution()
    res = s.numberToWords(1234567)
    print(res)
        