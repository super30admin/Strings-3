# Time Complexity: O(1)
# Space Complexity: O(1)

class Solution:
    def numberToWords(self, num: int) -> str:
        # base
        if num is None:
            return ""
        
        # logic
        below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        lst = ["", "THOUSAND", "MILLION", "BILLION"]
        result = ""
        cnt = 0

        def helper(number):
            if number == 0:
                return ""
            elif number < 20:
                return below_20[number] + " "
            elif number < 100:
                return tens[number / 10] + " " + helper(number % 10)
            else:
                return below_20[num / 100]

        while num > 0:
            if num % 1000 != 0:
                result = helper(num % 1000) + lst[cnt] + "" + result

            num = num / 1000
            cnt += 1
        
        return result.trim()