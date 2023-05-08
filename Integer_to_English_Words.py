# Time Complexity : O(log10(num)) 
# Space Complexity : O(1)
class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"

        singles = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        teens = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        thousands = ["", "Thousand", "Million", "Billion"]

        def convert(n):
            if n == 0:
                return ""
            elif n < 10:
                return singles[n]
            elif n < 20:
                return teens[n - 10]
            elif n < 100:
                return tens[n // 10] + " " + convert(n % 10)
            else:
                return singles[n // 100] + " Hundred " + convert(n % 100)

        result = ""
        i = 0

        while num > 0:
            if num % 1000 != 0:
                result = convert(num % 1000).strip() + " " + thousands[i] + " " + result
            num //= 1000
            i += 1

        return result.strip()
