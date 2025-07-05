# Time complexity: O(log n)
# Space complexity: O(log n)

class Solution:
    def numberToWords(self, num):
        if num == 0:
            return "Zero"

        belowTen = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        belowTwenty = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        belowHundred = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        def helper(num):
            if num < 10:
                return belowTen[num]
            elif num < 20:
                return belowTwenty[num - 10]
            elif num < 100:
                return belowHundred[num // 10] + (" " + helper(num % 10) if num % 10 != 0 else "")
            elif num < 1000:
                return helper(num // 100) + " Hundred" + (" " + helper(num % 100) if num % 100 != 0 else "")
            elif num < 1000000:
                return helper(num // 1000) + " Thousand" + (" " + helper(num % 1000) if num % 1000 != 0 else "")
            elif num < 1000000000:
                return helper(num // 1000000) + " Million" + (" " + helper(num % 1000000) if num % 1000000 != 0 else "")
            else:
                return helper(num // 1000000000) + " Billion" + (" " + helper(num % 1000000000) if num % 1000000000 != 0 else "")

        return helper(num)
