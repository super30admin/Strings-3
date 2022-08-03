# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def numberToWords(self, num: int) -> str:
        under_twenty = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten',
                       'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen',
                       'Nineteen']
        under_hundred = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']
        under_thousand = ['Thousand', 'Million', 'Billion']

        def toWords(num):
            if num == 0:
                return []
            if num < 20:
                return [under_twenty[num]]
            if num < 100:
                quotient = num // 10
                remainder = num % 10
                # toRet = [under_hundred[quotient]] + toWords(remainder)
                # print("To Ret: ", toRet)
                return [under_hundred[quotient]] + toWords(remainder)
            if num < 1000:
                quotient = num // 100
                remainder = num % 100
                return [under_twenty[quotient], 'Hundred'] + toWords(remainder)
            for power, thousand in enumerate(under_thousand, 1):
                if num < 1000 ** (power + 1):
                    quotient = num // 1000 ** power
                    remainder = num % 1000 ** power
                    return toWords(quotient) + [thousand] + toWords(remainder)
        return ' '.join(toWords(num)).strip() or 'Zero'
