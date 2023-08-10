# Time Complexity : O(1)
# Space Complexity : O(1)
# The code ran on LeetCode

# Divide the number into triplets by using % 1000. Process each triplet separately and combine them

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return 'Zero'
        thousands = ['', 'Thousand', 'Million', 'Billion']
        below_20 = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        tens = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

        i = 0
        result = ''

        def helper(num):
            if num < 20:
                return below_20[num]
            elif num < 100:
                return tens[num // 10] + (' ' + below_20[num % 10] if num % 10 != 0 else '')
            else:
                return below_20[num // 100] + " Hundred" + (' ' + helper(num % 100) if num % 100 != 0 else '')

        while num > 0:
            triplet = num % 1000

            if triplet != 0:
                result = helper(triplet) + (' ' + thousands[i] if triplet != 0 else '') + ' ' + result
            i += 1
            num = num // 1000
        return result.strip()
