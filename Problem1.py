# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#  
class Solution:
    def numberToWords(self, num: int) -> str:
        below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]
        below100 = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        parts = ["Hundred", "Thousand", "Million", "Billion"]

        if num == 0:
            return "Zero"

        def helper(num):
            nonlocal below20, below100, parts

            if num < 20:
                return below20[num]
            if num < 100:
                return below100[num//10] + (" " if num%10 else "") + helper(num%10)
            if num < 1000:
                return helper(num//100) + " " + parts[0] + (" " if num%100 else "") + helper(num%100)
            if num < 1000000:
                return helper(num//1000) + " " + parts[1] + (" " if num%1000 else "") + helper(num%1000)
            if num < 1000000000:
                return helper(num//1000000) + " " + parts[2] + (" " if num%1000000 else "") + helper(num%1000000)
            else:
                return helper(num//1000000000) + " " + parts[3] + (" " if num%1000000000 else "") + helper(num%1000000000)
        
        return helper(num).strip()