# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Iniatialize array below20, below100 and thousands.
# Define a helper function to check if the number is 0 or num < 20 or num < 100 else num is 100 or above
# Then we will get the index for each array for num below100 divide the num by 10 and calling helper function on num % 10
# For num >= 100 get the index below20 by dividing num by 100 and calling helper function on num % 100


class Solution:
    def numberToWords(self, num: int) -> str:
        below20 = [
            "", 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight',
            'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
            'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'
        ]
        below100 = [
            "", 'Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty',
            'Seventy', 'Eighty', 'Ninety'
        ]
        thousands = ["", 'Thousand', 'Million', 'Billion']
        res = ""
        if num == 0:
            return "Zero"

        def helper(num):
            if num == 0:
                return ""
            elif num < 20:
                return below20[num] + " "
            elif num < 100:
                return below100[num // 10] + " " + helper(num % 10)
            else:
                return below20[num // 100] + " Hundred " + helper(num % 100)

        i = 0
        while (num > 0):
            if num % 1000 != 0:
                res = helper(num % 1000) + thousands[i] + " " + res
            num = num // 1000
            i += 1
        return res.strip()
