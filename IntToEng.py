# TC - O(n) => num
# SC - O(1)
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        one_to_twenty = ["", "One", "Two", "Three", "Four", "Five", "Six",
                         "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                         "Seventeen", "Eighteen", "Nineteen"]
        tens = ["", "Ten", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        hundreds = ["", "Thousand", "Million", "Billion"]

        if num == 0:
            return "Zero"

        def word(num):

            if num == 0:
                return ""

            if num < 20:
                return one_to_twenty[num] + " "

            elif num < 100:
                return tens[num/10] + " " + word(num % 10)

            else:
                return word(num/100) + "Hundred " + word(num % 100)

        i = 0
        result = ""

        while(num > 0):

            if (num % 1000 != 0):
                result = word(num % 1000) + hundreds[i] + " " + result

            num = num / 1000
            i = i + 1

        return result.strip()
