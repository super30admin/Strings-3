# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        i = 0
        res = ""
        nums = {
            1 : "One",
            2 : "Two",
            3 : "Three",
            4 : "Four",
            5 : "Five",
            6 : "Six",
            7 : "Seven",
            8 : "Eight",
            9 : "Nine"
        }

        less_than_20 = {
            10 : "Ten",
            11 : "Eleven",
            12 : "Twelve",
            13 : "Thirteen",
            14 : "Fourteen",
            15 : "Fifteen",
            16 : "Sixteen",
            17 : "Seventeen",
            18 : "Eighteen",
            19 : "Nineteen"
        }

        tens = {
            2 : "Twenty",
            3 : "Thirty",
            4 : "Forty",
            5 : "Fifty",
            6 : "Sixty",
            7 : "Seventy",
            8 : "Eighty",
            9 : "Ninety" 
        }
        billion = num // 1000000000
        million = (num - billion*1000000000) // 1000000
        thousand = (num - billion*1000000000 - million*1000000) // 1000
        rest = (num - billion*1000000000 - million*1000000 - thousand*1000)

        def three(n):
            three_digit = ""
            hundred = n // 100
            tens_digit = n % 100
            if hundred:
                three_digit += nums[hundred] + " Hundred "
            if tens_digit > 19:
                tens_digit //= 10
                three_digit += tens[tens_digit] + " "
                units = n % 10
                if units:
                    three_digit += nums[units] + " "
            elif tens_digit >= 10:
                three_digit += less_than_20[tens_digit] + " "
            elif tens_digit >= 1:
                three_digit += nums[tens_digit] + " "
            return three_digit
            
        if billion:
            res += three(billion) + "Billion "
        if million:
            res += three(million) + "Million "
        if thousand:
            res += three(thousand) + "Thousand "
        if rest:
            res += three(rest)
        return res.strip()


