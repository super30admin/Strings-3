# Time Complexity : O(n) when n is length of string num
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No
class Solution:
    def numberToWords(self, num: int) -> str:
        under_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]

        word = ""
        i = 0

        # helper function to deal with 3 numbes at once
        def helper(num):
            if num == 0:
                return ""
            if num < 20:
                return under_20[num] + " "
            if num < 100:
                return tens[num // 10] + " " + helper(num % 10)
            else:
                return under_20[num // 100] + " Hundred " + helper(num % 100)

        if num == 0:
            return "Zero"
        # we will start from last three digits and will move forward on each iteration
        while num > 0:
            # if number is not 000 then we will call the helper function and add the word from thousands list
            if num % 1000 != 0:
                word = helper(num % 1000) + thousands[i] + " " + word
            num //= 1000
            i += 1

        return word.strip()

