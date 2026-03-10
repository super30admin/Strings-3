# Time Complexity : O(log(num)), because each digit or group is processed once
# Space Complexity : O(1), excluding output string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Break number into chunks (billions, millions, thousands, hundreds).
# 2. Convert each chunk into words using predefined maps.
# 3. Concatenate chunks with appropriate scale names and return.

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        below_20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
                    "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                    "Eighteen","Nineteen"]
        tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands = ["","Thousand","Million","Billion"]
        
        def helper(n):
            if n == 0:
                return ""
            elif n < 20:
                return below_20[n] + " "
            elif n < 100:
                return tens[n//10] + " " + helper(n%10)
            else:
                return below_20[n//100] + " Hundred " + helper(n%100)
        
        res = ""
        for i, unit in enumerate(thousands):
            if num % 1000 != 0:
                res = helper(num % 1000) + unit + " " + res
            num //= 1000
        return res.strip()